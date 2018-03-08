package simpleCMS.config;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter{

	@Autowired
	private EntityManager entityManager;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.returnBodyOnUpdate("Accept=application/json");
        config.returnBodyOnCreate("Accept=application/json");
        config.useHalAsDefaultJsonMediaType(false);
        // REST base url
        config.setBasePath("/api");
       
        // Expose db entity id's
        config
			.exposeIdsFor(entityManager.getMetamodel()
			.getEntities().stream()
			.map(e -> e.getJavaType())
			.collect(Collectors.toList())
			.toArray(new Class[0]));
		
	}
	
	// if tomcat say 404, vue router will handle it
//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//		return (container -> {
//			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/");
//			container.addErrorPages(error404Page);
//		});
//	}
	
	// Enable CORS globally, for dev live server
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}

}