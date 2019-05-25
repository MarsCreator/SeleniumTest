package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherPage {

    public final WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Город или район']")
    private WebElement citySearchField;

    public WeatherPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void typeCityIntoSearchField (String city){
        citySearchField.sendKeys(city);
    }

    public SearchResultPage search(){
        citySearchField.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
