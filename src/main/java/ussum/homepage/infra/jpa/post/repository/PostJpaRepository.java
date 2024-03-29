package ussum.homepage.infra.jpa.post.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Post;
import ussum.homepage.infra.jpa.post.entity.BoardEntity;
import ussum.homepage.infra.jpa.post.entity.PostEntity;

import java.util.List;
import java.util.Optional;

public interface PostJpaRepository extends JpaRepository<PostEntity,Long> {
    @Query("""
                select pe
                from PostEntity pe
                where pe.boardEntity = :board
                order by pe.id desc 
        """)
    Page<PostEntity> findAllByBoard(Pageable pageable, @Param("board") BoardEntity board);

    Optional<PostEntity> findByBoardEntityAndId(BoardEntity boardEntity, Long id);
}
