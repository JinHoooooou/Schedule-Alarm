import Constants.Constants;
import Crawling.Baseball;
import Crawling.Lol;
import java.io.IOException;
import java.util.Calendar;

public class AutoPostingApplication {

  public static void main(String[] args) throws InterruptedException, IOException {
    Selenium selenium = new Selenium();
    selenium.login(Constants.EVERYTIME_SECRET_BOARD_URL);
    selenium.post(buildContents());
    selenium.disconnect();
  }

  private static String buildContents() throws IOException {
    String contents =
        Constants.DATE_FORMAT + " " + Constants.WEEK_DAY[Calendar.DAY_OF_WEEK - 1] + "\n\n";
    contents += "Lol Worlds ChampionShip 일정\n";
    contents += new Lol().crawlSchedule(Constants.LOL_WORLDS_SCHEDULE_URL) + "\n";
    contents += "LCK 화이팅!!\n";
    contents += "---------------\n\n";
    contents += "Kbo 일정\n";
    contents += new Baseball().crawlSchedule(Constants.KBO_SCHEDULE_URL) + "\n";
    contents += "---------------\n\n";
    contents += "일정 및 결과 크롤링 테스트입니다. 추가하고 싶은 일정이 있으시면 댓글로 남겨주세요";

    return contents;
  }
}
