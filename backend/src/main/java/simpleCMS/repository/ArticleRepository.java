package simpleCMS.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import simpleCMS.model.Article;

@RepositoryRestResource(collectionResourceRel = "articles", path = "/articles")
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
	
}
