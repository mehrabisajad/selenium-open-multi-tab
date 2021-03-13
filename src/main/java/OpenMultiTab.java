import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;


public class OpenMultiTab {

    public static void main(String[] args) throws InterruptedException {

        List<TabData> tabs = new ArrayList<>() {{
            add(new TabData("https://google.com"));
            add(new TabData("https://mehrabisajad.ir"));
        }};


        // Chrome Driver
        System.setProperty("webdriver.chrome.driver", "web-drivers/chromedriver-v88_linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-default-browser-check");
//        options.addArguments("--user-data-dir=/google-chrome");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        options.addArguments("disable-infobars");
        WebDriver driver = new ChromeDriver();

        // Firefox Driver
//        System.setProperty("webdriver.gecko.driver", "web-drivers/geckodriver-v0.29.0-linux64/geckodriver");
//        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        for (int i = 0, tabsSize = tabs.size(); i < tabsSize; i++) {
            if (i != 0) {
                ((JavascriptExecutor) driver).executeScript("window.open()");
                ArrayList<String> currentTabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(currentTabs.get(i));
            }

            TabData tab = tabs.get(i);
            driver.navigate().to(tab.getUrl());
        }

    }

}  