package LearnWithChatGPT.ApiTest;

import LearnWithChatGPT.PostRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class ApiPojoTest {

    @Test
    public void testRegisterUser() {
        PostRequest post = new PostRequest("foo", "bar", 1);

        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .body(post)
                    .log().all()
                .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                    .log().all()
                    .statusCode(201)
                    .body("title", equalTo("foo"))
                    .body("body", equalTo("bar"))
                    .body("userId", equalTo(1))
                    .body("id", notNullValue()); // Сервис возвращает сгенерированный ID
    }
}
