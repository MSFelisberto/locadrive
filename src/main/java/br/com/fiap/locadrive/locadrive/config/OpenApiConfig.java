package br.com.fiap.locadrive.locadrive.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI locadrive() {
        return new OpenAPI()
                .info(
                    new Info()
                            .title("Loca Drive API")
                            .description("Projeto desenvolvido através do curso SPRING MVC da FIAP POSTECH")
                            .version("V0.0.1")
                            .license(new License().name("Apache 2.0")
                            .url("https://github.com/MSFelisberto"))
        );
    }
}
