package ru.home.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.home.ui.pages.BSBasePage;

public class BooksAdded extends MainUI {

    private BSBasePage bsBasePage;


    @BeforeEach
    void before() {
        bsBasePage = new BSBasePage();
    }

    @DisplayName("Add book to collection")
    @CsvSource({"Test, Q!w2e3r4t5y6"})
    @ParameterizedTest(name = "{displayName}, login: {0}, password: {1}")
    void booksAdded(String login, String password) {
        bsBasePage.openAppsPage()
                .goToBookStoreApp()
                .isBookStorePage()
                .goToLoginPage()
                .isLoginPage()
                .login(login, password, true)
                .goToBookStorePage()
                .openBookDetails();
        String bookName = bsBasePage.getSelectedBookTitle();
        bsBasePage.addBookToCollection()
                .goToProfilePage()
                .isProfilePage()
                .bookIsInCollection(bookName);
    }

    @DisplayName("Delete book from collection")
    @CsvSource({"Test, Q!w2e3r4t5y6"})
    @ParameterizedTest(name = "{displayName}, login: {0}, password: {1}")
    void booksDeleted(String login, String password) {
        bsBasePage.openAppsPage()
                .goToBookStoreApp()
                .isBookStorePage()
                .goToLoginPage()
                .isLoginPage()
                .login(login, password, true)
                .goToBookStorePage()
                .openBookDetails();
        String bookName = bsBasePage.getSelectedBookTitle();
        bsBasePage.addBookToCollection()
                .goToProfilePage()
                .isProfilePage()
                .bookIsInCollection(bookName)
                .deleteBookFromCollection(bookName)
                .checkCollectionListEmpty();
    }
}
