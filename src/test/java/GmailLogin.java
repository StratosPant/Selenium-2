import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class GmailLogin extends PageBase {

    // Login URL
    public GmailLogin(WebDriver driver) {
        super(driver);
        this.driver.get("https://mail.google.com/mail/");
    }

    // Find the "identifier" field
    private By ByEmail = By.name("identifier");
    // Find the "password" field
    private By ByPassword = By.name("password");

    // Fill the fields with your Email and Password
    public GmailHome getEmailLogin() {
        this.waitAndReturnElement(ByEmail).sendKeys("gtest.sqat@gmail.com" + "\n");
        this.waitAndReturnElement(ByPassword).sendKeys("123abc!@#" + "\n");
        return new GmailHome(this.driver);
    }
}
