package ussum.homepage.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;;
import ussum.homepage.application.post.service.dto.request.PostUpdateRequest;
import ussum.homepage.domain.acl.service.AclModifier;
import ussum.homepage.domain.acl.service.AclReader;
import ussum.homepage.domain.post.*;

@Service
@RequiredArgsConstructor
public class PostModifier {
    private final PostRepository postRepository;
    private final PostReader postReader;
    private final BoardReader boardReader;
    private final CategoryReader categoryReader;
    private final AclModifier aclModifier;
    private final AclReader aclReader;

    public Post updatePost(String boardCode,Long postId, PostUpdateRequest postUpdateRequest){
        Board board = boardReader.getBoardWithBoardCode(boardCode);
        Category category = categoryReader.getCategoryWithCode(postUpdateRequest.categoryCode());

        return postRepository.save(postUpdateRequest.toDomain(
                postReader.getPostWithBoardCode(boardCode, postId), board, category)
        );
    }

}
