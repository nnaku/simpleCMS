package simpleCMS.config;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter{

	@Autowired
	private EntityManager entityManager;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.returnBodyOnUpdate("Accept=application/json");
        config.returnBodyOnCreate("Accept=application/json");
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
}