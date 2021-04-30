import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class HomeButton extends PageBase {

    public HomeButton(WebDriver driver) {
        super(driver);
    }

    // Find the Gmail home button and click it
    public void goHomepage() {
        By ByPrimary = By.xpath("//a[@class='gb_le gb_qc gb_je']");
        this.waitAndReturnElement(ByPrimary).click();
    }
}