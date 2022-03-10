package photogram.cos.web.dto.auth;

import lombok.Data;
import photogram.cos.domain.user.User;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
public class SignupDto {

    @Max(20)
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String name;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
