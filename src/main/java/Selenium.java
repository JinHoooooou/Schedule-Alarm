import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {

  private static WebDriver webDriver;

  public String getWebPageTitle(String url) {
    connectChromeDriver();
    webDriver.get(url);
    return webDriver.getTitle();
  }

  public static void main(String[] args) {
    connectChromeDriver();
  }

  private static void connectChromeDriver() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    webDriver = new ChromeDriver(options);
  }
}
