package com.jack.babycarefamilybackend.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BabyCore Family  API")
                        .description("아기 돌봄 서비스 API 문서")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("jack")
                                .email("youngsik3200@gmail.com")))
                .addServersItem(new Server().url("/")
                        .description("default server"));
    }
}
