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

    public static Category of(Long id, String majorCode, String name, Long boardId) {
        return new Category(id, String.valueOf(majorCode), name, boardId);
    }
}
