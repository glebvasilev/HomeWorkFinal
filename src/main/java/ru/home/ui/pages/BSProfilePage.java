package ru.home.ui.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class BSProfilePage extends BSBasePage {

    public BSProfilePage isProfilePage() {
        log.info("Проверяем, что находимся на странице профиля");
        $(By.className("main-header")).shouldHave(text("Profile"));
        return this;
    }

    public BSProfilePage bookIsInCollection(String bookName) {
        assertTrue($x("//div[contains(@class, 'profile')]//div[@class='action-buttons']/span/a").text().equals(bookName), "Книга отсутствует в списке");
        return this;
    }

    public BSProfilePage deleteBookFromCollection(String bookName) {
        $$x("//div[contains(@class, 'profile')]//div[@class='action-buttons']/span/a").findBy(text(bookName)).$x("./ancestor::div[@role='row']//div[@class='action-buttons']/span[@title='Delete']").click();
        $(By.className("modal-body")).shouldHave(text("Do you want to delete this book?"));
        $x("//div[@class='modal-footer']/button[text()='OK']").click();
        if(switchTo().alert().getText().equals("Book deleted.")){
            switchTo().alert().accept();
        }
        return this;
    }

    public BSProfilePage checkCollectionListEmpty() {
        $x("//*[contains(text(),'No rows found')]").shouldBe(visible);
        return this;
    }


    public void list() {
        List<List<String>> list = new ArrayList<>();
        List<String> lst = new ArrayList<>();
        Collections.addAll(lst,"13","61");
        Collections.addAll(list, lst);
    }

}
