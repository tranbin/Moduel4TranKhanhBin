package validateformdangky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import validateformdangky.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
