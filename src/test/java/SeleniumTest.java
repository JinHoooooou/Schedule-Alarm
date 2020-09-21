import static junit.framework.TestCase.fail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

  private WebDriver webDriver;

  @Before
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    webDriver = new ChromeDriver(options);
  }

  @Test
  public void seleniumTest() {
    webDriver.get("https://www.naver.com");
    String titleTest = webDriver.getTitle();
    System.out.println(titleTest);
  }

  @After
  public void tearDown() {
    if (webDriver != null) {
      webDriver.quit();
    }
  }
}
