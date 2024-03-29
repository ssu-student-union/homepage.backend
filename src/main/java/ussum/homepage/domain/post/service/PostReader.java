package ussum.homepage.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Post;
import ussum.homepage.domain.post.PostRepository;
import ussum.homepage.global.error.exception.GeneralException;

import java.util.List;

import static ussum.homepage.global.error.status.ErrorStatus.BOARD_NOT_FOUND;
import static ussum.homepage.global.error.status.ErrorStatus.POST_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PostReader {
    private final PostRepository postRepository;
    public Page<Post> getPostList(Pageable pageable, String boardCode) {
        return postRepository.findAllWithBoard(pageable, boardCode);
    }

    public Post getPostWithId(Long postId) {
        return postRepository.findById(postId).orElseThrow(()-> new GeneralException(POST_NOT_FOUND));
    }
}
