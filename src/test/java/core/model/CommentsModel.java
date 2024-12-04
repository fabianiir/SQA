package core.model;

/**
 * CommentsModel class represents a model for comments data.
 * It includes fields for post ID, comment ID, name, email, and body of the comment.
 */
public class CommentsModel {
    private String postId;
    private String id;
    private String name;
    private String email;
    private String body;

    /**
     * Gets the body of the comment.
     *
     * @return the body of the comment.
     */
    public String getBody() {
        return body;
    }

    /**
     * Gets the email associated with the comment.
     *
     * @return the email of the commenter.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the name of the commenter.
     *
     * @return the name of the commenter.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ID of the comment.
     *
     * @return the ID of the comment.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the ID of the post associated with the comment.
     *
     * @return the post ID associated with the comment.
     */
    public String getPostId() {
        return postId;
    }
}