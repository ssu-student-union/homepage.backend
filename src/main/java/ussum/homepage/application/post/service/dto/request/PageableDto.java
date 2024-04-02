package ussum.homepage.application.post.service.dto.request;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public record PageableDto(
        Integer page,
        Integer take
) {
    public Pageable toPageable() {
        return PageRequest.of(page, take);
    }
}
