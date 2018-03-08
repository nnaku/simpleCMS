package simpleCMS.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true, updatable = false)
	private long id;

	@ManyToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;
	
	@Column(nullable = false, updatable = false)
	private long created;

	private long modified;
	
	private String body;
	
	@Column(nullable = false, updatable = false)
	private String author;

	public Comment() {
		super();
	}

	public Comment(Article article, String body, String author) {
		super();
		this.article = article;
		this.body = body;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public long getCreated() {
		return created;
	}

	@PrePersist
	public void setCreated() {
		this.created = System.currentTimeMillis() / 1000;
	}

	public long getModified() {
		return modified;
	}

	@PreUpdate
	public void setModified() {
		this.modified = System.currentTimeMillis() / 1000;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}