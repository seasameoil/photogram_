package photogram.cos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import photogram.cos.domain.user.User;
import photogram.cos.domain.user.UserRepository;
import photogram.cos.handler.ex.CustomException;
import photogram.cos.handler.ex.CustomValidationApiException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User 회원프로필(int userId) {

        User userEntity = userRepository.findById(userId).orElseThrow(() -> {
            throw new CustomException("해당 프로필 페이지는 없는 페이지입니다.");
        });
        userEntity.getImages().get(0);

        return userEntity;
    }

    @Transactional
    public User 회원수정(int id, User user) {
        //1. 영속화
        User userEntity = userRepository.findById(id).orElseThrow(() ->
                {
                    return new CustomValidationApiException("찾을 수 없는 id 입니다.");
                }); //1. 찾으면 -> get() 2. 못찾으면 -> orElseThrow()

        //2. 영속화된 오브젝트 수정 - 더티체킹 (업데이트 완료)
        userEntity.setName(user.getName());

        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        userEntity.setPassword(encPassword);
        userEntity.setBio(user.getBio());
        userEntity.setWebsite(user.getWebsite());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());
        return userEntity;
    }
}
