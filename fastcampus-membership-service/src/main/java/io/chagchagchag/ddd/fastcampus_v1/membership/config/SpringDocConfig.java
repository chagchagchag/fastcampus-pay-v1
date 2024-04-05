package io.chagchagchag.ddd.fastcampus_v1.membership.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
  @Bean
  public OpenAPI openAPI(
      @Value("${springdoc.version}") String version
  ){
    Info info = new Info()
        .title("패캠페이 v1")
        .version(version)
        .description("패스트캠퍼스 간편결제 시스템 MSA 구축")
        .contact(new Contact().name("chagchagchag").email("chagchagchag.dev@gmail.com"));

    return new OpenAPI().info(info).components(new Components());
  }
}
