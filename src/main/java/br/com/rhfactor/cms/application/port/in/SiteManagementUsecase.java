package br.com.rhfactor.cms.application.port.in;

import br.com.rhfactor.cms.domain.Site;

/**
 * Gestão de Site
 * - Criar um site
 * - Editar um site
 * - Adicionar um domínio no site
 *
 */
public interface SiteManagementUsecase {

    Site createSite( CreateSiteCommand createSiteCommand );

    Site updateSite( UpdateSiteCommand updateSiteCommand );

}
