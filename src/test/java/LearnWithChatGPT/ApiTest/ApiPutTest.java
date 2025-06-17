package LearnWithChatGPT.ApiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class ApiPutTest {

    @Test
    public void testUpdatePost() {
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body("{ \"id\": 1, \"title\": \"updated\", \"body\": \"new body\", \"userId\": 1 }")
                .when()
                    .put("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("title", equalTo("updated"))
                    .body("body", equalTo("new body"))
                    .body("id", equalTo(1));
    }
}
