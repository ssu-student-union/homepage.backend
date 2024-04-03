package ussum.homepage.domain.post;

import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findByMajorCode(String majorCode);

    Optional<Category> findById(Long categoryId);
}
