package photogram.cos.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import photogram.cos.domain.user.User;
import photogram.cos.handler.ex.CustomValidationException;
import photogram.cos.service.AuthService;
import photogram.cos.web.dto.auth.SignupDto;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationException("유효성 검사 실패함", errorMap);
        } else {
            User user = signupDto.toEntity();
            authService.회원가입(user);
            return "/auth/signin";
        }
    }
}
