package simpleCMS.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import simpleCMS.model.Article;

@RepositoryRestResource(collectionResourceRel = "article", path = "/article")
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

}
