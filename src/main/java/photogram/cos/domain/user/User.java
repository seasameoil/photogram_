package photogram.cos.domain.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity //DB에 테이블 생성
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략이 데베를 따라감
    private int id;

    private String username;
    private String password;

    private String name;
    private String website;
    private String bio; //자기 소개
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl; //사진
    private String role; //권한

    private LocalDateTime createDate;

    @PrePersist //DB에 INSERT 되기 직전에 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
