package ussum.homepage.infra.jpa.post;

import org.springframework.stereotype.Component;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Category;
import ussum.homepage.domain.post.Post;
import ussum.homepage.domain.user.User;
import ussum.homepage.infra.jpa.post.entity.BoardCode;
import ussum.homepage.infra.jpa.post.entity.BoardEntity;
import ussum.homepage.infra.jpa.post.entity.CategoryEntity;
import ussum.homepage.infra.jpa.post.entity.PostEntity;
import ussum.homepage.infra.jpa.user.entity.UserEntity;

import java.time.LocalDateTime;

@Component
public class PostMapper {
    public Post toDomain(PostEntity postEntity){
        return Post.of(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getViewCount(),
                postEntity.getThumbnailImage(),
                postEntity.getCreatedAt(),
                postEntity.getUpdatedAt(),
                postEntity.getLastEditedAt(),
                postEntity.getDeletedAt(),
                postEntity.getUserEntity().getId(),
                postEntity.getBoardEntity().getId(),
                postEntity.getCategoryEntity().getId()
        );
    }

    public PostEntity toEntity(Post post, UserEntity user, BoardEntity board, CategoryEntity category) {
//        PostEntity from = PostEntity.from(post.getId());
        LocalDateTime lastEditedAt = LocalDateTime.parse(post.getLastEditedAt());
        LocalDateTime deletedAt = LocalDateTime.parse(post.getDeletedAt());
        return PostEntity.of(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getViewCount(),
                post.getThumbnailImage(),
                lastEditedAt,
                deletedAt,
                user,
                board,
                category
        );
    }

}
