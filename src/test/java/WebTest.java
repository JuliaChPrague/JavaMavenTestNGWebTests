import com.google.common.util.concurrent.ServiceManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class WebTest {

    /**
     * Тест кейс:
     * 1. Открыть страницу "http://www.99-bottles-of-beer.net/"
     * 2. Нажать пункт меню Browse Language
     * 3. Нажать пункт меню Start
     * 4. Подтвердить, что пользователь видит заголовок "Welcome to 99 Bottles of Beer"
     * 5. Закрыть браузер
     */

    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();


        driver.get(url); //открытие синтетич.драйвера

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']")
        );
        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h2"));
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_01 Подтвердите, что на странице по базовой ссылке в правом верхнем углу
     * пользователь видит заголовок 99 Bottles of Beer
     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Считать заголовок в правом верхнем углу
     * 3. Подтвердить, что текст заголовка соответствует ожидаемому
     * 4. Закрыть браузер
     */


    @Test
    public void testTitleRightUpMenu() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement title = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='header']/h1"));
        String actualResult = title.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_02 Подтвердите, что на странице по базовой ссылке последний пункт меню называется
     * Submit new Language
     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Считать название последнего пункта меню
     * 3. Подтвердить, что название последнего пункта меню соответствует ожидаемому
     * 4. Закрыть браузер
     */

    @Test
    public void testLastPointOfMenuSubmitNewLanguage() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit new Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement lastPointMenu = driver.findElement(
                By.xpath("//div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));
        String actualResult = lastPointMenu.getText();

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        driver.quit();
    }

    /**
     * TC_11_03 Подтвердите, что на странице по базовой ссылке последний пункт меню имеет подзаголовок Submit new Language
     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Нажать на пункт меню Submit new Language
     * 3. Считать название подзаголовка последнего пункта меню
     * 4. Подтвердить, что название подзаголовка последнего пункта меню соответствует ожидаемому
     * 5. Закрыть браузер
     */

    @Test
    public void testLastPointMenuHaveSubtitleSubmitNewLanguage() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement lastPointMenu = driver.findElement
                (By.xpath("//div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));
        lastPointMenu.click();

        WebElement submitNL = driver.findElement
                (By.xpath("//div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']"));
        String actualResult = submitNL.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_04 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/abc.html ,
     * первый пункт подменю называется 0-9
     * Шаги:
     * 1. Открыть вебсайт на странице
     * 2. Считать название первого подзаголовка
     * 3. Подтвердить, что название подменю соответствует ожидаемому
     * 4. Закрыть браузер
     */

    @Test
    public void testFirstPointOfMenu09() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submit09 = driver.findElement
                (By.xpath("//div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']"));
        String actualResult = submit09.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_06 Подтвердите, что имена создателей сайта: Oliver Schade, Gregor Scheithauer, Stefan Scheler
     * Шаги:
     * Напишите самостоятельно (найдите информацию о создателях на сайте, и опишите шаги для навигации и исполнения тест кейса)
     * 1. Открыть вебсайт на базовой странице
     * 2. Нажать на пункт подменю Team
     * 3. Считать название первого, второго и третьего заголовков
     * 4. Подтвердить, что названия заголовков соответствует ожидаемому
     * 5. Закрыть браузер
     */

    @Test
    public void testNameOfCreatorsOfWebsite() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult1 = "Oliver Schade";
        String expectedResult2 = "Gregor Scheithauer";
        String expectedResult3 = "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submenuTeam = driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']"));
        submenuTeam.click();
        WebElement nameOS = driver.findElement(By.xpath("//div[@id='wrap']/div[@id='main']/h3"));
        String actualResult1 = nameOS.getText();

        Assert.assertEquals(actualResult1, expectedResult1);

        WebElement nameGS = driver.findElement(By.xpath("//div[@id='wrap']/div[@id='main']/h3[2]"));
        String actualResult2 = nameGS.getText();

        Assert.assertEquals(actualResult2, expectedResult2);

        WebElement nameSS = driver.findElement(By.xpath("//div[@id='wrap']/div[@id='main']/h3[3]"));
        String actualResult3 = nameSS.getText();

        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }

    /**
     * TC_11_07 Придумайте и автоматизируйте свой собственный тест кейс на сайте http://www.99-bottles-of-beer.net/
     * Подтвердите, что на странице по базовой ссылке в пункте меню Browse Languages, в подпункте Java  есть заголовок
     * Language Java
     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Нажать на пункт меню Browse Languages
     * 3. В алфавитном списке подменю найти J букву, нажать
     * 4. Сравнить заголовок с ожиданием
     * 5. Закрыть браузер
     */

    @Test
    public void testSubmenuTitleLanguageJava() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Language Java";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBL = driver.findElement
                (By.xpath("//div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']"));
        menuBL.click();
        WebElement submitL = driver.findElement
                (By.xpath("//div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='j.html']"));
        submitL.click();
        WebElement submitJava = driver.findElement
                (By.xpath("//div[@id='wrap']/div[@id='main']/table[@id='category']/tbody/tr/td/a[@href='language-java-3.html']"));
        submitJava.click();
        WebElement textLJ = driver.findElement(By.xpath("//div[@id='wrap']/div[@id='main']/h2"));
        String actualResult = textLJ.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

//    TC_11_11 Подтвердите, что если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
//    пользователь нажмет кнопку Submit Language, не заполнив информацию в обязательных полях, будет показана ошибка
//    Error: Precondition failed - Incomplete Input.
//    Шаги:
//1. Открыть вебсайт на странице
//2. Нажать на кнопку Submit Language
//3. Подтвердить, что на странице показана ошибка
//4. Подтвердить, что текст ошибки соответствует ожидаемому
//5. Закрыть браузер

    @Test
    public void testShowError() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement buttonSubmitLanguage = driver.findElement
                (By.xpath("//div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']"));
        buttonSubmitLanguage.click();
        WebElement titleError = driver.findElement(By.xpath("//div[@id='wrap']/div[@id='main']/p"));
        String actualResult = titleError.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

 /**TC_11_12 Precondition: Если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html,
пользователь нажмет кнопку Submit Language, не заполнив информацию в обязательных полях, будет показана ошибка с текстом
Error: Precondition failed - Incomplete Input. Подтвердите, что в тексте ошибки слова Error,
  Precondition, Incomplete и Input написаны с большой буквы, а слово failed написано с маленькой буквы.
Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .
Шаги:
1. Открыть вебсайт на странице
2. Нажать на кнопку Submit Language
3. Считать текст ошибки
4. Подтвердить requirenments
5. Закрыть браузер
  */

    @Test
    public void testErrorPreconditionUpLowerLetter() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult1 = "Error";
        String expectedResult2 = "Precondition";
        String expectedResult3 = "Incomplete";
        String expectedResult4 = "Input";
        String expectedResult5 = "failed";
        String expectedResult6 = ",";
        String expectedResult7 = "-";
        String expectedResult8 = ".";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        driver.findElement(
                By.xpath("//div[@id='wrap']/div[@id='main']" +
                        "/form[@id='addlanguage']/p/input[@type='submit']")).click();

        WebElement title = driver.findElement(By.xpath("//div[@id='wrap']/div[@id='main']/p"));

        Assert.assertEquals(title.getText().substring(0,5),expectedResult1);

        Assert.assertEquals(title.getText().substring(7,19 ), expectedResult2);

        Assert.assertEquals(title.getText().substring(29,39),expectedResult3);
        Assert.assertEquals(title.getText().substring(40,45),expectedResult3);
        Assert.assertEquals(title.getText().substring(20,26),expectedResult3);
        Assert.assertEquals(title.getText().substring(5,6),expectedResult3);
        Assert.assertEquals(title.getText().substring(27,28),expectedResult3);
        Assert.assertEquals(title.getText().substring(45),expectedResult3);

        driver.quit();
    }

//    TC_11_13 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html
//    в первом пункте списка пользователь видит текст
//    IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description),
//    the easier it will be for us and the faster your language will show up on this page. We don't have the time to mess
//    around with fixing your descriptions etc. Thanks for your understanding.
//    Шаги:
//1. Открыть вебсайт на странице
//2. Считать текст
//3. Подтвердить, что текст соответствует ожидаемому
//4. Закрыть браузер

    @Test
    public void testTextRight() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill out this " +
                "form (especially the language name and description)," +
                "the easier it will be for us and the faster your language will show up on this page. " +
                "We don't have the time to mess" +
                "around with fixing your descriptions etc. Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement text = driver.findElement(By.xpath("//div[@id='wrap']/div[@id='main']/ul/li[1]"));
        String actualResult = text.getText().replaceAll("\\s+", "");

        Assert.assertEquals(actualResult, expectedResult.replaceAll("\\s+", ""));

        driver.quit();
    }

/**TC_11_14 Подтвердите, что нажав на пункт меню Browse Languages, пользователь увидит таблицу
со следующими названиями для первого и второго столбцов:
Language
Author
 Шаги:
1. Открыть вебсайт на базовой странице
2. Нажать на пункт меню Browse Languages
3. Считать названия первого и второго столбцов таблицы
3. Подтвердить, что названия соответствует ожидаемым
4. Закрыть браузер
 */

    @Test
    public void testColomsTitle() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\yulia\\Downloads\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBL = driver.findElement(
                By.xpath("//div[@id='wrap']/div[@id='navigation']//a[@href='/abc.html']"));
        menuBL.click();
    }

/**TC_11_21 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html
 пользователь видит предупреждение IMPORTANT:, написанное белыми буквами bold шрифтом на красном фоне,
 и что все буквы - capital
 Шаги:
1. Открыть вебсайт на странице
2. Считать слово IMPORTANT: из списка
3. Подтвердить requirenments
4. Закрыть браузер
 */



}








