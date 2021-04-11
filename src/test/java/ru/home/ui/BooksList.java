package ru.home.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.home.ui.pages.BSBasePage;

public class BooksList extends MainUI {

    private BSBasePage bsBasePage;


    @BeforeEach
    void before() {
        bsBasePage = new BSBasePage();
    }

    @DisplayName("Check books list exist")
    @Test
    void booksList() {
        bsBasePage.openAppsPage()
                .goToBookStoreApp()
                .isBookStorePage()
                .checkBooksList();
    }
}
