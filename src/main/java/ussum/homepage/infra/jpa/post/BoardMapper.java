package ussum.homepage.infra.jpa.post;

import org.springframework.stereotype.Component;
import ussum.homepage.domain.post.Board;
import ussum.homepage.infra.jpa.post.entity.BoardEntity;

@Component
public class BoardMapper {
    public Board toDomain(BoardEntity boardEntity){
        return Board.of(
                boardEntity.getId(),
                boardEntity.getBoardCode(),
                boardEntity.getName()
                );
    }
}
