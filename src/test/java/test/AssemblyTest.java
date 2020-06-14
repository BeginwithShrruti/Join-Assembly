package test;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ChatWindow;
import pages.FeaturePage;
import pages.HomePage;
import utils.GenerateReport;
import utils.Wait;


@Listeners(GenerateReport.class)
public class AssemblyTest extends TestBase {

    private static final Logger LOGGER = LogManager.getLogger(AssemblyTest.class);

    @Test
    public void emailFieldCountTest()
    {
        LOGGER.info("Fetching all the email ID fields on assembly homepage ");
        HomePage assemblyHomePage = PageFactory.initElements(driver, HomePage.class);
        int result = assemblyHomePage.getEmailFieldCount();
        Assert.assertEquals(result, 2);
    }

    @Test
    public void nonWorkEmailIDTest()
    {
        LOGGER.info("Input & check non-work email Id");
        HomePage assemblyHomePage = PageFactory.initElements(driver, HomePage.class);
        assemblyHomePage.setEmailID(2, "abc@gmail.com");
        assemblyHomePage.clickButton();
        Wait.untilPageLoadComplete(driver, 10L);
        Assert.assertEquals(driver.getTitle(), "Free Employee Recognition Software with Slack Integration | Assembly");
    }

    @Test
    public void workEmailIDTest() throws InterruptedException
    {
        LOGGER.info("Input & check work email Id");
        HomePage assemblyHomePage = PageFactory.initElements(driver, HomePage.class);
        assemblyHomePage.setEmailID(2, "abc@carrothr.com");
        assemblyHomePage.clickButton();
        Wait.untilPageLoadComplete(driver, 10L);
        Assert.assertEquals(driver.getTitle(), "Assembly - Empower your team");
    }

    @Test
    public void clickSubHeadingTest()
    {
        LOGGER.info("Navigate to Feature sub-heading of assembly");
        HomePage assemblyHomePage = PageFactory.initElements(driver, HomePage.class);
        assemblyHomePage.clickFeatureLink();

        FeaturePage featurePage = PageFactory.initElements(driver, FeaturePage.class);
        WebElement element = featurePage.getRecognitionElementTab();
        Assert.assertNotNull(element);

        WebElement anniversaryElement = featurePage.getAnniversaryAndBirthdays();
        Assert.assertNotNull(anniversaryElement);
        anniversaryElement.click();
        Assert.assertEquals("nav-link active", anniversaryElement.getAttribute("class"));
        Assert.assertEquals("nav-link", element.getAttribute("class"));
    }

    @Test
    public void clickContactUsTest()
    {
        LOGGER.info("Interact with chat window & browse contacts on assembly");
        HomePage assemblyHomePage = PageFactory.initElements(driver, HomePage.class);
        ChatWindow chatWindow = PageFactory.initElements(driver, ChatWindow.class);
        Wait.untilPageLoadComplete(driver, 10L);
        assemblyHomePage.switchToAutomatedChatWindow();
        chatWindow.clickAutomatedChatCloseButton();
        assemblyHomePage.clickContactUsElement();

        WebElement chatWindowElement = chatWindow.getChatWindowElement();
        Assert.assertNotNull(chatWindowElement);

        assemblyHomePage.switchToSearchQueryChatWindow();
        chatWindow.setInputText("slack");
        WebElement searchResultText = chatWindow.getSearchResultText("slack");
        Assert.assertNotNull(searchResultText);

    }


}
