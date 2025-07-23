package dev.as.ikibina.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<Object> findByfullName(String fullName);

    Optional<Object> findByEmail(String email);
}
