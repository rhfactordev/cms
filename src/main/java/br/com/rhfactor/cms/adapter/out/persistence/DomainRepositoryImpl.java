package br.com.rhfactor.cms.adapter.out.persistence;


import br.com.rhfactor.cms.adapter.out.persistence.entity.SiteEntity;
import br.com.rhfactor.cms.adapter.out.persistence.repository.DomainEntityRepository;
import br.com.rhfactor.cms.application.port.out.DomainRepository;
import br.com.rhfactor.cms.domain.Site;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class DomainRepositoryImpl implements DomainRepository {

    private final DomainEntityRepository repository;


    @Override
    public boolean doesTheDomainExists(String domain) {
        // TODO: Implementar
        return false;
    }
}
