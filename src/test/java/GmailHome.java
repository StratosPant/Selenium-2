import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class GmailHome extends PageBase {

    public GmailHome(WebDriver driver) {
        super(driver);
    }

    // Find the name of a label and check if you are at the HomePage
    public String getMainText() {
        By ByPrimary = By.id(":3");
        return this.waitAndReturnElement(ByPrimary).getText();
    }

    // Search for Emails with title "test files"
    public SearchResultPage searchEmail() {
        By ByPrimary = By.xpath("//div[@id='gs_lc50']/input[@aria-label='Search mail']");
        this.waitAndReturnElement(ByPrimary).sendKeys("test files\n");
        return new SearchResultPage(driver);
    }

    // Find the User button
    private By searchClickUserBy = By.xpath(
            "//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']");
    // Find the Logout button
    private By searchSingoutBy = By.id("gb_71");

    // Logout
    public GmailLogout userLogout() {
        this.waitAndReturnElement(searchClickUserBy).click();
        this.waitAndReturnElement(searchSingoutBy).click();
        return new GmailLogout(this.driver);
    }
}
