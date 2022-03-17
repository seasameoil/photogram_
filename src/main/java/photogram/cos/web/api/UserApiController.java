package photogram.cos.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import photogram.cos.config.auth.PrincipalDetails;
import photogram.cos.domain.user.User;
import photogram.cos.service.UserService;
import photogram.cos.web.dto.CMRespDto;
import photogram.cos.web.dto.user.UserUpdateDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(@PathVariable int id,
                               UserUpdateDto userUpdateDto,
                               @AuthenticationPrincipal PrincipalDetails principalDetails) {
        User userEntity = userService.회원수정(id, userUpdateDto.toEntity());
        principalDetails.setUser(userEntity);
        return new CMRespDto<>(1, "Complete", userEntity);
    }
}
