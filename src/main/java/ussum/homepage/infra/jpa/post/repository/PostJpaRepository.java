package ussum.homepage.infra.jpa.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Post;
import ussum.homepage.infra.jpa.post.entity.PostEntity;

import java.util.List;
import java.util.Optional;

public interface PostJpaRepository extends JpaRepository<PostEntity,Long> {
//    List<PostEntity> findAllPostByBoard(Board board);
    @Query("SELECT p FROM PostEntity p WHERE p.boardEntity.id = :boardId")
    List<PostEntity> findAllByBoardId(@Param("boardId") Long boardId);
}
