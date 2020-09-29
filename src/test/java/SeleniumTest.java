import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SeleniumTest {

  private static final String EVERYTIME_LOGIN_URL = "https://everytime.kr/login";

  private Selenium selenium;

  @Before
  public void setUp() {
    selenium = new Selenium();
  }

  @Test
  public void seleniumLoginTest() throws InterruptedException {
    selenium.login(EVERYTIME_LOGIN_URL);
  }

  @After
  public void tearDown() {
    selenium.disconnect();
  }

}