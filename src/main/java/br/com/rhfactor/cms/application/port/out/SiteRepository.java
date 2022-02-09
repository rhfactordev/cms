package br.com.rhfactor.cms.application.port.out;

import br.com.rhfactor.cms.domain.Site;

import java.util.Optional;

public interface SiteRepository {

    Site save(Site site);

    Optional<Site> findById(Long id);

}
