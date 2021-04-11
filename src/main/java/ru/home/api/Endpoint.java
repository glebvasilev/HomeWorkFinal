package ru.home.api;

public enum Endpoint {
    AUTHORIZED("Account/v1/Authorized"),
    LOGIN("Account/v1/Login"),
    GENERATE("Account/v1/GenerateToken"),
    BOOKS("/BookStore/v1/Books"),
    USER("/Account/v1/User/");

    private String endPoint;

    Endpoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }
}
