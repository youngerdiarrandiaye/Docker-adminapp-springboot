package youdev.sn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import youdev.sn.entities.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
}
