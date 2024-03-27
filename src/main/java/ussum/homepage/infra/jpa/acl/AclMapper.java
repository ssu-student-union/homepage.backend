package ussum.homepage.infra.jpa.acl;

import org.springframework.stereotype.Component;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.infra.jpa.acl.entity.BoardAclEntity;

import java.util.List;

@Component
public class AclMapper {
    public BoardAcl toDomain(BoardAclEntity boardAclEntity){
        return BoardAcl.of(
                boardAclEntity.getId(),
                boardAclEntity.getTarget(),
                boardAclEntity.getType(),
                boardAclEntity.getAction(),
                boardAclEntity.getOrder(),
                boardAclEntity.getBoardEntity().getId()
        );
    }
}
