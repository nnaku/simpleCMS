package simpleCMS.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import simpleCMS.model.Comment;

@RepositoryRestResource(collectionResourceRel = "comments", path = "/comments")
public interface CommentReposiroty extends PagingAndSortingRepository<Comment, Long> {

}
