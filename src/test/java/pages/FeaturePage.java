package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeaturePage {

    private WebDriver driver;


    @FindBy(how = How.XPATH, using = "//a[contains(@class, 'nav-link') and @href='#tab-1']")
    private WebElement recognitionElementTab;
    @FindBy(how = How.XPATH, using = "//a[contains(@class, 'nav-link') and @href='#tab-2']")
    private WebElement anniversaryAndBirthdayElementTab;

    public FeaturePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getRecognitionElementTab()
    {
        return recognitionElementTab;
    }

    public WebElement getAnniversaryAndBirthdays()
    {
        return anniversaryAndBirthdayElementTab;
    }
}
