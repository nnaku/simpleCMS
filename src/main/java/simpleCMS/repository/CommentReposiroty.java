package simpleCMS.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import simpleCMS.model.Comment;

@RepositoryRestResource(collectionResourceRel = "comment", path = "/comment")
public interface CommentReposiroty extends PagingAndSortingRepository<Comment, Long> {

}
