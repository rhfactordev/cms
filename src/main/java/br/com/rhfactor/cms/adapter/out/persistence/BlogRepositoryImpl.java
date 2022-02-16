package br.com.rhfactor.cms.adapter.out.persistence;


import br.com.rhfactor.cms.adapter.out.persistence.entity.SiteEntity;
import br.com.rhfactor.cms.adapter.out.persistence.repository.SiteEntityRepository;
import br.com.rhfactor.cms.application.port.out.BlogRepository;
import br.com.rhfactor.cms.application.port.out.SiteRepository;
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


    @Override
    public Blog save(Blog blog) {
        // TODO: Implementar
        return null;
    }

    @Override
    public boolean existsBySite(Site site) {
        // TODO: Implementar
        return false;
    }
}
