package photogram.cos.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import photogram.cos.domain.user.User;
import photogram.cos.service.AuthService;
import photogram.cos.web.dto.auth.SignupDto;

@RequiredArgsConstructor //DI 할 때 사용
@Controller
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "/auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "/auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(SignupDto signupDto) {

        User user = signupDto.toEntity();
        authService.회원가입(user);
        return "/auth/signin";
    }
}
