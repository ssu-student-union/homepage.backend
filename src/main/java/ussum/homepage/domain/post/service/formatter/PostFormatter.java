package ussum.homepage.domain.post.service.formatter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.application.post.service.dto.BoardResponse;
import ussum.homepage.application.post.service.dto.response.PostResponse;
import ussum.homepage.domain.post.Category;
import ussum.homepage.domain.post.Post;
import ussum.homepage.domain.post.service.BoardFormatter;
import ussum.homepage.domain.post.service.BoardReader;
import ussum.homepage.domain.post.service.PostReader;
import ussum.homepage.domain.user.service.formatter.UserFormatter.UserFormatter;

@Service
@RequiredArgsConstructor
public class PostFormatter implements ussum.homepage.domain.post.service.PostFormatter {
    private final PostReader postReader;
    private final BoardFormatter boardFormatter;

//    private final CategoryFormatter categoryFormatter;
    private final UserFormatter userFormatter;
    @Override
    public PostResponse format(Long postId) {
        final Post post = postReader.getPostWithId(postId);
        final BoardResponse boardResponse = boardFormatter.format(post.getBoardId());

        // Category와 User 부분 작성되면 추가
//        final CategoryResponse categoryResponse = categoryFormatter.format(post.getCategoryId());
//        final UserResposne userResponse = userFormatter.format(post.getUserId());


        return PostResponse.of(post,boardResponse,categoryResponse,userResponse);
    }
}
