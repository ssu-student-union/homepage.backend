package ussum.homepage.domain.acl.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.application.acl.service.dto.request.BoardAclUpdateRequest;
import ussum.homepage.application.acl.service.post.dto.request.PostAclUpdateRequest;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.BoardAclRepository;
import ussum.homepage.domain.acl.PostAcl;
import ussum.homepage.domain.acl.PostAclRepository;
import ussum.homepage.global.error.exception.GeneralException;

import static ussum.homepage.global.error.status.ErrorStatus.BOARD_ACL_NOT_FOUND;
import static ussum.homepage.global.error.status.ErrorStatus.POST_ACL_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PostAclModifier {
    private final PostAclRepository postAclRepository;
    public PostAcl updatePostAcl(Long postAclId, PostAcl postAcl, PostAclUpdateRequest postAclUpdateRequest){
        return postAclRepository.update(postAclUpdateRequest.toDomain(postAclId, postAcl.getPostId()));
    }
}
