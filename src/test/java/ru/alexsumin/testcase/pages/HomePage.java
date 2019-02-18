package ru.alexsumin.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {

    @FindBy(className = "wg-header__desktop")
    private WebElement header;

    @FindBy(id = "modal-pro")
    private WebElement emailWindow;

    private By startFreeButtonLocator = By.className("wg-header__free-trial-button");
    private By emailLocator = By.name("email");
    private By createAccButtonLocator = By.className("wg-btn");
    private By formLocator = By.name("survey-form");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open() {
        webDriver.get("https://wrike.com");
    }

    public void getStartedForFreeButtonClick() {
        header.findElement(startFreeButtonLocator).click();
        wait.until(ExpectedConditions.visibilityOf(emailWindow));
    }

    public void enterEmail(String mail) {
        WebElement emailInput = emailWindow.findElement(emailLocator);
        emailInput.sendKeys(mail);
    }

    public void createAccount() {
        WebElement createAccountButton = emailWindow.findElement(createAccButtonLocator);
        createAccountButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(formLocator));
    }
}
