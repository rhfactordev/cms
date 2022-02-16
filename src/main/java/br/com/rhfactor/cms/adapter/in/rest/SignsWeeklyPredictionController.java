package br.com.rhfactor.cms.adapter.in.rest;

import br.com.rhfactor.cms.adapter.in.responses.AstrologicalTransitsResponse;
import br.com.rhfactor.cms.adapter.in.responses.PredictionSignsResponse;
import br.com.rhfactor.cms.adapter.in.responses.SignsWeeklyPredictionResponse;
import br.com.rhfactor.cms.adapter.in.responses.TransitsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/cms/management/signsweeklyprediction")
@RequiredArgsConstructor
public class SignsWeeklyPredictionController {


    @GetMapping()

    public SignsWeeklyPredictionResponse getWeeklyPrediction(){

        return SignsWeeklyPredictionResponse.builder()
                .title("Previsão Semanal Data Xpto")
                .description("Toda semana vão aparecer a previsão aqui")
                .weeklypredictions(new ArrayList<>() {{
                    add(PredictionSignsResponse.builder()
                            .title("Áries")
                            .content("Você nasceu para ser escroto")
                            .build());

                    add(PredictionSignsResponse.builder()
                            .title("Gêmeos")
                            .content("Você não precisa de previsão, a vida já te deu o melhor signo")
                            .build());

                    add(PredictionSignsResponse.builder()
                            .title("Cancer")
                            .content("Como sempre: sofrer, sofrer, sofrer")
                            .build());


                }})
                .build();


    }
}

