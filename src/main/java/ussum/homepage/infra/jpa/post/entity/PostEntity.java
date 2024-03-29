package ussum.homepage.infra.jpa.post.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ussum.homepage.infra.jpa.BaseEntity;
import ussum.homepage.infra.jpa.user.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class
PostEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Integer viewCount;
    private String thumbnailImage;
//    @Column(name = "additional_data", columnDefinition = "json")
//    @JdbcTypeCode(SqlTypes.JSON)
//    private List<String> additionalData;
    private LocalDateTime lastEditedAt;
    private LocalDateTime deletedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    public static PostEntity from(Long id){
        return new PostEntity(id,null,null,null,null,null,null,null,null,null);
    }

    public static PostEntity of(Long id, String title, String content, Integer viewCount, String thumbnailImage, /**List<String> additionalData,**/
                                LocalDateTime lastEditedAt, LocalDateTime deletedAt, UserEntity user, BoardEntity board, CategoryEntity category) {
        return new PostEntity(id, title, content, viewCount, thumbnailImage, /**additionalData,**/ lastEditedAt, deletedAt, user, board, category);
    }
}
