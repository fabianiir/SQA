package core.model;

/**
 * PostModel class represents a model for post data.
 * It includes fields for user ID, post ID, title, and body of the post.
 */
public class PostModel {
    private int userId;
    private int id;
    private String title;
    private String body;

    /**
     * Sets the user ID associated with the post.
     *
     * @param userId the user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Sets the ID of the post.
     *
     * @param id the post ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the title of the post.
     *
     * @param title the title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the body of the post.
     *
     * @param body the body to set.
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Gets the body of the post.
     *
     * @return the body of the post.
     */
    public String getBody() {
        return body;
    }

    /**
     * Gets the title of the post.
     *
     * @return the title of the post.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the ID of the post.
     *
     * @return the ID of the post.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the user ID associated with the post.
     *
     * @return the user ID associated with the post.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Returns a string representation of the PostModel object.
     *
     * @return a string representation of the PostModel object.
     */
    @Override
    public String toString() {
        return "PostModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}