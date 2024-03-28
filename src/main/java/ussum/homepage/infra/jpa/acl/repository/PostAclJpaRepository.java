package ussum.homepage.infra.jpa.acl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ussum.homepage.domain.acl.PostAcl;
import ussum.homepage.infra.jpa.acl.entity.BoardAclEntity;
import ussum.homepage.infra.jpa.acl.entity.PostAclEntity;

import java.util.List;

public interface PostAclJpaRepository extends JpaRepository<PostAclEntity, Long> {
    List<PostAclEntity> findAllByPostId(Long postId);
}
