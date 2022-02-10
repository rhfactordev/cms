package br.com.rhfactor.cms.application.service;

import br.com.rhfactor.cms.application.port.in.commands.CreateSiteCommand;
import br.com.rhfactor.cms.application.port.out.DomainRepository;
import br.com.rhfactor.cms.application.port.out.SiteRepository;
import br.com.rhfactor.cms.domain.Site;
import br.com.rhfactor.cms.infrastructure.error.exception.InvalidArgumentException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @see SiteManagementService
 */
@ExtendWith(MockitoExtension.class)
class SiteManagementServiceTest {

    @Mock private SiteRepository siteRepository;
    @Mock private DomainRepository domainRepository;

    @InjectMocks
    private SiteManagementService service;


    /**
     * Testar que um site criado vai ter um ID e que ele não pode ser repetido
     */
    @Test
    void test_create_site_with_domain() {

        when( siteRepository.save(any(Site.class))).thenAnswer(args ->{
            Site site = (Site) args.getArguments()[0];
            site.setId( 1L );
            for(Integer i=0; i<site.getDomains().size(); i++){
                site.getDomains().get( i ).setId( i.longValue() + 1L );
            }
            return site;
        });

        when( domainRepository.doesTheDomainExists( any(String.class) )).thenReturn(false);

        CreateSiteCommand create = CreateSiteCommand.builder()
                .name("RH Factor")
                .domain("rhfactor.com.br")
                .build();

        Site site = service.createSite(create);

        assertThat(site, allOf(
                hasProperty("id" , equalTo( 1L ) ),
                hasProperty("domains" , everyItem(
                        hasProperty("id", greaterThan( 0L ))
                ) )
        ));

        verify(siteRepository, times(1)).save(any(Site.class));
        verify(domainRepository, times(1)).doesTheDomainExists(any(String.class));

    }

    /**
     * Testar a criação um site com um domínio existente, deve retornar erro
     */
    @Test
    void test_create_site_with_existing_domain() {

        when( domainRepository.doesTheDomainExists( any(String.class) )).thenReturn(true);

        CreateSiteCommand create = CreateSiteCommand.builder()
                .name("RH Factor")
                .domain("rhfactor.com.br")
                .build();

        assertThrows(InvalidArgumentException.class, () -> {
            service.createSite(create);
        });

        verify(siteRepository, times(0)).save(any(Site.class));
        verify(domainRepository, times(1)).doesTheDomainExists(any(String.class));

    }



}
