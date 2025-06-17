package LearnWithChatGPT.ApiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class ApiPostTest {

    @Test
    public void testCreatePost() {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
                .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                    .log().all()
                    .statusCode(201)
                    .body("title", equalTo("foo"))
                    .body("body", equalTo("bar"))
                    .body("userId", equalTo(1))
                    .body("id", notNullValue()); // API возвращает сгенерированный ID
    }
}
