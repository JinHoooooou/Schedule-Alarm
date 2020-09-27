import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {

  private static WebDriver webDriver;

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

  public void login(String url) throws InterruptedException {
    webDriver.get(url);
    Thread.sleep(1000);
    System.out.println(webDriver.getTitle());
    inputNaverId(System.getenv("NAVER_ID"));
    inputNaverPassword(System.getenv("NAVER_PASSWORD"));
    webDriver.findElement(By.id("log.login")).submit();
    Thread.sleep(1000);
    System.out.println(webDriver.getTitle());
  }

  public void inputNaverPassword(String naverPassword) throws InterruptedException {
    copyToClipBoard(naverPassword);

    WebElement pw = webDriver.findElement(By.id("pw"));
    pw.click();
    pw.sendKeys(Keys.CONTROL + "v");

    Thread.sleep(1000);
  }

  public void inputNaverId(String naverId) throws InterruptedException {
    copyToClipBoard(naverId);

    WebElement id = webDriver.findElement(By.id("id"));
    id.click();
    id.sendKeys(Keys.CONTROL + "v");

    Thread.sleep(1000);
  }

  public void copyToClipBoard(String contents) {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(new StringSelection(contents), null);
  }
}
