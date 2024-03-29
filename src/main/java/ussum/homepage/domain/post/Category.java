package ussum.homepage.domain.post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ussum.homepage.infra.jpa.post.entity.BoardEntity;
import ussum.homepage.infra.jpa.user.entity.MajorCode;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Category {
    private Long id;
    private String majorCode;
    private String name;
    private Long boardId;
    private String createdAt; //이거 빼야할까
    private String updatedAt; //이거 빼야할까

    public static Category of(Long id, String majorCode, String name, Long boardId, String createdAt, String updatedAt) {
        return new Category(id, String.valueOf(majorCode), name, boardId,createdAt,updatedAt);
    }
}
