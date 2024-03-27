package ussum.homepage.infra.jpa.acl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.BoardAclRepository;
import ussum.homepage.global.error.exception.GeneralException;
import ussum.homepage.infra.jpa.acl.entity.BoardAclEntity;
import ussum.homepage.infra.jpa.acl.repository.BoardAclJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ussum.homepage.global.error.status.ErrorStatus.USER_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class BoardAclRepositoryImpl implements BoardAclRepository {
    private final BoardAclJpaRepository boardAclJpaRepository;
    private final AclMapper aclMapper;

    @Override
    public List<BoardAcl> findByBoardId(Long boardId){
        return boardAclJpaRepository.findAllByBoardId(boardId)
                .stream()
                .map(aclMapper::toDomain)
                .toList();
    }
}
