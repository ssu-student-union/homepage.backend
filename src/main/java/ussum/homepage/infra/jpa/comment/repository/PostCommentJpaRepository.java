package ussum.homepage.infra.jpa.comment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ussum.homepage.infra.jpa.comment.entity.PostCommentEntity;

public interface PostCommentJpaRepository extends JpaRepository<PostCommentEntity, Long> {
    Page<PostCommentEntity> findAllByPostId(Pageable pageable, Long postId);
}
