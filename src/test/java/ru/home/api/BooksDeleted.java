package ru.home.api;

import org.junit.jupiter.api.Test;
import ru.home.api.models.request.BooksDTO;
import ru.home.api.models.request.LoginDTO;
import ru.home.api.models.response.ProfileBooks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BooksDeleted extends MainApi {

    @Test
    void deleteBookTest() {
        List<BooksDTO.CollectionDTO> isbn = new ArrayList<>();
        Collections.addAll(isbn, BooksDTO.CollectionDTO.builder().isbnItems("9781449337711").build());
        String userId =
                given(requestSpecification)
                        .body(LoginDTO.builder().build())
                        .when()
                        .post(Endpoint.LOGIN.getEndPoint())
                        .then()
                        .log()
                        .body()
                        .statusCode(200)
                        .extract().jsonPath().get("userId").toString();

        ProfileBooks profileBooks =
                given(requestSpecificationWithAuth)
                        .get(Endpoint.USER.getEndPoint() + userId)
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(ProfileBooks.class);

        String deletedItem = profileBooks.getBooks().stream().findFirst().get().getIsbn();

        given(requestSpecificationWithAuth)
                .body(BooksDTO.builder().userId(userId).isbn(deletedItem).build())
                .when()
                .post(Endpoint.BOOKS.getEndPoint())
                .then()
                .assertThat().body("isbn", equalTo(deletedItem))
                .statusCode(204);

    }
}
