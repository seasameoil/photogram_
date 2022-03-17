package photogram.cos.web;

//import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import photogram.cos.config.auth.PrincipalDetails;

@Controller
public class UserController {

    @GetMapping("/user/{id}")
    public String profile(@PathVariable int id) {
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
