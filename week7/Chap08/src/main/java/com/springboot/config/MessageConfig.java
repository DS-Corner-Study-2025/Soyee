package com.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
@ComponentScan("server")
public class MessageConfig implements WebMvcConfigurer {
	@Bean
    public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
       // resolver.setDefaultLocale(Locale.getDefault());
        resolver.setDefaultLocale(Locale.KOREA);  
        return resolver;
    }
	
	 @Bean
	    public LocaleChangeInterceptor localeChangeInterceptor() {
	        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
	        interceptor.setParamName("language");
	        return interceptor;
	    }
	    
	    
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(localeChangeInterceptor());
	    }
	  
	    
	
	/*
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		
		
	    messageSource.setBasename("messages/i18n");
	  //ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		//messageSource.setBasename("classpath:/messages");
	    messageSource.setDefaultEncoding("UTF-8");	   
	    messageSource.setFallbackToSystemLocale(false);	   
	    messageSource.setAlwaysUseMessageFormat(true);
	   return messageSource;
	}
	*/

	

}