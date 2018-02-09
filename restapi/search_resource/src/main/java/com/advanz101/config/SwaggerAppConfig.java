package com.advanz101.config;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author sharm
 * It is swagger configuration for Restful API documentation
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerAppConfig /*extends WebMvcConfigurerAdapter */{

	
	/**
	 * Sets up the security schemes used to protect the apis. Supported schemes are ApiKey, BasicAuth and OAuth
	 * Provides a way to globally set up security contexts for operation. The idea here is that we provide a way to select operations to be protected by one of the specified security schemes.
	 * @return
	 */
	@Bean
	public Docket myStaffApiSwaggerDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.any())
				.build()
				.genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false)
				.forCodeGeneration(true)
				.securitySchemes(newArrayList(apiKey()))
		        .securityContexts(newArrayList(securityContext())) 	
				.apiInfo(apiInfo());
	}

	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Search POC API Documentation")
				.description("Search POC REST API's")
				.version("2.0")
				.contact(new Contact("Search POC Team", "https://retailer-test.com", "RetailerTechnical@retailer-test.com"))
				.license("Apache License 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.build();
	}
	
	/**
	 *Here we use ApiKey as the security schema that is identified by the name mykey
	 **/
	private ApiKey apiKey() {
	    return new ApiKey("API Key", "api_key", "header"); 
	}
	
	private SecurityContext securityContext() {
	  	return SecurityContext.builder()
	  		.securityReferences(defaultAuth())
	  		.forPaths(PathSelectors.regex("/anyPath.*"))
	  		.build();
  	}
	
	List<SecurityReference> defaultAuth() {
	    AuthorizationScope authorizationScope
	        = new AuthorizationScope("global", "accessEverything");
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	    authorizationScopes[0] = authorizationScope;
	    return newArrayList(
	        new SecurityReference("API Key", authorizationScopes));
	 }
	
	@Bean
	SecurityConfiguration security() {
	    return new SecurityConfiguration(
	        "test-app-client-id",
	        "test-app-client-secret",
	        "test-app-realm",
	        "test-app",
	        "apiKey",
	        ApiKeyVehicle.HEADER, 
	        "api_key", 
	        ",");
	 }
	
}
