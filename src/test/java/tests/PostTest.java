package tests;

import core.model.PostModel;
import core.services.PostService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PostTest {

    PostService postService = new PostService();

    @Test
    public void testCreatePost(){
        Response response = postService.createPost(2,"titleTest","bodyTest");
        Assert.assertNotNull(response,"Response is null");
        Assert.assertEquals(response.statusCode(),201, "Status code is not 201");
        PostModel postModel = response.as(PostModel.class);
        Assert.assertEquals(postModel.getId(),101, "Post Creation failed");
    }
}
