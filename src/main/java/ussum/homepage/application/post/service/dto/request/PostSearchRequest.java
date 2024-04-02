package ussum.homepage.application.post.service.dto.request;

import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Category;
import ussum.homepage.domain.post.Post;

public record PostSearchRequest(
        String q,
        String categoryCode,
        Integer page,
        Integer take
) {
//    public static Post toDomain(Board board, Category category) {
//        return Post.of(
//                null,
//                q,
//                content,
//                0,
//                thumbNailImage,
//                null,
//                null,
//                null,
//                null,
//                null, //이건 채워넣어야 함, user쪽 개발되면
//                board.getId(),
//                category.getId()
//
//        )
//    }
}
