package ussum.homepage.application.post.service.dto.request;

import ussum.homepage.domain.post.Post;

public record PostCreateRequest(
        String title,
        String content,
        String thumbNailImage
) {
    public Post toDomain() {
        return Post.of(

        )

    }
}
