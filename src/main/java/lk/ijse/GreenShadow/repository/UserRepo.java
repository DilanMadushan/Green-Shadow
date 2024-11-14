package lk.ijse.GreenShadow.repository;

import lk.ijse.GreenShadow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {
    Optional<User> findByEmail(String email);
}
