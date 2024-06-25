package kh.farrukh.aopltw.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OperationCustomizer customGlobalHeaders() {
    return (operation, handlerMethod) -> {
      Parameter missingParam = (new Parameter())
          .in(ParameterIn.HEADER.toString())
          .schema(new StringSchema())
          .name("tenant")
          .description("Current tenant")
          .required(true);
      operation.addParametersItem(missingParam);
      return operation;
    };
  }


}
