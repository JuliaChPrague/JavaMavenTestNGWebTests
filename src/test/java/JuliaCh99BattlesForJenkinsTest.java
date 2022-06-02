import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JuliaCh99BattlesForJenkinsTest {

        private static final String BASE_URL = "http://www.99-bottles-of-beer.net";

        private void getBottles(StringBuilder lyrics, int number, String btl) {
            lyrics.append(number).append(btl);
        }

        private void getNoMore(StringBuilder lyrics, String noMore, String btl) {
            lyrics.append(noMore).append(btl);
        }

        private String createLyrics() {
            final String BOTTLES_WALL_CS = " bottles of beer on the wall, ";
            final String BOTTLES_DOT_LN = " bottles of beer.\n";
            final String BOTTLES_DOT = " bottles of beer on the wall.";
            final String TAKE = "Take one down and pass it around, ";
            final String GO = "Go to the store and buy some more, ";
            final String NO_MORE = "No more";

            StringBuilder lyrics = new StringBuilder();

            getBottles(lyrics, 99, BOTTLES_WALL_CS);
            getBottles(lyrics, 99, BOTTLES_DOT_LN);
            for (int i = 98; i > -1; i--) {
                lyrics.append(TAKE);

                if (i == 1) {
                    getBottles(lyrics, i, BOTTLES_DOT.replace("s", ""));
                    getBottles(lyrics, i, BOTTLES_WALL_CS.replace("s", ""));
                    getBottles(lyrics, i, BOTTLES_DOT_LN.replace("s", ""));
                } else if (i == 0) {
                    getNoMore(lyrics, NO_MORE.toLowerCase(), BOTTLES_DOT);
                    getNoMore(lyrics, NO_MORE, BOTTLES_WALL_CS);
                    getNoMore(lyrics, NO_MORE.toLowerCase(), BOTTLES_DOT_LN);
                } else {
                    getBottles(lyrics, i, BOTTLES_DOT);
                    getBottles(lyrics, i, BOTTLES_WALL_CS);
                    getBottles(lyrics, i, BOTTLES_DOT_LN);
                }
            }
            lyrics.append(GO);
            getBottles(lyrics, 99, BOTTLES_DOT);

            return lyrics.toString();
        }

        @Test
        public void testSongLyricsText() {
            System.setProperty(chromeDriver, driverPath);
            WebDriver driver = new ChromeDriver();
            final String expectedResult = createLyrics();
            By pTags = By.xpath("//div[@id='main']/p");
            By menuSongLyrics = By.linkText("Song Lyrics");

            driver.get(BASE_URL);
            driver.findElement(menuSongLyrics).click();

            StringBuilder actualResult = new StringBuilder();

            List<WebElement> pAll = driver.findElements(pTags);
            for (WebElement p : pAll) {
                actualResult.append(p.getText());
            }

            Assert.assertEquals(actualResult.toString(), expectedResult);

            driver.quit();
        }

    String chromeDriver = "webdriver.chrome.driver";
    String driverPath = "C:/Users/yulia/Downloads/chromedriver/chromedriver.exe";
    String url = "http://www.99-bottles-of-beer.net/";

    @Test
    public void testLyricText() {
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        String expectedResult = "99 bottles of beer on the wall, 99 bottles of beer.\n" +
                "Take one down and pass it around, 98 bottles of beer on the wall.98 bottles of beer on the wall, 98 bottles of beer.\n" +
                "Take one down and pass it around, 97 bottles of beer on the wall.97 bottles of beer on the wall, 97 bottles of beer.\n" +
                "Take one down and pass it around, 96 bottles of beer on the wall.96 bottles of beer on the wall, 96 bottles of beer.\n" +
                "Take one down and pass it around, 95 bottles of beer on the wall.95 bottles of beer on the wall, 95 bottles of beer.\n" +
                "Take one down and pass it around, 94 bottles of beer on the wall.94 bottles of beer on the wall, 94 bottles of beer.\n" +
                "Take one down and pass it around, 93 bottles of beer on the wall.93 bottles of beer on the wall, 93 bottles of beer.\n" +
                "Take one down and pass it around, 92 bottles of beer on the wall.92 bottles of beer on the wall, 92 bottles of beer.\n" +
                "Take one down and pass it around, 91 bottles of beer on the wall.91 bottles of beer on the wall, 91 bottles of beer.\n" +
                "Take one down and pass it around, 90 bottles of beer on the wall.90 bottles of beer on the wall, 90 bottles of beer.\n" +
                "Take one down and pass it around, 89 bottles of beer on the wall.89 bottles of beer on the wall, 89 bottles of beer.\n" +
                "Take one down and pass it around, 88 bottles of beer on the wall.88 bottles of beer on the wall, 88 bottles of beer.\n" +
                "Take one down and pass it around, 87 bottles of beer on the wall.87 bottles of beer on the wall, 87 bottles of beer.\n" +
                "Take one down and pass it around, 86 bottles of beer on the wall.86 bottles of beer on the wall, 86 bottles of beer.\n" +
                "Take one down and pass it around, 85 bottles of beer on the wall.85 bottles of beer on the wall, 85 bottles of beer.\n" +
                "Take one down and pass it around, 84 bottles of beer on the wall.84 bottles of beer on the wall, 84 bottles of beer.\n" +
                "Take one down and pass it around, 83 bottles of beer on the wall.83 bottles of beer on the wall, 83 bottles of beer.\n" +
                "Take one down and pass it around, 82 bottles of beer on the wall.82 bottles of beer on the wall, 82 bottles of beer.\n" +
                "Take one down and pass it around, 81 bottles of beer on the wall.81 bottles of beer on the wall, 81 bottles of beer.\n" +
                "Take one down and pass it around, 80 bottles of beer on the wall.80 bottles of beer on the wall, 80 bottles of beer.\n" +
                "Take one down and pass it around, 79 bottles of beer on the wall.79 bottles of beer on the wall, 79 bottles of beer.\n" +
                "Take one down and pass it around, 78 bottles of beer on the wall.78 bottles of beer on the wall, 78 bottles of beer.\n" +
                "Take one down and pass it around, 77 bottles of beer on the wall.77 bottles of beer on the wall, 77 bottles of beer.\n" +
                "Take one down and pass it around, 76 bottles of beer on the wall.76 bottles of beer on the wall, 76 bottles of beer.\n" +
                "Take one down and pass it around, 75 bottles of beer on the wall.75 bottles of beer on the wall, 75 bottles of beer.\n" +
                "Take one down and pass it around, 74 bottles of beer on the wall.74 bottles of beer on the wall, 74 bottles of beer.\n" +
                "Take one down and pass it around, 73 bottles of beer on the wall.73 bottles of beer on the wall, 73 bottles of beer.\n" +
                "Take one down and pass it around, 72 bottles of beer on the wall.72 bottles of beer on the wall, 72 bottles of beer.\n" +
                "Take one down and pass it around, 71 bottles of beer on the wall.71 bottles of beer on the wall, 71 bottles of beer.\n" +
                "Take one down and pass it around, 70 bottles of beer on the wall.70 bottles of beer on the wall, 70 bottles of beer.\n" +
                "Take one down and pass it around, 69 bottles of beer on the wall.69 bottles of beer on the wall, 69 bottles of beer.\n" +
                "Take one down and pass it around, 68 bottles of beer on the wall.68 bottles of beer on the wall, 68 bottles of beer.\n" +
                "Take one down and pass it around, 67 bottles of beer on the wall.67 bottles of beer on the wall, 67 bottles of beer.\n" +
                "Take one down and pass it around, 66 bottles of beer on the wall.66 bottles of beer on the wall, 66 bottles of beer.\n" +
                "Take one down and pass it around, 65 bottles of beer on the wall.65 bottles of beer on the wall, 65 bottles of beer.\n" +
                "Take one down and pass it around, 64 bottles of beer on the wall.64 bottles of beer on the wall, 64 bottles of beer.\n" +
                "Take one down and pass it around, 63 bottles of beer on the wall.63 bottles of beer on the wall, 63 bottles of beer.\n" +
                "Take one down and pass it around, 62 bottles of beer on the wall.62 bottles of beer on the wall, 62 bottles of beer.\n" +
                "Take one down and pass it around, 61 bottles of beer on the wall.61 bottles of beer on the wall, 61 bottles of beer.\n" +
                "Take one down and pass it around, 60 bottles of beer on the wall.60 bottles of beer on the wall, 60 bottles of beer.\n" +
                "Take one down and pass it around, 59 bottles of beer on the wall.59 bottles of beer on the wall, 59 bottles of beer.\n" +
                "Take one down and pass it around, 58 bottles of beer on the wall.58 bottles of beer on the wall, 58 bottles of beer.\n" +
                "Take one down and pass it around, 57 bottles of beer on the wall.57 bottles of beer on the wall, 57 bottles of beer.\n" +
                "Take one down and pass it around, 56 bottles of beer on the wall.56 bottles of beer on the wall, 56 bottles of beer.\n" +
                "Take one down and pass it around, 55 bottles of beer on the wall.55 bottles of beer on the wall, 55 bottles of beer.\n" +
                "Take one down and pass it around, 54 bottles of beer on the wall.54 bottles of beer on the wall, 54 bottles of beer.\n" +
                "Take one down and pass it around, 53 bottles of beer on the wall.53 bottles of beer on the wall, 53 bottles of beer.\n" +
                "Take one down and pass it around, 52 bottles of beer on the wall.52 bottles of beer on the wall, 52 bottles of beer.\n" +
                "Take one down and pass it around, 51 bottles of beer on the wall.51 bottles of beer on the wall, 51 bottles of beer.\n" +
                "Take one down and pass it around, 50 bottles of beer on the wall.50 bottles of beer on the wall, 50 bottles of beer.\n" +
                "Take one down and pass it around, 49 bottles of beer on the wall.49 bottles of beer on the wall, 49 bottles of beer.\n" +
                "Take one down and pass it around, 48 bottles of beer on the wall.48 bottles of beer on the wall, 48 bottles of beer.\n" +
                "Take one down and pass it around, 47 bottles of beer on the wall.47 bottles of beer on the wall, 47 bottles of beer.\n" +
                "Take one down and pass it around, 46 bottles of beer on the wall.46 bottles of beer on the wall, 46 bottles of beer.\n" +
                "Take one down and pass it around, 45 bottles of beer on the wall.45 bottles of beer on the wall, 45 bottles of beer.\n" +
                "Take one down and pass it around, 44 bottles of beer on the wall.44 bottles of beer on the wall, 44 bottles of beer.\n" +
                "Take one down and pass it around, 43 bottles of beer on the wall.43 bottles of beer on the wall, 43 bottles of beer.\n" +
                "Take one down and pass it around, 42 bottles of beer on the wall.42 bottles of beer on the wall, 42 bottles of beer.\n" +
                "Take one down and pass it around, 41 bottles of beer on the wall.41 bottles of beer on the wall, 41 bottles of beer.\n" +
                "Take one down and pass it around, 40 bottles of beer on the wall.40 bottles of beer on the wall, 40 bottles of beer.\n" +
                "Take one down and pass it around, 39 bottles of beer on the wall.39 bottles of beer on the wall, 39 bottles of beer.\n" +
                "Take one down and pass it around, 38 bottles of beer on the wall.38 bottles of beer on the wall, 38 bottles of beer.\n" +
                "Take one down and pass it around, 37 bottles of beer on the wall.37 bottles of beer on the wall, 37 bottles of beer.\n" +
                "Take one down and pass it around, 36 bottles of beer on the wall.36 bottles of beer on the wall, 36 bottles of beer.\n" +
                "Take one down and pass it around, 35 bottles of beer on the wall.35 bottles of beer on the wall, 35 bottles of beer.\n" +
                "Take one down and pass it around, 34 bottles of beer on the wall.34 bottles of beer on the wall, 34 bottles of beer.\n" +
                "Take one down and pass it around, 33 bottles of beer on the wall.33 bottles of beer on the wall, 33 bottles of beer.\n" +
                "Take one down and pass it around, 32 bottles of beer on the wall.32 bottles of beer on the wall, 32 bottles of beer.\n" +
                "Take one down and pass it around, 31 bottles of beer on the wall.31 bottles of beer on the wall, 31 bottles of beer.\n" +
                "Take one down and pass it around, 30 bottles of beer on the wall.30 bottles of beer on the wall, 30 bottles of beer.\n" +
                "Take one down and pass it around, 29 bottles of beer on the wall.29 bottles of beer on the wall, 29 bottles of beer.\n" +
                "Take one down and pass it around, 28 bottles of beer on the wall.28 bottles of beer on the wall, 28 bottles of beer.\n" +
                "Take one down and pass it around, 27 bottles of beer on the wall.27 bottles of beer on the wall, 27 bottles of beer.\n" +
                "Take one down and pass it around, 26 bottles of beer on the wall.26 bottles of beer on the wall, 26 bottles of beer.\n" +
                "Take one down and pass it around, 25 bottles of beer on the wall.25 bottles of beer on the wall, 25 bottles of beer.\n" +
                "Take one down and pass it around, 24 bottles of beer on the wall.24 bottles of beer on the wall, 24 bottles of beer.\n" +
                "Take one down and pass it around, 23 bottles of beer on the wall.23 bottles of beer on the wall, 23 bottles of beer.\n" +
                "Take one down and pass it around, 22 bottles of beer on the wall.22 bottles of beer on the wall, 22 bottles of beer.\n" +
                "Take one down and pass it around, 21 bottles of beer on the wall.21 bottles of beer on the wall, 21 bottles of beer.\n" +
                "Take one down and pass it around, 20 bottles of beer on the wall.20 bottles of beer on the wall, 20 bottles of beer.\n" +
                "Take one down and pass it around, 19 bottles of beer on the wall.19 bottles of beer on the wall, 19 bottles of beer.\n" +
                "Take one down and pass it around, 18 bottles of beer on the wall.18 bottles of beer on the wall, 18 bottles of beer.\n" +
                "Take one down and pass it around, 17 bottles of beer on the wall.17 bottles of beer on the wall, 17 bottles of beer.\n" +
                "Take one down and pass it around, 16 bottles of beer on the wall.16 bottles of beer on the wall, 16 bottles of beer.\n" +
                "Take one down and pass it around, 15 bottles of beer on the wall.15 bottles of beer on the wall, 15 bottles of beer.\n" +
                "Take one down and pass it around, 14 bottles of beer on the wall.14 bottles of beer on the wall, 14 bottles of beer.\n" +
                "Take one down and pass it around, 13 bottles of beer on the wall.13 bottles of beer on the wall, 13 bottles of beer.\n" +
                "Take one down and pass it around, 12 bottles of beer on the wall.12 bottles of beer on the wall, 12 bottles of beer.\n" +
                "Take one down and pass it around, 11 bottles of beer on the wall.11 bottles of beer on the wall, 11 bottles of beer.\n" +
                "Take one down and pass it around, 10 bottles of beer on the wall.10 bottles of beer on the wall, 10 bottles of beer.\n" +
                "Take one down and pass it around, 9 bottles of beer on the wall.9 bottles of beer on the wall, 9 bottles of beer.\n" +
                "Take one down and pass it around, 8 bottles of beer on the wall.8 bottles of beer on the wall, 8 bottles of beer.\n" +
                "Take one down and pass it around, 7 bottles of beer on the wall.7 bottles of beer on the wall, 7 bottles of beer.\n" +
                "Take one down and pass it around, 6 bottles of beer on the wall.6 bottles of beer on the wall, 6 bottles of beer.\n" +
                "Take one down and pass it around, 5 bottles of beer on the wall.5 bottles of beer on the wall, 5 bottles of beer.\n" +
                "Take one down and pass it around, 4 bottles of beer on the wall.4 bottles of beer on the wall, 4 bottles of beer.\n" +
                "Take one down and pass it around, 3 bottles of beer on the wall.3 bottles of beer on the wall, 3 bottles of beer.\n" +
                "Take one down and pass it around, 2 bottles of beer on the wall.2 bottles of beer on the wall, 2 bottles of beer.\n" +
                "Take one down and pass it around, 1 bottle of beer on the wall.1 bottle of beer on the wall, 1 bottle of beer.\n" +
                "Take one down and pass it around, no more bottles of beer on the wall.No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.";

        driver.get(url);
        driver.findElement(
                        By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='submenu']/li/a[@href='lyrics.html']"))
                .click();

        String[] pText = new String[100];
        for (int i = 0; i < pText.length; i++) {
            int index = i + 1;
            pText[i] = driver.findElement(
                            By.xpath("//body/div[@id='wrap']/div[@id='main']/p[" + index + "]"))
                    .getText();
        }
        String actualResult = "";
        for (int i = 0; i < pText.length; i++) {
            actualResult = actualResult + pText[i];
        }
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


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
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        String expectedResult =
                "All languages starting with the letter J are shown, sorted by Language.";

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

    /**
     * TC_12_02 Подтвердите, что в меню BROWSE LANGUAGES, подменю M, последний программный язык в таблице -  MySQL
     * Шаги:
     * Открыть базовую страницу
     * Нажать на пункт меню BROWSE LANGUAGES
     * Нажать на подменю M
     * Подтвердить, что последний язык программирования на странице - MySQL
     */
    @Test
    public void testLastLanguageMySQL() {
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        String expectedResult = "MySQL";

        driver.get(url);

        driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                "/ul[@id='menu']/li/a[@href='/abc.html']")).click();
        driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='submenu']/li/a[@href='m.html']")).click();
        WebElement text = driver.findElement(
                By.xpath("//div[@id='main']/table//a[@href='language-mysql-1252.html']"));

        Assert.assertEquals(text.getText(), expectedResult);

        driver.quit();
    }

    /**
     * TC_12_03
     * Подтвердите, что в меню BROWSE LANGUAGES существует таблица с
     * заголовками Language, Author, Date, Comments, Rate
     * Шаги:
     * 1. Открыть базовую страницу
     * 2. Нажать на пункт меню BROWSE LANGUAGES
     * 3. Подтвердить, что существует таблица с заголовками Language, Author, Date, Comments, Rate
     */

    @Test
    public void testTitleOfTable() {
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        String expectedResult = "Language Author Date Comments Rate";

        driver.get(url);

        driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                "/ul[@id='menu']/li/a[@href='/abc.html']")).click();
        WebElement table = driver.findElement(By.xpath("//div[@id='main']/table//tr"));

        Assert.assertEquals(table.getText(), expectedResult);

        driver.quit();
    }


    /**
     * TC_12_04 Подтвердите, что создатель решения на языке Mathematica - Brenton Bostick,
     * дата обновления решения на этом языке - 03/16/06, и что это решение имеет 1 комментарий
     * Шаги
     * 1. Открыть базовую страницу
     * 2. Нажать на пункт меню BROWSE LANGUAGES
     * 3. Нажать на подменю M
     * 4. Подтвердить, что существует строка имеет следующий текст: Brenton Bostick 03/16/06 1
     */

    @Test
    public void testMathematica() {

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        String[] expectedResult = {"Brenton Bostick", "03/16/06", "1"};

        driver.get(url);

        driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/" +
                "ul[@id='menu']/li/a[@href='/abc.html']")).click();
        driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='submenu']/li/a[@href='m.html']")).click();
        WebElement author = driver.findElement(
                By.xpath("//table[@id='category']/tbody/tr/td[(contains(text(),'Brenton Bostick'))]"));
        WebElement data = driver.findElement(
                By.xpath("//table[@id='category']/tbody/tr/td[(contains(text(),'03/16/06'))]"));
        WebElement comments = driver.findElement(By.xpath("//tbody/tr/td[text()='1']"));


        String[] actualResult = {author.getText(), data.getText(), comments.getText()};

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

    /**
     * TC_12_05 Подтвердите, что на сайте существует 10 языков, названия которых начинаются с цифр.
     * 1. Открыть базовую страницу
     * 2. Нажать на пункт меню BROWSE LANGUAGES
     */

    @Test
    public void testTenLanguagesStartWithNumbers() {
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        int expectedResult = 10;

        driver.get(url);

        driver.findElement(By.xpath("//ul[@id='menu']/li/a[@href='/abc.html']")).click();
        driver.findElement(By.xpath("//ul[@id='submenu']/li/a")).click();

        List<WebElement> tableLanguage = driver.findElements(By.xpath("//tbody/tr[@onmouseover]"));
        int actualResult = tableLanguage.size();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    //второй вариант
    @Test
    public void testListOfLanguageBeginWithNumber() {
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        int expectedResult = 10;

        driver.get(url);
        driver.findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/abc.html']")).click();
        driver.findElement(
                By.xpath("//ul[@id='submenu']/li/a[@href='0.html']")).click();

        String[] numbers = new String[10];
        for (int i = 0; i < numbers.length; i++) {
            int index = i + 2;
            numbers[i] = driver.findElement(
                            By.xpath("//table[@id='category']/tbody/tr["+ index +"]")).
                    getText().substring(0,1);
        }

        Assert.assertEquals(numbers.length, expectedResult);

        driver.quit();
    }
}
