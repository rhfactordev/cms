package br.com.rhfactor.cms.adapter.out.persistence;


import br.com.rhfactor.cms.adapter.out.persistence.entity.SiteEntity;
import br.com.rhfactor.cms.application.port.out.SiteRepository;
import br.com.rhfactor.cms.domain.Site;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SiteRepositoryImpl implements SiteRepository {

    private final SiteEntityRepository siteEntityRepository;

    @Override
    public Site save(Site site) {
        return siteEntityRepository
                .save( SiteEntity.fromDomain( site ) )
                .toDomain();
    }

    @Override
    public Optional<Site> findById(Long id) {
        return Optional.empty();
    }
}
