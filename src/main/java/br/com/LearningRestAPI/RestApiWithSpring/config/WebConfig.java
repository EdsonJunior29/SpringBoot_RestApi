package br.com.LearningRestAPI.RestApiWithSpring.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.LearningRestAPI.RestApiWithSpring.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");
	
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}
	
	public void addCorsMapping(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET" ,
				"POST" ,"PUT" , "DELETE" ,"PATCH", "OPTIONS" ,
				"HEAD" , "TRACE" , "CONNECT"); //habilitando os metodos HTTP para  CORS
	}
	
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
			.mediaType("xml", MediaType.APPLICATION_XML)
			.mediaType("x-yaml", MEDIA_TYPE_YML);
			 
	}

}
