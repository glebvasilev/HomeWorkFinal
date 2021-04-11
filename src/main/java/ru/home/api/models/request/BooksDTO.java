package ru.home.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BooksDTO {

    private String isbn;
    private String userId;
    private List<CollectionDTO> collectionOfIsbns;


    @Data
    @Builder
    public static class CollectionDTO {

        @JsonProperty("isbn")
        private String isbnItems;

    }
}
