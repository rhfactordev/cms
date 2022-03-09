package br.com.rhfactor.cms.adapter.out.persistence;


import br.com.rhfactor.cms.adapter.out.persistence.entity.BlogEntity;
import br.com.rhfactor.cms.adapter.out.persistence.repository.BlogEntityRepository;
import br.com.rhfactor.cms.application.port.out.BlogRepository;
import br.com.rhfactor.cms.domain.Blog;
import br.com.rhfactor.cms.domain.Site;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class BlogRepositoryImpl implements BlogRepository {

    private final BlogEntityRepository blogEntityRepository;

    @Override
    public Blog save(Blog blog) {
        // TODO: validar se o blog está ok
        return blogEntityRepository.save( BlogEntity.fromDomain(blog) )
                .toDomain();
    }

    @Override
    public boolean existsBySite(Site site) {
        // TODO: Implementar
        return false;
    }

    @Override
    public Optional<Blog> findByDomain(String domain) {
        return Optional.empty();
    }
}
