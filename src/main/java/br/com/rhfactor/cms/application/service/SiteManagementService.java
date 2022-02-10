package br.com.rhfactor.cms.application.service;

import br.com.rhfactor.cms.application.port.in.commands.CreateSiteCommand;
import br.com.rhfactor.cms.application.port.in.SiteManagementUsecase;
import br.com.rhfactor.cms.application.port.in.commands.UpdateSiteCommand;
import br.com.rhfactor.cms.application.port.out.DomainRepository;
import br.com.rhfactor.cms.application.port.out.SiteRepository;
import br.com.rhfactor.cms.domain.Domain;
import br.com.rhfactor.cms.domain.Site;
import br.com.rhfactor.cms.infrastructure.error.exception.InvalidArgumentException;
import br.com.rhfactor.cms.infrastructure.error.exception.NotFoundException;
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

    @Override
    public Site updateSite( UpdateSiteCommand updateSiteCommand ) {

        Site site = siteRepository.findById( updateSiteCommand.getId() )
                .orElseThrow(() -> new NotFoundException( String.format("site not found with id %s", updateSiteCommand.getId() )) );

        site.setName( updateSiteCommand.getTitle() );

        return site;
    }

}
