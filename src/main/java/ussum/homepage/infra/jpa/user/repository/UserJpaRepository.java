package ussum.homepage.infra.jpa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ussum.homepage.infra.jpa.user.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
