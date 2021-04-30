import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

class MultiplePageTest extends PageBase {

    public MultiplePageTest(WebDriver driver) {
        super(driver);
    }

    // Check if you are at the correct page for all the values from array by looking the URL
    public void fromArray(String[] ariaLabels) {
        for (String label : ariaLabels) {
            By ByPrimary = By.xpath("//a[@aria-label='" + label + "']");
            this.waitAndReturnElement(ByPrimary).click();
            this.wait.until(ExpectedConditions.urlContains(label.toLowerCase()));
        }
    }

}