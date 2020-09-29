import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {

  private static WebDriver webDriver;
  private static WebElement action;

  public Selenium() {
    connectChromeDriver();
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

  public void disconnect() {
    webDriver.close();
  }

  public void login(String url) throws InterruptedException {
    webDriver.get(url);
    Thread.sleep(1000);

    System.out.println(webDriver.getTitle());
    inputId(System.getenv("EVERY_TIME_ID"));
    inputPassword(System.getenv("EVERY_TIME_PASSWORD"));
    webDriver.findElement(By.className("submit")).submit();

    Thread.sleep(3000);
    if (webDriver.getPageSource().contains("광운대")) {
      System.out.println("로그인 성공");
    } else {
      System.out.println("로그인 실패");
    }
  }

  public void inputPassword(String password) throws InterruptedException {
    action = webDriver.findElement(By.name("password"));
    action.sendKeys(password);

    Thread.sleep(1000);
  }

  public void inputId(String id) throws InterruptedException {
    action = webDriver.findElement(By.name("userid"));
    action.sendKeys(id);

    Thread.sleep(1000);
  }
}
