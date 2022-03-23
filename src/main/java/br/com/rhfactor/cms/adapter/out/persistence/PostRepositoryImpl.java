package br.com.rhfactor.cms.adapter.out.persistence;

import br.com.rhfactor.cms.adapter.out.persistence.entity.PostEntity;
import br.com.rhfactor.cms.adapter.out.persistence.repository.PostEntityRepository;
import br.com.rhfactor.cms.adapter.out.persistence.specialization.PostSpecialization;
import br.com.rhfactor.cms.application.port.out.PostRepository;
import br.com.rhfactor.cms.domain.Blog;
import br.com.rhfactor.cms.domain.Page;
import br.com.rhfactor.cms.domain.PageableRequest;
import br.com.rhfactor.cms.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.rhfactor.cms.adapter.out.persistence.converters.PersistenceConverters.toPeageable;


@Slf4j
@Component
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final PostEntityRepository repository;

    @Override
    public Optional<Post> findByBlogAndSource(Blog blog, String source) {

        String[] sourceArr = source.split("/");

        Specification<PostEntity> spec =
                Specification.where( PostSpecialization.blog( blog.getId() ) )
                        .and( PostSpecialization.categorySource( Optional.of( sourceArr[0] ) ) )
                        .and( PostSpecialization.source( Optional.of( sourceArr[1] ) ) )
                ;

        return repository.findOne(spec)
                .map(PostEntity::toDomain);
    }

    @Override
    public Page<Post> findPosts(Blog blog, PageableRequest pageableRequest) {
        return findPosts(blog, Optional.empty(), Optional.empty(), pageableRequest);
    }

    @Override
    public Page<Post> findPosts(Blog blog, Optional<String> category, Optional<String> tag, PageableRequest pageableRequest) {

        Specification<PostEntity> spec =
                Specification.where( PostSpecialization.blog( blog.getId() ) )
                        .and( PostSpecialization.categorySource( category ) );

        org.springframework.data.domain.Page<PostEntity> databasePage = repository.findAll(spec, toPeageable(pageableRequest));
        List<Post> domainList = databasePage.getContent().stream().map(PostEntity::toDomain).collect(Collectors.toList());

        return new Page<Post>(domainList,pageableRequest,databasePage.getTotalElements());
    }
}
