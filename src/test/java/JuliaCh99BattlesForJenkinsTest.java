import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JuliaCh99BattlesForJenkinsTest {

    String chromeDriver = "webdriver.chrome.driver";
    String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
    String url = "http://www.99-bottles-of-beer.net/";

    /**
     * TC_12_01 Подтвердите, что в меню BROWSE LANGUAGES, подменю  J, пользователь может найти
     * описание страницы, на которой перечислены все программные языки, начинающиеся с буквы J,
     * отсортированные по названию
     * Шаги:
     * Открыть базовую страницу
     * Нажать на пункт меню BROWSE LANGUAGES
     * Нажать на подменю J
     * Подтвердить, что пользователь видит текст “All languages starting with the letter J are shown,
     * sorted by Language.”
     */


    @Test
    public void testListOfAllLanguage() {
        String expectedResult =
                "All languages starting with the letter J are shown, sorted by Language.";
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/" +
                        "ul[@id='menu']/li/a[@href='/abc.html']")).click();
        driver.findElement(By.xpath("//div/ul[@id='submenu']/li/a[@href='j.html']")).click();
        WebElement text = driver.findElement(By.xpath("//div[@id='wrap']/div[@id='main']/p"));

        String actualResult = text.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
