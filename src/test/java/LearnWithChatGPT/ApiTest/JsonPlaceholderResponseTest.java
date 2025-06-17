package LearnWithChatGPT.ApiTest;

import LearnWithChatGPT.PostRequest;
import LearnWithChatGPT.PostResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonPlaceholderResponseTest {

    @Test
    public void testCreatePostAndReadResponse() {
        PostRequest request = new PostRequest("foo", "bar", 1);

        PostResponse response = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(request)
                .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                    .statusCode(201)
                    .extract()
                    .as(PostResponse.class); // 👈 конвертация JSON-ответа в Java-объект

        // Проверка через Java
        assertEquals("foo", response.getTitle());
        assertEquals("bar", response.getBody());
        assertEquals(1, response.getUserId());
        assertTrue(response.getId() > 0); // ID генерируется сервером
    }
}
