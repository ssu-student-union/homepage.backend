package ussum.homepage.domain.acl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalAcl {
    private Long id;
    private String target;
    private String type;
    private String action;
    private String order;
}
