package tests;

import core.model.PostModel;
import core.services.PostService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class PutTest {
    PostService postService = new PostService();

    @Test
    public void testPutPost(){
        Random randomNumber = new Random();
        int idToUpdate = randomNumber.nextInt(100) + 1;
        Response response = postService.updatePost(idToUpdate,2,"titleTest","bodyTest");
        Assert.assertNotNull(response,"Response is null");
        Assert.assertEquals(response.statusCode(),200, "Status code is not 200");
        PostModel postModel = response.as(PostModel.class);
        Assert.assertEquals(postModel.getId(),idToUpdate, "Update Post failed");
    }
}
