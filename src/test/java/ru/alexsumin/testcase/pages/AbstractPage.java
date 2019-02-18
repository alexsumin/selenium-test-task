package ru.alexsumin.testcase.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    WebDriver webDriver;
    WebDriverWait wait;

    AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
