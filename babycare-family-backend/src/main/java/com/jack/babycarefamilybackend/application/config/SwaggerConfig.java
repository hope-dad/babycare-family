package com.jack.babycarefamilybackend.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) // Swagger 2 문서 타입 설정
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jack.babycarefamilybackend")) // API 패키지 설정
                .paths(PathSelectors.any()) // 모든 경로 포함
                .build();
    }
}
