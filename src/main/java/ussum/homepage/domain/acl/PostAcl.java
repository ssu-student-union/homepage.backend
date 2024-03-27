package ussum.homepage.domain.acl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ussum.homepage.infra.jpa.acl.entity.Action;
import ussum.homepage.infra.jpa.acl.entity.Order;
import ussum.homepage.infra.jpa.acl.entity.Target;
import ussum.homepage.infra.jpa.acl.entity.Type;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostAcl {
    private Long id;
    private String target;
    private String type;
    private String action;
    private String order;
    private Long postId;

    public static PostAcl of(Long id,
                              Target target,
                              Type type,
                              Action action,
                              Order order,
                              Long postId){
        return new PostAcl(id, String.valueOf(target),String.valueOf(type), String.valueOf(action), String.valueOf(order), postId);
    }
}
