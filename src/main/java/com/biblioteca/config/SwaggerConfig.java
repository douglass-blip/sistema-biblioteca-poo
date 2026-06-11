package com.biblioteca.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração do Swagger / OpenAPI.
 * Acesse a documentação em: http://localhost:8080/swagger-ui.html
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API - Sistema de Biblioteca")
                        .version("1.0")
                        .description("API REST para gerenciamento de livros, autores e editoras. " +
                                     "Trabalho de Programação Orientada a Objetos - 2º Semestre de Ciência da Computação."));
    }
}
