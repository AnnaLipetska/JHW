package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverHomeWork {
    public static void main(String[] args) throws InterruptedException {
        // 1.Написать программу которая открывает веб-браузер Chrome
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Шаги 2,3,4 выполнить в цикле два раза, первый раз используя в качестве локатора CSS второй раз xPath
        for (int i = 0; i < 2; i++) {
            // 2.Открывает главную страницу rozetka  (https://rozetka.com.ua/)
            driver.get("https://rozetka.com.ua/");
            Thread.sleep(5000);

            // 3. Находит контактный телефон на главной странице;
            String initialPhoneNumber;
            String additionalInfo;
            if (i == 0) {
                initialPhoneNumber = driver.findElement(By.cssSelector("[class = 'link-dashed']")).getText();
                additionalInfo = "Found by using css selector: ";
            } else {
                initialPhoneNumber = driver.findElement(By.xpath("//*[@class = 'link-dashed']")).getText();
                additionalInfo = "Found by using xPath: ";
            }
            // (044) 537-02-22

            // 4.Выводит в консоль телефон в формате «050XXXXXXX» или «080XXXXXXX» или «044XXXXXXX» не должно быть ни
            // кавычек, ни тире, ничего лишнего. Воспользоваться методом replace, поудалять фигурные скобки, пробелы и тире.
            String newPhoneNumber = initialPhoneNumber.replaceAll("[()\\s-]+", "");
            System.out.print(additionalInfo);
            System.out.println(newPhoneNumber);
        }

        // 5.По окончанию закрыть окно браузера
        driver.quit();
    }
}
