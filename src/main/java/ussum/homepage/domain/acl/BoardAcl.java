package ussum.homepage.domain.acl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardAcl {
    private Long id;
    private String target;
    private String type;
    private String action;
    private String order;
    private Long boardId;

    public static BoardAcl of(Long id,
                              String target,
                              String type,
                              String action,
                              String order,
                              Long boardId){
        return new BoardAcl(id, target,type, action, order, boardId);
    }
}
