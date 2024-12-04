package core.config;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * BaseConfig class provides basic HTTP methods for interacting with a RESTful API.
 * It uses RestAssured to perform HTTP requests to a predefined base URI.
 */
public class BaseConfig {

    static {
        // Sets the base URI for all requests made using RestAssured.
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    /**
     * Sends a GET request to the specified path.
     *
     * @param path the path to send the GET request to, relative to the base URI.
     * @return the response of the GET request.
     */
    public Response get(String path) {
        return RestAssured.get(path);
    }

    /**
     * Sends a POST request to the specified path with the given body.
     *
     * @param path the path to send the POST request to, relative to the base URI.
     * @param body the body of the POST request.
     * @return the response of the POST request.
     */
    public Response post(String path, String body) {
        return RestAssured.given().body(body).post(path);
    }

    /**
     * Sends a PUT request to the specified path with the given body.
     *
     * @param path the path to send the PUT request to, relative to the base URI.
     * @param body the body of the PUT request.
     * @return the response of the PUT request.
     */
    public Response put(String path, String body) {
        return RestAssured.given().body(body).put(path);
    }

    /**
     * Sends a PATCH request to the specified path with the given body.
     *
     * @param path the path to send the PATCH request to, relative to the base URI.
     * @param body the body of the PATCH request.
     * @return the response of the PATCH request.
     */
    public Response patch(String path, String body) {
        return RestAssured.given().body(body).patch(path);
    }

    /**
     * Sends a DELETE request to the specified path.
     *
     * @param path the path to send the DELETE request to, relative to the base URI.
     * @return the response of the DELETE request.
     */
    public Response delete(String path) {
        return RestAssured.delete(path);
    }
}