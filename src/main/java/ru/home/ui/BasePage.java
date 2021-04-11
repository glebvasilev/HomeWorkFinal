package ru.home.ui;

import com.codeborne.selenide.CollectionCondition;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import ru.home.ui.pages.BSBasePage;

import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class BasePage {

    Props props = ConfigFactory.create(Props.class);

    public BasePage openAppsPage() {
        log.info("Открываем страницу сайта");
        open(props.demoqaUrl());
        $$x("//div[@class='card-body']/h5").shouldHave(CollectionCondition.sizeGreaterThan(1));
        return this;
    }

    public BasePage goToApp(Apps app) {
        log.info("Переходим к приложению {}", app);
        $(app.getPath()).scrollTo().click();
        return this;
    }

    public BSBasePage goToBookStoreApp() {
        goToApp(Apps.BOOKSTOREAPP);
        return new BSBasePage();
    }
}
