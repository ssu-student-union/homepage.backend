package ussum.homepage.domain.acl;

import ussum.homepage.infra.jpa.acl.entity.BoardAclEntity;

import java.util.List;
import java.util.Optional;

public interface BoardAclRepository {
    List<BoardAcl> findByBoardId(Long boardId);
    void save(BoardAcl boardAcl);
    BoardAcl update(BoardAcl boardAcl);
    Optional<BoardAcl> findById(Long boardAclId);
}
