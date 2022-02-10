package br.com.rhfactor.cms.application.port.in;

import br.com.rhfactor.cms.application.port.in.commands.CreateSiteCommand;
import br.com.rhfactor.cms.domain.Site;

/**
 * Gestão de Site
 * - Criar um site
 * - Editar um site
 * - Adicionar um domínio no site
 *
 */
public interface SiteManagementUsecase {

    /**
     * Criar um site
     * @param createSiteCommand
     * @return
     */
    Site createSite( CreateSiteCommand createSiteCommand );



}
