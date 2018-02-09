package com.advanz101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

/**
 * @author sharm
 * 
 */
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
@Component
public class SearchPoc extends SpringBootServletInitializer {

	public static void main(String[] args) throws Throwable {
		ConfigurableApplicationContext appContext = SpringApplication.run(SearchPoc.class, args);
	}

	/** Added Message source properties **/
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
