package ussum.homepage.infra.jpa.acl;

import org.springframework.stereotype.Component;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.infra.jpa.acl.entity.*;
import ussum.homepage.infra.jpa.post.entity.BoardEntity;


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
    public BoardAclEntity toEntity(BoardAcl boardAcl){
        return BoardAclEntity.of(
                boardAcl.getId(),
                Target.getEnumTargetFromStringTarget(boardAcl.getTarget()),
                Type.getEnumTypeFromStringType(boardAcl.getType()),
                Action.getEnumActionFromStringAction(boardAcl.getAction()),
                Order.getEnumOrderFromStringOrder(boardAcl.getOrder()),
                BoardEntity.from(boardAcl.getBoardId())
        );
    }
}
