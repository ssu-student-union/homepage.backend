package ussum.homepage.infra.jpa.acl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.infra.jpa.acl.entity.BoardAclEntity;

import java.util.List;

public interface BoardAclJpaRepository extends JpaRepository<BoardAclEntity,Long> {
    @Query("SELECT ba FROM BoardAclEntity ba WHERE ba.boardEntity.id = :boardId")
    List<BoardAclEntity> findAllByBoardId(@Param("boardId") Long boardId);
}
