package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Wait;

import java.util.List;

public class ChatWindow {

    private WebDriver driver;
    public ChatWindow(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//textarea[@name='message']")
    private WebElement textInputBox;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'intercom-launcher')]")
    private WebElement chatWindowLauncher;

    @FindBy(how = How.XPATH, using= "//span[@role='button']")
    private WebElement automatedChatCloseButton;

    public void clickAutomatedChatCloseButton()
    {
  //      Wait.untilWebElement(driver, ExpectedConditions.elementToBeClickable(automatedChatCloseButton));
  //      automatedChatCloseButton.click();
        driver.findElement(By.xpath("//span[@role='button']")).click();
    }

    public WebElement getChatWindowElement()
    {
        return driver.findElement(By.xpath("//div[contains(@class,'intercom-messenger-frame')]"));
    }

    public void setInputTextForFirstQuery(String query)
    {
        Wait.until(driver, ExpectedConditions.elementToBeSelected(textInputBox));
        textInputBox.sendKeys(query);
        textInputBox.sendKeys(Keys.ENTER);
    }

    public void setInputText(String query)
    {
        WebElement inputTextElement = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Search our articles']"));
        inputTextElement.sendKeys(query);
        inputTextElement.sendKeys(Keys.ENTER);
    }

    public void searchQuery()
    {
        WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label='Submit search']"));
        searchButton.click();
    }

    public List<WebElement> getCommentList()
    {
        List<WebElement> commentList = driver.findElements(By.xpath("//div[contains(@class,'intercom-comment')]"));
        return commentList;
    }

    public void waitForChatWindowLauncher()
    {
        Wait.until(driver, ExpectedConditions.elementToBeSelected(chatWindowLauncher));
    }

    public WebElement getSearchResultText(String query)
    {
        return driver.findElement(By.xpath("//*[contains(text(), 'Search results for \"" + query + "\"')]"));
    }
}
