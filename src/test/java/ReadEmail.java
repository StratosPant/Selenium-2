import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoAlertPresentException;

class ReadEmail extends PageBase {

    public ReadEmail(WebDriver driver) {
        super(driver);
    }

    // Read the Title of the Email 
    public String readTitle() {
        // I use the 'class' to find the Title because Google change both 'Id' and 'aria-label' every time that do a refresh.*/
        By ByPrimary = By.xpath("//div[@class='ha']/h2"); 
        return this.waitAndReturnElement(ByPrimary).getText();
    }

    // Download Multiple Files from an Email as '.zip' file that you can find it in your downloads folder
    public void downloadFiles() {
        // I use the 'class' to find the download button because Google change both 'Id' and 'aria-label' every time that do a refresh.*/
        By ByPrimary = By.xpath("//div[@class='T-I J-J5-Ji aZj T-I-ax7 T-I-Js-IF L3']"); 
        this.waitAndReturnElement(ByPrimary).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        // Wait until find an Alert and select it 
        try {
            wait.until((WebDriver driver) -> {
                try {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                    return true;
                } catch (NoAlertPresentException e) {
                    return false;
                }
            });
        } catch (TimeoutException e) {}
    }

}