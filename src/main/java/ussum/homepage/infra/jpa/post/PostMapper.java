package ussum.homepage.infra.jpa.post;

import org.springframework.stereotype.Component;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Category;
import ussum.homepage.domain.post.Post;
import ussum.homepage.domain.user.User;
import ussum.homepage.infra.jpa.post.entity.BoardCode;
import ussum.homepage.infra.jpa.post.entity.PostEntity;
@Component
public class PostMapper {
    public Post toDomain(PostEntity postEntity){
        return Post.of(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getViewCount(),
                postEntity.getThumbnailImage(),
                postEntity.getAdditionalData(),
                postEntity.getCreatedAt(),
                postEntity.getUpdatedAt(),
                postEntity.getLastEditedAt(),
                postEntity.getDeletedAt(),
                postEntity.getUserEntity().getId(),
                postEntity.getBoardEntity().getId(),
                postEntity.getCategoryEntity().getId()
        );
    }

    public PostEntity toEntity(Post post) {
        PostEntity from = PostEntity.from(post.getId());
        return PostEntity.of(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getViewCount(),
                post.getThumbnailImage(),
                post.getAdditionalData(),
                post.getLastEditedAt(),
                post.getDeletedAt(),
                from.getUserEntity(),
                from.getBoardEntity(),
                from.getCategoryEntity());
    }

}
