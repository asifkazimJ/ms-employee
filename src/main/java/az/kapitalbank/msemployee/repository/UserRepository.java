package az.kapitalbank.msemployee.repository;

import az.kapitalbank.msemployee.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
