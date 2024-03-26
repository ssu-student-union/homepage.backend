package ussum.homepage.domain.acl;

import jakarta.persistence.*;
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
}
