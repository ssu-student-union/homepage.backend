package ussum.homepage.application.post.service.dto.request;

import ussum.homepage.domain.acl.PostAcl;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Category;
import ussum.homepage.domain.post.Post;
import ussum.homepage.domain.user.User;
import ussum.homepage.infra.jpa.user.entity.MajorCode;

import java.time.LocalDateTime;
import java.util.List;

public record PostCreateRequest(
        String title,
        String content,
        String categoryCode,
        String thumbNailImage
) {
    public Post toDomain(Board board, Category category) {
        return Post.of(
                null,
                title,
                content,
                0,
                thumbNailImage,
                null,
                null,
                null,
                null,
                null, //이건 채워넣어야 함, user쪽 개발되면
                board.getId(),
                category.getId()
        );
    }

}
