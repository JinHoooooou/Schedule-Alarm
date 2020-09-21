import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Crawling {

  private static WebDriver webDriver;
  private static String NAVER_URL = "https://www.naver.com";

  public static void main(String[] args) {
    connectChromeDriver();
    webDriver.get(NAVER_URL);
    System.out.println(webDriver.getTitle());
  }

  private static void connectChromeDriver() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    webDriver = new ChromeDriver(options);
  }
}
