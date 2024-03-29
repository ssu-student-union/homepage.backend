package ussum.homepage.infra.jpa.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ussum.homepage.domain.post.Category;
import ussum.homepage.domain.post.CategoryRepository;
import ussum.homepage.infra.jpa.post.repository.CategoryJpaRepository;
import ussum.homepage.infra.jpa.user.entity.MajorCode;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Optional<Category> findByMajorCode(String majorCode) {
        return categoryJpaRepository.findByMajorCode(MajorCode.getEnumMajorCodeFromStringMajorCode(majorCode))
                .map(categoryMapper::toDomain);
    }

}
