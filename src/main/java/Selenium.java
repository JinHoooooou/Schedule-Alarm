import Constants.Constants;
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

  public void post(String contents) throws InterruptedException {

    click(By.xpath("/html/body/div[2]/div[2]/a"));
    inputContents(contents);
    click(By.className("anonym"));
    action.submit();
    Thread.sleep(1000);
  }

  private void click(By xpath) {
    action = webDriver.findElement(xpath);
    action.click();
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
    inputContents(Constants.EVERYTIME_ID);
    inputContents(Constants.EVERYTIME_PW);
    webDriver.findElement(By.className("submit")).submit();

    Thread.sleep(3000);
    if (webDriver.getPageSource().contains("광운대")) {
      System.out.println("로그인 성공");
    } else {
      System.out.println("로그인 실패");
    }
  }

  private void inputContents(String contents) throws InterruptedException {
    String cssName = CssName.getCssName(contents);
    action = webDriver.findElement(By.name(cssName));
    action.sendKeys(contents);

    Thread.sleep(1000);
  }
}
