package ussum.homepage.infra.jpa.acl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ussum.homepage.infra.jpa.acl.entity.BoardAclEntity;

import java.util.List;
import java.util.Optional;

public interface BoardAclJpaRepository extends JpaRepository<BoardAclEntity,Long> {
    List<BoardAclEntity> findAllByBoardId(Long boardId);
}
