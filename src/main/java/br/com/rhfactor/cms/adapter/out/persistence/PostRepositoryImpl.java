package br.com.rhfactor.cms.adapter.out.persistence;

import br.com.rhfactor.cms.adapter.out.persistence.converters.PersistenceConverters;
import br.com.rhfactor.cms.adapter.out.persistence.entity.PostEntity;
import br.com.rhfactor.cms.adapter.out.persistence.repository.PostEntityRepository;
import br.com.rhfactor.cms.adapter.out.persistence.specialization.PostSpecialization;
import br.com.rhfactor.cms.application.port.out.PostRepository;
import br.com.rhfactor.cms.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.rhfactor.cms.adapter.out.persistence.converters.PersistenceConverters.convert;


@Slf4j
@Component
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final PostEntityRepository repository;

    @Override
    public Optional<Post> findByBlogAndSource(Blog blog, String source) {
        return Optional.empty();
    }

    @Override
    public Page<Post> findPosts(Blog blog, Optional<String> category, Optional<String> tag, PageableRequest pageableRequest) {

        Specification<PostEntity> spec =
                Specification.where( PostSpecialization.blog( blog.getId() ) )
                        .and( PostSpecialization.categorySource( category ) );

        org.springframework.data.domain.Page<PostEntity> databasePage = repository.findAll(spec, convert(pageableRequest));
        List<Post> domainList = databasePage.getContent().stream().map(PostEntity::toDomain).collect(Collectors.toList());

        return new Page<Post>(domainList,pageableRequest,databasePage.getTotalElements());
    }
}
