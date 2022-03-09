package br.com.rhfactor.cms.adapter.out.persistence;


import br.com.rhfactor.cms.adapter.out.persistence.repository.DomainEntityRepository;
import br.com.rhfactor.cms.application.port.out.DomainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
