import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchResultPage;
import pages.StartPage;
import pages.WeatherPage;

import java.util.concurrent.TimeUnit;

public class MainTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        driver = new ChromeDriver();
    }

    @Before
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
    }

    public MainTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
    }

    @Test
    public void cityCheck() {
        StartPage startPage = new StartPage(driver);
        WeatherPage weatherPage = startPage.clickOnWeatherButton();
        weatherPage.typeCityIntoSearchField("Нью-Йорк");
        SearchResultPage searchResultPage = weatherPage.search();
        String actualText = searchResultPage.getFirstFoundCityText();
        Assert.assertTrue("Error", actualText.contains("Нью-Йорк, Штат Нью-Йорк, США"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
