package LearnWithChatGPT.ApiTest;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class ApiNegativeTest {

    @Test
    public void testNotFound() {
        given()
                .when()
                    .get("https://jsonplaceholder.typicode.com/posts/9999") // такой поста нет
                .then()
                    .log().all()
                    .statusCode(404); // ожидаем ошибку "не найдено"
    }

    @Test
    public void testBadRequest() {
        given()
                .contentType("application/json")
                    .body("Это не JSON")
                .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                    .log().all()
                    .statusCode(400); // Реальный API может вернуть 500, но мы проверим устойчивость
    }
}