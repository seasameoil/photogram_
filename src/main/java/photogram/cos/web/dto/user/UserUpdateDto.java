package photogram.cos.web.dto.user;

import lombok.Getter;
import lombok.Setter;
import photogram.cos.domain.user.User;

@Getter @Setter
public class UserUpdateDto {

    private String name; //필수
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
