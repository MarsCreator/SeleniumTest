package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    @FindBy(xpath = "//div[@class='place-list place-list_ancient-design_yes']/li[@class='place-list__item']")
    private WebElement firstFoumdCityLabel;

    public final WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getFirstFoundCityText() {
        return firstFoumdCityLabel.getText();
    }
}
