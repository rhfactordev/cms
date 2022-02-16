package br.com.rhfactor.cms.adapter.in.rest;

import br.com.rhfactor.cms.adapter.in.responses.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cms/management/astrologicaltransits")
@RequiredArgsConstructor
public class AstrologicalTransitsController {


    @GetMapping()

    public TransitsResponse getTransitInfo(){

        return TransitsResponse.builder()
                .title("Transitos Astrológicos")
                .description("Aqui vão aparecer os trânsitos astrológicos")
                .transits(new ArrayList<>() {{
                    add(AstrologicalTransitsResponse.builder()
                            .title("Sol em Gemeos")
                            .content("Se o sol esta em gemeos o mundo esta bem iluminado")
                            .date(LocalDate.now())
                            .build());

                    add(AstrologicalTransitsResponse.builder()
                            .title("Mercurio retrogrado")
                            .content("Só entendo que deixa tudo zazado")
                            .date(LocalDate.now())
                            .build());


                }})
                .build();


    }
}

