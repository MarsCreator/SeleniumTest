package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[text()='Погода']")
    private WebElement weatherButton;

    public StartPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WeatherPage clickOnWeatherButton() {
        weatherButton.click();

        return new WeatherPage(driver);
    }

}
