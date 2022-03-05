package photogram.cos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import photogram.cos.domain.user.User;
import photogram.cos.domain.user.UserRepository;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    public User 회원가입(User user) {
        //회원가입 진행
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
