package ru.home.stepdef;

import com.codeborne.selenide.CollectionCondition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import ru.home.ui.Apps;
import ru.home.ui.Props;

import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class StepDefMainPage {

    Props props = ConfigFactory.create(Props.class);

    @Given("Открываем страницу сайта")
    public void openAppsPage() {
        log.info("Открываем страницу сайта");
        open(props.demoqaUrl());
        $$x("//div[@class='card-body']/h5").shouldHave(CollectionCondition.sizeGreaterThan(1));
    }


    private void goToApp(Apps app) {
        log.info("Переходим к приложению {}", app);
        $(app.getPath()).scrollTo().click();

    }

    @When("Переходим к приложению Book Store Application")
    public void goToBookStoreApp() {
        goToApp(Apps.BOOKSTOREAPP);
    }
}
