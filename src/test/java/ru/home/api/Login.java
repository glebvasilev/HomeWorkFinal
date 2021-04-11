package ru.home.api;

import io.qameta.allure.restassured.AllureRestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import ru.home.api.models.request.LoginDTO;
import ru.home.ui.Props;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Login extends MainApi {

    private final Props props = ConfigFactory.create(Props.class);

    @Test
    void login() {
        given(requestSpecification)
                .filter(new AllureRestAssured())
                .body(LoginDTO
                        .builder()
                        .build())
                .when()
                .post(Endpoint.LOGIN.getEndPoint())
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    void incorrectAuth() {
        given()
                .spec(requestSpecification)
                .body(LoginDTO.builder()
                        .userName("Bob")
                        .password("Bob01")
                        .build())
                .when()
                .post("Account/v1/Authorized")
                .then()
                .assertThat()
                .body("message", equalTo("User not found!"))
                .statusCode(404);
    }

    @Test
    void incorrectLogin() {
        given()
                .spec(requestSpecification)
                .body(LoginDTO.builder()
                        .userName("Bob")
                        .password("Bob01")
                        .build())
                .when()
                .post(Endpoint.GENERATE.getEndPoint())
                .then().assertThat()
                .body("result", equalTo("User authorization failed."))
                .assertThat().body("status", equalTo("Failed"))
                .statusCode(200);
    }
}
