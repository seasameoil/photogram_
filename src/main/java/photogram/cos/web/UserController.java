package photogram.cos.web;

//import org.springframework.security.core.Authentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import photogram.cos.config.auth.PrincipalDetails;
import photogram.cos.domain.user.User;
import photogram.cos.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public String profile(@PathVariable int id, Model model) {

        User userEntity = userService.회원프로필(id);
        model.addAttribute("user", userEntity);
        return "/user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String update(@PathVariable int id,
                         @AuthenticationPrincipal PrincipalDetails principalDetails) {
        /*
        System.out.println("세션 정보 :" + principalDetails.getUser());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("직접 찾은 세션 정보 auth = " + auth.getPrincipal());
        */

        return "/user/update";
    }
}
