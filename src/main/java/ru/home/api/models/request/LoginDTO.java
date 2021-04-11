package ru.home.api.models.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDTO {

    @Builder.Default
    private String userName = "Baby";
    @Builder.Default
    private String password = " Qqwerty123";
}
