package ussum.homepage.infra.jpa.acl;

import org.springframework.stereotype.Component;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.PostAcl;
import ussum.homepage.infra.jpa.acl.entity.BoardAclEntity;
import ussum.homepage.infra.jpa.acl.entity.PostAclEntity;
import ussum.homepage.infra.jpa.acl.entity.*;
import ussum.homepage.infra.jpa.post.entity.BoardEntity;
import ussum.homepage.infra.jpa.post.entity.PostEntity;

@Component
public class AclMapper {
    public BoardAcl toDomain(BoardAclEntity boardAclEntity){
        return BoardAcl.of(
                boardAclEntity.getId(),
                String.valueOf(boardAclEntity.getTarget()),
                String.valueOf(boardAclEntity.getType()),
                String.valueOf(boardAclEntity.getAction()),
                String.valueOf(boardAclEntity.getOrderType()),
                boardAclEntity.getBoardEntity().getId()
        );
    }

    public PostAcl toDomain(PostAclEntity postAclEntity) {
        return PostAcl.of(
                postAclEntity.getId(),
                postAclEntity.getTarget(),
                postAclEntity.getType(),
                postAclEntity.getAction(),
                postAclEntity.getOrderType(),
                postAclEntity.getPostEntity().getId()
        );
    }
    public BoardAclEntity toEntity(BoardAcl boardAcl){
        return BoardAclEntity.of(
                boardAcl.getId(),
                Target.getEnumTargetFromStringTarget(boardAcl.getTarget()),
                Type.getEnumTypeFromStringType(boardAcl.getType()),
                Action.getEnumActionFromStringAction(boardAcl.getAction()),
                OrderType.getEnumOrderFromStringOrder(boardAcl.getOrder()),
                BoardEntity.from(boardAcl.getBoardId())
        );
    }

    public PostAclEntity toEntity(PostAcl postAcl) {
        return PostAclEntity.of(
                postAcl.getId(),
                Target.getEnumTargetFromStringTarget(postAcl.getTarget()),
                Type.getEnumTypeFromStringType(postAcl.getType()),
                Action.getEnumActionFromStringAction(postAcl.getAction()),
                OrderType.getEnumOrderFromStringOrder(postAcl.getOrder()),
                PostEntity.from(postAcl.getPostId())
        );
    }
}
