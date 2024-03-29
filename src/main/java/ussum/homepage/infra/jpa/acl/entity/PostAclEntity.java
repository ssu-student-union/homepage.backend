package ussum.homepage.infra.jpa.acl.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ussum.homepage.infra.jpa.post.entity.PostEntity;

@Entity
@Table(name = "post_acl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostAclEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Target target;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Action action;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity postEntity;

    private PostAclEntity(Long id, Target target, Type type, Action action, OrderType orderType, PostEntity postEntity) {
        this.id = id;
        this.target = target;
        this.type = type;
        this.action = action;
        this.orderType = orderType;
        this.postEntity = postEntity;
    }

    public static PostAclEntity of(Long id, Target target, Type type, Action action, OrderType orderType, PostEntity postEntity){
        return new PostAclEntity(id, target, type, action, orderType, postEntity);
    }



}
