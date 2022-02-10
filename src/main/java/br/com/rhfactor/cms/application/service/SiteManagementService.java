package br.com.rhfactor.cms.application.service;

import br.com.rhfactor.cms.application.port.in.SiteManagementUsecase;
import br.com.rhfactor.cms.application.port.in.commands.CreateSiteCommand;
import br.com.rhfactor.cms.application.port.out.DomainRepository;
import br.com.rhfactor.cms.application.port.out.SiteRepository;
import br.com.rhfactor.cms.domain.Domain;
import br.com.rhfactor.cms.domain.Site;
import br.com.rhfactor.cms.infrastructure.error.exception.InvalidArgumentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class SiteManagementService implements SiteManagementUsecase {

    private final SiteRepository siteRepository;
    private final DomainRepository domainRepository;

    @Override
    public Site createSite( CreateSiteCommand createSiteCommand ) {

        if( domainRepository.doesTheDomainExists( createSiteCommand.getDomain() ) ){
            throw new InvalidArgumentException(String.format("Domain already exists %s", createSiteCommand.getDomain() ));
        }

        Site site = Site.builder()
                .name( createSiteCommand.getName() )
                .domains( new ArrayList<>(){{
                    add( Domain.builder()
                        .active( true )
                        .url( createSiteCommand.getDomain() )
                        .creationDate( LocalDateTime.now() )
                        .build());
                }} )
                .build();

        return siteRepository.save(site);
    }


}
