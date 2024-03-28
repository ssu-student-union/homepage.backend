package ussum.homepage.domain.acl.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.PostAcl;
import ussum.homepage.domain.acl.PostAclRepository;

@Service
@RequiredArgsConstructor
public class PostAclAppender {
    private final PostAclRepository postAclRepository;
    public PostAcl appendPostAcl(PostAcl postAcl){
         postAclRepository.save(postAcl);
         return postAcl;
    }
}
