package ussum.homepage.application.post.service.dto.response;

import ussum.homepage.application.post.service.dto.BoardResponse;
import ussum.homepage.application.user.service.dto.response.UserResponse;
import ussum.homepage.domain.post.Post;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        BoardResponse board,
        CategoryResponse category,
        UserResponse user,
        String title,
        String content,
        Integer viewCount,
        String thumbNailImage,
        String lastEditedAt
) {
    public static PostResponse of(Post post,BoardResponse board,CategoryResponse category,UserResponse user) {
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
