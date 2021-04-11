package ru.home.ui;

import org.openqa.selenium.By;

public enum Apps {
    BOOKSTOREAPP(By.xpath("//div[@class='card-body']/h5[text()='Book Store Application']"));

    private By path;

    Apps(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}
