package cybersoft.javabackend.girajava14bqn.config;

import javax.validation.Validator;

import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {

//	@Bean
//    @Lazy
//    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(final Validator validator) {
//        return hibernateProperties -> hibernateProperties.put("javax.persistence.validation.factory", validator);
//    }
//	
//	@Bean
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource messageSource
//			= new ReloadableResourceBundleMessageSource();
//		
//		messageSource.setBasename("classpath:/validation/messages");
//		messageSource.setDefaultEncoding("UTF-8");
//		
//		return messageSource;
//	}
//	
//	@Bean
//	public LocalValidatorFactoryBean validator() {
//		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//		
//		bean.setValidationMessageSource(messageSource());
//		return bean;
//	}
}
