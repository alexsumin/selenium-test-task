package ru.alexsumin.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Set;

public class ResendPage extends AbstractPage {

    @FindBy(className = "submit")
    private WebElement submitButton;

    @FindBy(className = "survey-success")
    private WebElement sucessElement;

    @FindBy(className = "wg-cell--order-1")
    private WebElement emailCell;

    @FindBy(className = "wg-footer__social-list")
    private WebElement footer;

    private WebElement twitterIcon;
    private WebElement button;
    private By buttonLocator = By.className("button");
    private By hrefLocator = By.cssSelector("[href=\"https://twitter.com/wrike\"]");
    private By iconLocator = By.className("wg-footer__social-icon");
    private By svgLocator = By.cssSelector("use[*|href='/content/themes/wrike/dist/img/sprite/vector//footer-icons.symbol.svg?v1#twitter']");
    private By interestLocator = By.xpath("//*[text()='Very interested']");
    private By teamMembersLocator = By.xpath("//*[text()='6–15']");
    private By processLocator = By.xpath("//*[text()='Yes']");
    private By formLocator = By.name("survey-form");

    public ResendPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillForm() {
        wait.until(ExpectedConditions.elementToBeClickable(formLocator));

        WebElement interestElement = webDriver.findElement(interestLocator);
        interestElement.click();

        WebElement teamMembersElement = webDriver.findElement(teamMembersLocator);
        teamMembersElement.click();

        WebElement processElement = webDriver.findElement(processLocator);
        processElement.click();

        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(sucessElement));
    }

    public void resendEmail() {
        button = emailCell.findElement(buttonLocator);
        button.click();
        wait.until(ExpectedConditions.invisibilityOfAllElements(button));
    }

    public boolean isEmailSent() {
        return !button.isDisplayed();
    }

    public boolean isTwitterVisible() {
        WebElement twitterElement = footer.findElement(hrefLocator);
        twitterIcon = twitterElement.findElement(iconLocator);
        WebElement useElement = webDriver.findElement(svgLocator);
        return useElement.isDisplayed();
    }

    public void clickTwitterIco() throws InterruptedException {
        twitterIcon.click();
        Thread.sleep(5000L);
        Set<String> allWindowHandles = webDriver.getWindowHandles();
        Iterator<String> iter = allWindowHandles.iterator();
        String mainWindow = iter.next();
        String childWindow = iter.next();
        webDriver.switchTo().window(childWindow);
    }
}