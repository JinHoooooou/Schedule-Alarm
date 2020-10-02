import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SeleniumTest {

  private static final String EVERYTIME_SECRET_BOARD_URL = "https://everytime.kr/255668";

  private Selenium selenium;

  @Before
  public void setUp() {
    selenium = new Selenium();
  }

  @Test
  @Ignore
  public void seleniumLoginTest() throws InterruptedException {
    selenium.login(EVERYTIME_SECRET_BOARD_URL);
  }

  @Test
  public void seleniumPostToSecretBoardTest() throws InterruptedException {
    selenium.login(EVERYTIME_SECRET_BOARD_URL);
    selenium.post("추석 잘보내");
  }

  @After
  public void tearDown() {
    selenium.disconnect();
  }

}