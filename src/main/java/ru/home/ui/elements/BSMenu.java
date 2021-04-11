package ru.home.ui.elements;

public enum BSMenu {

    BOOKSTORE("Book Store"),
    PROFILE("Profile");

    private String page;

    BSMenu(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }
}
