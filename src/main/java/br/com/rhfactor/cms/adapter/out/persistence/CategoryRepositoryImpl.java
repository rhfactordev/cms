package br.com.rhfactor.cms.adapter.out.persistence;

import br.com.rhfactor.cms.adapter.out.persistence.entity.BlogEntity;
import br.com.rhfactor.cms.adapter.out.persistence.entity.CategoryEntity;
import br.com.rhfactor.cms.adapter.out.persistence.repository.CategoryEntityRepository;
import br.com.rhfactor.cms.application.port.out.CategoryRepository;
import br.com.rhfactor.cms.domain.Blog;
import br.com.rhfactor.cms.domain.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Component
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryEntityRepository repository;

    @Override
    public List<Category> listAllCategoriesFromBlog(Blog blog) {
        return repository.findAllByBlogOrderByName(BlogEntity.fromDomain(blog))
                .stream()
                .map(CategoryEntity::toDomain)
                .collect(Collectors.toList())
                ;
    }
}
