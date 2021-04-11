package ru.home.ui.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import ru.home.ui.BasePage;
import ru.home.ui.elements.BSMenu;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class BSBasePage extends BasePage {



    public BSBasePage isBookStorePage() {
        log.info("Проверяем, что находимся на странице книжного магазина");
        $(By.className("main-header")).shouldHave(text("Book Store"));
        return this;
    }


    public BSLoginPage goToLoginPage() {
        log.info("Переходим на страницу авторизации");
        $x("//button[.='Login']").click();
        $(By.className("main-header")).shouldHave(text("Login"));
        return new BSLoginPage();
    }

    public BSBasePage checkBooksList() {
        log.info("Проверяем, что количество книг в списке > 0");
        if (!$x("//ul[@class='menu-list']//span[.='Book Store']//parent::li").getAttribute("class").contains("active")) {
            $x("//ul[@class='menu-list']//span[.='Book Store']").click();
        }
        assertTrue($$x("//div[@role='row']//div/span/a").texts().size() > 0, "Книги отсутствуют в списке");
        return this;
    }

    public BSBasePage goToPage(BSMenu bsMenu) {
        log.info("Переходим на страницу {}", bsMenu.getPage());
        $x(String.format("//ul[@class='menu-list']//span[.='%s']", bsMenu.getPage())).scrollTo().click();
        return this;
    }

    public BSProfilePage goToProfilePage() {
        goToPage(BSMenu.PROFILE);
        return new BSProfilePage();
    }

    public BSBasePage goToBookStorePage() {
        goToPage(BSMenu.BOOKSTORE);
        return this;
    }

    public BSBasePage openBookDetails() {
        log.info("Открываем страницу с подробной информацией о книге");
        String title = $$x("//div[@role='row']//div/span/a").stream().findAny().get().text();
        $$x("//div[@role='row']//div/span/a").findBy(text(title)).click();
        assertEquals(getSelectedBookTitle(), title);
        return this;
    }

    public String getSelectedBookTitle() {
        return $x("//div[contains(@class, 'profile')]//label[@id='title-label']/../following-sibling::div/label").text();
    }

    public BSBasePage addBookToCollection() {
        log.info("Добавляем книгу в коллекцию");
        $x("//button[@id='addNewRecordButton' and text()='Add To Your Collection']").click();
        if(switchTo().alert().getText().equals("Book added to your collection.")){
            switchTo().alert().accept();
        }
        return this;
    }

}
