import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SeleniumTest {

  private static final String NAVER_LOGIN_URL = "https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com";

  private Selenium selenium;

  @Before
  public void setUp() {
    selenium = new Selenium();
  }

  @Test
  public void seleniumLoginTest() throws InterruptedException {
    selenium.login(NAVER_LOGIN_URL);
  }

  @After
  public void tearDown() {
    selenium.disconnect();
  }

}