package simpleCMS.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true, updatable = false)
	private long id;

	@Column(nullable = false, updatable = false)
	private long created;

	private long modified;

	private String header;

	@Column(columnDefinition = "TEXT")
	private String preview;

	@Column(columnDefinition = "TEXT")
	private String body;

	@Column(nullable = false, updatable = false)
	private String author;

	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	@SuppressWarnings("unused")
	private int commentCount;

	public Article() {
		super();
	}

	public Article(String header, String preview, String body, String author) {
		super();
		this.header = header;
		this.preview = preview;
		this.body = body;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getCommentCount() {
		return comments.size();
	}

}