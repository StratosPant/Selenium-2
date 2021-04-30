import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.UnexpectedAlertBehaviour;

public class GmailTest {
    public WebDriver driver;

    @Before
    public void setup() {
        // Seting for Download popup
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(dc);
        driver.manage().window().maximize();
    }

    @Test
    public void TestGmail() {
        // Login and go to HomePage
        GmailLogin gmailLogin = new GmailLogin(this.driver);
        GmailHome gmailHome = gmailLogin.getEmailLogin();

        // Check if you are on the HomePage
        Assert.assertTrue(gmailHome.getMainText().contains("Primary"));

        // Serch an Email
        SearchResultPage searchResultPage = gmailHome.searchEmail();

        // Select an Email
        ReadEmail readEmail = searchResultPage.selectEmail();

        // Read an Email Title
        readEmail.readTitle();

        // Download Multiple files
        readEmail.downloadFiles();

        // MultiplePage Test with array {"Starred", "Snoozed", "Sent", "Drafts"}
        MultiplePageTest multiplePageTest = new MultiplePageTest(driver);
        multiplePageTest.fromArray(new String[] { "Starred", "Snoozed", "Sent", "Drafts" });

        // Go to Homepage
        HomeButton homeButton = new HomeButton(driver);
        homeButton.goHomepage();

        // Logout test
        gmailHome.userLogout();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://accounts.google.com/ServiceLogin"));
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
