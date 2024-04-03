package ussum.homepage.infra.jpa.comment;

import org.springframework.stereotype.Component;
import ussum.homepage.domain.comment.PostComment;
import ussum.homepage.infra.jpa.comment.entity.PostCommentEntity;

@Component
public class PostCommentMapper {
    public PostComment toDomain(PostCommentEntity postCommentEntity){
        return PostComment.of(
                postCommentEntity.getId(),
                postCommentEntity.getContent(),
                postCommentEntity.getPostEntity().getId(),
                postCommentEntity.getUserEntity().getId(),
                String.valueOf(postCommentEntity.getLastEditedAt())
                );
    }
}
