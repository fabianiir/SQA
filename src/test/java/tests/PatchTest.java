package tests;

import core.model.PostModel;
import core.services.PostService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class PatchTest {
    PostService postService = new PostService();

    @Test
    public void testPatchPost(){
        Random randomNumber = new Random();
        int idToUpdate = randomNumber.nextInt(100) + 1;
        Response response = postService.patchPost(idToUpdate,"title","change");
        Assert.assertNotNull(response,"Response is null");
        Assert.assertEquals(response.statusCode(),200, "Status code is not 201");
        PostModel postModel = response.as(PostModel.class);
        Assert.assertEquals(postModel.getId(),idToUpdate, "Patch Post failed");
    }
}
