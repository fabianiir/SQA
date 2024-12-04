package tests;

import core.model.CommentsModel;
import core.model.PostModel;
import core.services.PostService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;


public class GetTest {

    PostService postService = new PostService();

    @Test
    public void testGetAllPosts() {
        Response response = postService.getPosts();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.statusCode(), 200, "Unexpected status code");
        List<PostModel> posts = response.jsonPath().getList("", PostModel.class);
        posts.forEach(post -> {
            Assert.assertNotNull(post.getUserId(), "ID should not be null");
            Assert.assertNotNull(post.getId(), "ID should not be null");
            Assert.assertNotNull(post.getTitle(), "Title should not be null");
            Assert.assertNotNull(post.getBody(), "Body should not be null");
        });
    }

    @Test
    public void testGetPost() {
        Random randomNumber = new Random();
        int randomID = randomNumber.nextInt(100) + 1;
        Response response = postService.getPostByID(String.valueOf(randomID));
        Assert.assertNotNull(response);
        Assert.assertEquals(response.statusCode(), 200, "Unexpected status code");
        PostModel post = response.as(PostModel.class);
        Assert.assertEquals(post.getId(),randomID, "ID is not equals");
        Assert.assertNotNull(post.getUserId(), "ID should not be null");
        Assert.assertNotNull(post.getId(), "ID should not be null");
        Assert.assertNotNull(post.getTitle(), "Title should not be null");
        Assert.assertNotNull(post.getBody(), "Body should not be null");
    }

    @Test
    public void testGetCommentsPost() {
        Random randomNumber = new Random();
        int randomID = randomNumber.nextInt(100) + 1;
        Response response = postService.getPostCommentsByID(randomID);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.statusCode(), 200, "Unexpected status code");
        List<CommentsModel> posts = response.jsonPath().getList("", CommentsModel.class);
        posts.forEach(post -> {
            Assert.assertEquals(Integer.parseInt(post.getPostId()),randomID, "PostID is not " +
                    "equals");
            Assert.assertNotNull(post.getId(), "ID should not be null");
            Assert.assertNotNull(post.getEmail(), "Email should not be null");
            Assert.assertNotNull(post.getName(), "Name should not be null");
            Assert.assertNotNull(post.getBody(), "Body should not be null");

        });
    }
    @Test
    public void testFindCommentsPost() {
        Random randomNumber = new Random();
        int randomID = randomNumber.nextInt(100) + 1;
        Response response = postService.findCommentsByID(randomID);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.statusCode(), 200, "Unexpected status code");
        List<CommentsModel> posts = response.jsonPath().getList("", CommentsModel.class);
        posts.forEach(post -> {
            Assert.assertEquals(Integer.parseInt(post.getPostId()),randomID, "PostID is not " +
                    "equals");
            Assert.assertNotNull(post.getId(), "ID should not be null");
            Assert.assertNotNull(post.getEmail(), "Email should not be null");
            Assert.assertNotNull(post.getName(), "Name should not be null");
            Assert.assertNotNull(post.getBody(), "Body should not be null");

        });
    }

    @Test
    public void testGetPostBadID() {
        Response response = postService.getPostByID("200");
        Assert.assertNotNull(response);
        Assert.assertEquals(response.statusCode(), 404, "Unexpected status code");
        PostModel post = response.as(PostModel.class);
        Assert.assertEquals(post.getUserId(),0, "userId should be 0");
        Assert.assertEquals(post.getId(), 0,"ID should be 0");
        Assert.assertNull(post.getTitle(), "Title should be null");
        Assert.assertNull(post.getBody(), "Body should  be null");
    }
}
