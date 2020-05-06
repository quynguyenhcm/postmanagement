package postmanagment.dto;

import java.util.Set;

public class PostDto {
    private Long id;

    private String title;

    private String body;

    private Set<CommentDto> comments;

    public PostDto() {
    }

    public PostDto(Long id, String title, String body, Set<CommentDto> comments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<CommentDto> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDto> comments) {
        this.comments = comments;
    }
}
