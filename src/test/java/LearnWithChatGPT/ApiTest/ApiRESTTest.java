package LearnWithChatGPT.ApiTest;

import io.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class ApiRESTTest {

    @Test
    public void testGetUserById() {
        RestAssured
                .given()
                .when()
                    .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("id", equalTo(1))
                    .body("username", equalTo("Bret"));
    }
}
