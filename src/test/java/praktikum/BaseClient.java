package praktikum;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseClient {
    protected static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    protected RequestSpecification getSpec() {
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL);
    }
}
