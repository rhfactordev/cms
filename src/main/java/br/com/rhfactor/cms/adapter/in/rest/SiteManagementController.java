package br.com.rhfactor.cms.adapter.in.rest;

import br.com.rhfactor.cms.application.port.in.CreateSiteCommand;
import br.com.rhfactor.cms.application.port.in.SiteManagementUsecase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/cms/management/site")
@RequiredArgsConstructor
public class SiteManagementController {

    private final SiteManagementUsecase siteManagementUsecase;

    @PostMapping
    public String create(@RequestBody CreateSiteCommand site ){
        siteManagementUsecase.createSite( site );
        return "Deu certo";
    }


}
