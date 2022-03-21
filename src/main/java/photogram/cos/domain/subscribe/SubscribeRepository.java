package photogram.cos.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubscribeRepository extends JpaRepository<Subscribe, Integer> {

    @Modifying
    @Query(value = "INSERT INTO subscribe(from_user_id, to_user_id, create_date) " +
            "VALUES(:from_user_id, :to_user_id, now())", nativeQuery = true)
    void mSubscribe(int from_user_id, int to_user_id);

    @Modifying
    @Query(value = "DELETE FROM subscribe WHERE from_user_id = :from_user_id" +
            "AND to_user_id = :to_user_id", nativeQuery = true)
    void mUnSubscribe(int from_user_id, int to_user_id);
}
