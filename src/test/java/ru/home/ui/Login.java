package ru.home.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.home.ui.pages.BSBasePage;

public class Login extends MainUI {

    private BSBasePage bsBasePage;


    @BeforeEach
    void before() {
        bsBasePage = new BSBasePage();
    }

    @DisplayName("Login with correct credentials")
    @CsvSource({"Baby, Qqwerty123"})
    @ParameterizedTest(name="{displayName}, login: {0}, password: {1}")
    void correctLogin(String login, String password) {
        bsBasePage.openAppsPage()
                .goToBookStoreApp()
                .isBookStorePage()
                .goToLoginPage()
                .isLoginPage()
                .login(login, password, true);
    }

    @DisplayName("Login with incorrect credentials")
    @CsvSource({"Bob, Bob01"})
    @ParameterizedTest(name="{displayName}, login: {0}, password: {1}")
    void incorrectLogin(String login, String password) {
        bsBasePage.openAppsPage()
                .goToBookStoreApp()
                .isBookStorePage()
                .goToLoginPage()
                .isLoginPage()
                .login(login, password, false)
                .checkErrorMessageAppears();
    }

}
