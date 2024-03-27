package ussum.homepage.application.post.service.dto.response;

import ussum.homepage.domain.post.Post;

import java.time.LocalDateTime;

public record PostResponse(
        String id,
        BoardResponse board,
        CategoryResponse category,
        UserResponse user,
        String title,
        String content,
        Integer viewCount,
        String thumbNailImage,
        LocalDateTime lastEditedAt
) {
    public static PostResponse of(Post post,BoardRespose board,CategoryResponse category,UserRespose user) {
        return new PostResponse(
                post.getId(),
                board,
                category,
                user,
                post.getTitle(),
                post.getContent(),
                post.getViewCount(),
                post.getThumbnailImage(),
                post.getLastEditedAt()
        );
    }


}
