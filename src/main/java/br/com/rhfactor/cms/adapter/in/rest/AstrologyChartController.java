package br.com.rhfactor.cms.adapter.in.rest;

import br.com.rhfactor.cms.adapter.in.request.ChartMapRequest;
import br.com.rhfactor.cms.adapter.in.responses.AstrologicalTransitsResponse;
import br.com.rhfactor.cms.adapter.in.responses.AstrologyChartResponse;
import br.com.rhfactor.cms.adapter.in.responses.ChartAspects;
import br.com.rhfactor.cms.adapter.in.responses.TransitsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/cms/management/astrologychart")
@RequiredArgsConstructor
public class AstrologyChartController {


    @GetMapping()

    public AstrologyChartResponse getChartInfo(){
        return AstrologyChartResponse.builder()
                .title("Mapa Astral")
                .name("Roberto fonseca")
                .bornDate("data xpto")
                .aspects(new ArrayList<>() {{
                    add(ChartAspects.builder()
                            .planet("Planeta")
                            .sign("Signo")
                            .house("Casa")
                            .degree("Grau")
                            .title("Título")
                            .text("Aqui vem o texto")

                            .build());


                }})

                .build();

    }
    @PostMapping
    public ChartMapRequest createChartMap(@RequestBody ChartMapRequest chartMap ){


        return chartMap;

    }

}
