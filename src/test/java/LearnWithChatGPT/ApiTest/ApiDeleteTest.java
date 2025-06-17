package LearnWithChatGPT.ApiTest;

import org.junit.Test;
import static io.restassured.RestAssured.*;

public class ApiDeleteTest {

    @Test
    public void testDeletePost() {
        given()
                .when()
                    .delete("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                    .log().all()
                    .statusCode(200); // Иногда API возвращает 204 No Content
    }
}