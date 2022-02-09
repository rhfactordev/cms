package br.com.rhfactor.cms.adapter.in.rest;

import br.com.rhfactor.cms.adapter.in.responses.SiteResponse;
import br.com.rhfactor.cms.application.port.in.commands.CreateSiteCommand;
import br.com.rhfactor.cms.application.port.in.SiteManagementUsecase;
import br.com.rhfactor.cms.domain.Site;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SiteResponse> create(@RequestBody CreateSiteCommand site ){
        Site createdSite = siteManagementUsecase.createSite(site);
        return ResponseEntity.ok( SiteResponse.fromDomain( createdSite ) );
    }


}
