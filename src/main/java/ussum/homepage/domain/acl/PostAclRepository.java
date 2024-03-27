package ussum.homepage.domain.acl;

import java.util.List;

public interface PostAclRepository {
    List<PostAcl> findByPostId(Long postId);
}
