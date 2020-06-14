package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(how= How.XPATH, using = "//input[@type='email']")
    private List<WebElement> emailWebElements;
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-sm btn-tryFree w-150 fs-15 text-capitalize']")
    private WebElement emailSubmitButton;
    @FindBy(how = How.XPATH, using = "//a[@class='nav-link ' and text()='Features']")
    private WebElement featureLink;
    @FindBy(how = How.XPATH, using = "//a[@class='nav-link launch_intercom' and text()='Contact Us']")
    private WebElement contactUsElement;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        this.driver.get("https://joinassembly.com/");
    }

    public WebElement setEmailID(int emailFieldPosition, String emailID)
    {
        if(emailFieldPosition > emailWebElements.size())
        {
            return null;
        }

        WebElement emailField = emailWebElements.get(emailFieldPosition - 1);
        emailField.sendKeys(emailID);
        return emailField;
    }

    public int getEmailFieldCount()
    {
        return emailWebElements.size();
    }

    public void clickButton()
    {
        emailSubmitButton.click();
    }

    public void clickFeatureLink()
    {
        featureLink.click();
    }

    public WebElement getInputElementByPlaceHolder(String placeHolder)
    {
        return driver.findElement(By.xpath(placeHolder));
    }

    public void clickContactUsElement()
    {
        contactUsElement.click();
    }

    public void switchToAutomatedChatWindow()
    {
        driver.switchTo().frame(driver.findElement(By.name("intercom-note-frame")));
    }

    public void switchToSearchQueryChatWindow()
    {
        driver.switchTo().frame(driver.findElement(By.name("intercom-messenger-frame")));
    }

}
