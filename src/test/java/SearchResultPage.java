import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class SearchResultPage extends PageBase {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    // Open an Email
    public ReadEmail selectEmail() {
        By ByPrimary = By
                .xpath("//tr[@class='zA yO byw']"); /*
                                                     * I use the 'class' to find the Email because Google change both
                                                     * 'Id' and 'aria-label' every time that do a refresh. (It's not the
                                                     * best way to use 'class' but at this time it is the only thing
                                                     * that stays the same every time)
                                                     */
        this.waitAndReturnElement(ByPrimary).click();
        return new ReadEmail(driver);
    }
}
