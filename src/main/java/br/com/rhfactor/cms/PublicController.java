package br.com.rhfactor.cms;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {


    @GetMapping("/")
    public String index(){
        return "Servidor está funcionando, está alterado";
    }


}
