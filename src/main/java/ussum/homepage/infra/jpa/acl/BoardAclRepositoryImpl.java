package ussum.homepage.infra.jpa.acl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ussum.homepage.domain.acl.BoardAclRepository;
import ussum.homepage.infra.jpa.acl.repository.BoardAclJpaRepository;

@Repository
@RequiredArgsConstructor
public class BoardAclRepositoryImpl implements BoardAclRepository {
    private final BoardAclJpaRepository boardAclJpaRepository;
}
