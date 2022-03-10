package photogram.cos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import photogram.cos.domain.user.User;
import photogram.cos.domain.user.UserRepository;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional //Write(Insert, Update, Delete)
     public User 회원가입(User user) {
        //회원가입 진행
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole("ROLE_USER"); //관리자 ROLE_ADMIN
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
