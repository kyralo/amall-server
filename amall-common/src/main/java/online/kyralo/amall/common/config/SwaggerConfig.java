package online.kyralo.amall.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private final Contact DEFAULT_CONTACT = new Contact(
            "kyralo",
            "https://amall.kyralo.online",
            "kyralo721@gmail.com");

    private final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "有个商城API文档",
            "有个商城api文档",
            "1.0",
            "#",
            DEFAULT_CONTACT,
            "",
            "#",
            Collections.emptyList());

    private final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Collections.singletonList("application/json"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}

