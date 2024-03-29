package ussum.homepage.domain.acl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

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
                              String target,
                              String type,
                              String action,
                              String order,
                              Long postId){
        return new PostAcl(id, target,type, action, order, postId);
    }
}
