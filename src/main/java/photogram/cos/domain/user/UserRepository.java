package photogram.cos.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

//Jpa 상속 시, 어노테이션 없어도 IoC 자동 등록
public interface UserRepository extends JpaRepository<User, Integer> {
}
