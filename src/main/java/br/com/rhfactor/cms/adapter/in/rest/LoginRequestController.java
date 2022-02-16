package br.com.rhfactor.cms.adapter.in.rest;

import br.com.rhfactor.cms.adapter.in.request.LoginRequest;
import br.com.rhfactor.cms.adapter.in.responses.AstrologicalTransitsResponse;
import br.com.rhfactor.cms.adapter.in.responses.TransitsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/cms/management/login")
@RequiredArgsConstructor
public class LoginRequestController {


    @PostMapping
    public LoginRequest postLoginInfo( @RequestBody LoginRequest login ){


        return login;

    }
}

