package br.jus.tjms.alvara.infra.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
    
}
