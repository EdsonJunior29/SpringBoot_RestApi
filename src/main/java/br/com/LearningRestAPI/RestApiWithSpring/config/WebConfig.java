package br.com.LearningRestAPI.RestApiWithSpring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	@SuppressWarnings("deprecation")
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer ) {
			
			// Via EXTENSION. localhost:8081/person.x-yaml
			/*
			 * configurer.favorParameter(false) .ignoreAcceptHeader(false)
			 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
			 * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);
			 */
			
			// Via QUERY PARAM. localhost:8081/person?mediaType=xml 
			
			 /* configurer.favorPathExtension(false) .favorParameter(true)
			 * .parameterName("mediaType") .ignoreAcceptHeader(true)
			 * .useRegisteredExtensionsOnly(false)
			 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
			  MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);
			 */
			
			//Via HEADER PARAM
			configurer.favorPathExtension(false)
			.favorParameter(false)
			.ignoreAcceptHeader(false)
			.useRegisteredExtensionsOnly(false)
			.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON)
			.mediaType("xml", MediaType.APPLICATION_XML);
			 
	}

}
