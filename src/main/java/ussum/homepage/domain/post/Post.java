package ussum.homepage.domain.post;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ussum.homepage.infra.jpa.post.entity.BoardEntity;
import ussum.homepage.infra.jpa.post.entity.CategoryEntity;
import ussum.homepage.infra.jpa.user.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {
    private Long id;
    private String title;
    private String content;
    private Integer viewCount;
    private String thumbnailImage;
    private List<String> additionalData;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastEditedAt;
    private LocalDateTime deletedAt;
    private Long userId;
    private Long boardId;
    private Long categoryId;
}
