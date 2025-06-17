package LearnWithChatGPT.ApiTest;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiParam {

    @Test
    public void testQueryParam() {
        given()
                .queryParam("page", 2)      // ?page=2
                .when()
                    .get("https://reqres.in/api/users")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("page", equalTo(2));  // Проверка, что вернулась вторая страница
    }

    @Test
    public void testPathParam() {
        given()
                .pathParam("id", 2)  // подставит в {id}
                .when()
                    .get("https://reqres.in/api/users/{id}")
                .then()
                    .log().all()
                    .statusCode(200)
                    .body("data.id", equalTo(2));
    }

    @Test
    public void testWithHeader() {
        given()
                .header("User-Agent", "Training-Agent")
                .when()
                    .get("https://reqres.in/api/users/2")
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
