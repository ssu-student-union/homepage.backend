package ussum.homepage.infra.jpa.acl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ussum.homepage.infra.jpa.acl.entity.BoardAclEntity;

public interface BoardAclJpaRepository extends JpaRepository<BoardAclEntity,Long> {
}
