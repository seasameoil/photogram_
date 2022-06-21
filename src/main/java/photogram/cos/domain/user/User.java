package photogram.cos.domain.user;

import lombok.*;
import photogram.cos.domain.image.Image;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity //DB에 테이블 생성
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 증가 전략이 데베를 따라감
    private int id;

    @Column(length = 20, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;
    private String website;
    private String bio; //자기 소개
    @Column(nullable = false)
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl; //사진
    private String role; //권한

    //나는 연관관계의 주인이 아니다. 그러므로 테이블에 칼럼 만들기 X
    //User를 Select 할 때, 해당 User id로 등록된 image들을 다 가져와
    // Lazy = User를 Select 할 때 해당 User id로 등록된 image들을 가져오지 X - 대신 getImages()함수가 호출될 때 가져오기
    // Eager = User를 Select 할 때 User id로 등록된 image들을 전부 join 해서 가져오기
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Image> images;

    private LocalDateTime createDate;

    @PrePersist //DB에 INSERT 되기 직전에 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
