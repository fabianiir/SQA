package core.services;

import core.config.BaseConfig;
import core.model.PostModel;
import io.restassured.response.Response;

/**
 * The {@code PostService} class provides methods to interact with post-related endpoints
 * of https://jsonplaceholder.typicode.com. It allows for retrieving, creating, updating, and
 * deleting posts and retrieving comments associated with posts.
 */
public class PostService {
    private BaseConfig baseConfig;

    /**
     * Constructs a new {@code PostService} instance, initializing the base configuration
     * for API requests.
     */
    public PostService() {
        this.baseConfig = new BaseConfig();
    }

    /**
     * Retrieves all posts.
     *
     * @return a {@code Response} object containing the response from the API.
     */
    public Response getPosts() {
        return baseConfig.get("/posts");
    }

    /**
     * Retrieves a post by its ID.
     *
     * @param id the ID of the post to retrieve.
     * @return a {@code Response} object containing the response from the API.
     */
    public Response getPostByID(String id) {
        return baseConfig.get("/posts/" + id);
    }

    /**
     * Retrieves comments for a specific post by the post's ID.
     *
     * @param id the ID of the post whose comments are to be retrieved.
     * @return a {@code Response} object containing the response from the API.
     */
    public Response getPostCommentsByID(int id) {
        return baseConfig.get("/posts/" + id + "/comments");
    }

    /**
     * Finds comments by post ID.
     *
     * @param id the ID of the post for which to find comments.
     * @return a {@code Response} object containing the response from the API.
     */
    public Response findCommentsByID(int id) {
        return baseConfig.get("/comments?postId=" + id);
    }

    /**
     * Creates a new post with the specified user ID, title, and body.
     *
     * @param userId the user ID associated with the post.
     * @param title  the title of the post.
     * @param body   the body of the post.
     * @return a {@code Response} object containing the response from the API.
     */
    public Response createPost(int userId, String title, String body) {
        PostModel postModel = new PostModel();
        postModel.setUserId(userId);
        postModel.setTitle(title);
        postModel.setBody(body);

        return baseConfig.post("/posts", postModel.toString());
    }

    /**
     * Updates an existing post with user ID, title, and body.
     *
     * @param id     the ID of the post to update.
     * @param userId the user ID associated with the post.
     * @param title  the new title of the post.
     * @param body   the new body of the post.
     * @return a {@code Response} object containing the response from the API.
     */
    public Response updatePost(int id, int userId, String title, String body) {
        PostModel postModel = new PostModel();
        postModel.setUserId(userId);
        postModel.setTitle(title);
        postModel.setBody(body);
        return baseConfig.put("/posts/" + id, postModel.toString());
    }

    /**
     * Partially updates a post with the specified ID, updating a specific field.
     *
     * @param idToUpdate  the ID of the post to update.
     * @param keyToUpdate the field to update (e.g., "id", "title", "body").
     * @param value       the new value for the specified field.
     * @return a {@code Response} object containing the response from the API.
     * @throws IllegalArgumentException if the key to update is not valid.
     */
    public Response patchPost(int idToUpdate, String keyToUpdate, String value) {
        PostModel postModel = new PostModel();
        if (keyToUpdate.equals("id")) {
            postModel.setId(Integer.parseInt(value));
        } else if (keyToUpdate.equals("title")) {
            postModel.setTitle(value);
        } else if (keyToUpdate.equals("body")) {
            postModel.setBody(value);
        } else {
            throw new IllegalArgumentException("Bad Key option");
        }
        return baseConfig.patch("/posts/" + idToUpdate, value);
    }

    /**
     * Deletes a post by its ID.
     *
     * @param id the ID of the post to delete.
     * @return a {@code Response} object containing the response from the API.
     */
    public Response deletePost(int id) {
        return baseConfig.delete("/posts/" + id);
    }
}