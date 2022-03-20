package photogram.cos.web.dto.user;

import lombok.Data;
import photogram.cos.domain.user.User;

import javax.validation.constraints.NotBlank;

@Data
public class UserUpdateDto {

    @NotBlank
    private String name; //필수
    @NotBlank
    private String password; //필수
    private String website;
    private String bio;
    private String phone;
    private String gender;

    //Validation 체크 필요함
    public User toEntity() {
        return User.builder()
                .name(name)
                .password(password)
                .website(website)
                .bio(bio)
                .phone(phone)
                .gender(gender)
                .build();
    }
}
