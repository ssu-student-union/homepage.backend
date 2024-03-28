package ussum.homepage.domain.acl.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.BoardAclRepository;
import ussum.homepage.domain.acl.PostAcl;
import ussum.homepage.domain.acl.PostAclRepository;
import ussum.homepage.global.error.exception.GeneralException;

import java.util.List;

import static ussum.homepage.global.error.status.ErrorStatus.BOARD_ACL_NOT_FOUND;
import static ussum.homepage.global.error.status.ErrorStatus.POST_ACL_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PostAclReader {
    private final PostAclRepository postAclRepository;

    public List<PostAcl> getPostAclList(Long postId) {
        return postAclRepository.findByPostId(postId);
    }

    public PostAcl getPostAcl(Long postAclId){
        return postAclRepository.findById(postAclId)
                .orElseThrow(()-> new GeneralException(POST_ACL_NOT_FOUND));
    }
}
