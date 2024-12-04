package tests;

import core.services.PostService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class DeleteTest {

    PostService postService = new PostService();

    @Test
    public void testDeletePosts() {
        Random randomNumber = new Random();
        int idToDelete = randomNumber.nextInt(100) + 1;
        Response response = postService.deletePost(idToDelete);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.statusCode(), 200, "Unexpected status code");

    }
}
