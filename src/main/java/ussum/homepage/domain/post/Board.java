package ussum.homepage.domain.post;

import jakarta.persistence.*;
import ussum.homepage.infra.jpa.post.entity.BoardCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Board {
    private Long id;
    private String boardCode;
    private String name;
    public static Board of(Long id,
                           BoardCode boardCode,
                           String name){
        return new Board(id, String.valueOf(boardCode), name);
    }
}
