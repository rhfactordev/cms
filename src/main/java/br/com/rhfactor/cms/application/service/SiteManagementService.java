package br.com.rhfactor.cms.application.service;

import br.com.rhfactor.cms.application.port.in.CreateSiteCommand;
import br.com.rhfactor.cms.application.port.in.SiteManagementUsecase;
import br.com.rhfactor.cms.application.port.in.UpdateSiteCommand;
import br.com.rhfactor.cms.application.port.out.SiteRepository;
import br.com.rhfactor.cms.domain.Site;
import br.com.rhfactor.cms.infrastructure.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SiteManagementService implements SiteManagementUsecase {

    private final SiteRepository siteRepository;

    @Override
    public Site createSite( CreateSiteCommand createSiteCommand ) {

        Site site = Site.builder()
                .name( createSiteCommand.getName() )
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

    // TODO: Aqui, devo sempre passar uma command ou posso passar um ID
    // TODO: Qual é o momento em que eu posso verificar informações de sessão
    /*
    @Override
    public Boolean addDomain(Long id, String domain) {

        Site site = siteRepository.findById( updateSiteCommand.getId() )
                .orElseThrow(() -> new NotFoundException( String.format("site not found with id %s", updateSiteCommand.getId() )) );


        return null;
    }
    */

}
