package ussum.homepage.application.post.service.dto.request;

import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Category;
import ussum.homepage.domain.post.Post;

public record PostUpdateRequest(
        String title,
        String content,
        String categoryCode,
        String thumbnailImage
) {
    public Post toDomain(Post post, Board board, Category category) {
        return Post.of(
                post.getId(),
                title,
                content,
                post.getViewCount(),
                thumbnailImage,
                null,
                null,
                null,
                null,
                post.getUserId(),
                board.getId(),
                category.getId()
        );
    }

}
