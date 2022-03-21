package photogram.cos.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import photogram.cos.config.auth.PrincipalDetails;
import photogram.cos.service.SubscribeService;
import photogram.cos.web.dto.CMRespDto;

@RequiredArgsConstructor
@RestController
public class SubscribeApiController {

    private final SubscribeService subscribeService;

    @PostMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> subscribe(@AuthenticationPrincipal PrincipalDetails principalDetails,
                                       @PathVariable int toUserId) {

        subscribeService.구독하기(principalDetails.getUser().getId(), toUserId);
        return new ResponseEntity<>(
                new CMRespDto<>(1, "subscribe complete", null),
                HttpStatus.OK
                );
    }

    @DeleteMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> unsubscribe(@AuthenticationPrincipal PrincipalDetails principalDetails,
                                         @PathVariable int toUserId) {

        subscribeService.구독취소하기(principalDetails.getUser().getId(), toUserId);
        return new ResponseEntity<>(
                new CMRespDto<>(1, "unsubscribe complete", null),
                HttpStatus.OK
        );
    }
}
