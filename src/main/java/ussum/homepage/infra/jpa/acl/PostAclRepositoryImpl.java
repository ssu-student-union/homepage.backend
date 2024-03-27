package ussum.homepage.infra.jpa.acl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ussum.homepage.domain.acl.PostAcl;
import ussum.homepage.domain.acl.PostAclRepository;
import ussum.homepage.infra.jpa.acl.repository.PostAclJpaRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostAclRepositoryImpl implements PostAclRepository {
    private final PostAclJpaRepository postAclJpaRepository;
    private final AclMapper aclMapper;

    @Override
    public List<PostAcl> findByPostId(Long postId) {
        return postAclJpaRepository.findAllByPostId(postId)
                .stream()
                .map(aclMapper::toDomain)
                .toList();
    }
}
