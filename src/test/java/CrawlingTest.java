import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Ignore;
import org.junit.Test;

public class CrawlingTest {

  private static final String NAVER_KBO_SCHEDULE = "https://search.naver.com/search.naver?ie=UTF-8&query=kbo%EC%9D%BC%EC%A0%95&sm=chr_hty";
  private static final String URL_OF_NOT_HAVE_MATCH = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=9%EC%9B%94+28%EC%9D%BC+kbo%EC%9D%BC%EC%A0%95&oquery=2020%EB%85%84+9%EC%9B%94+29%EC%9D%BC+%EC%95%BC%EA%B5%AC+%EA%B2%BD%EA%B8%B0%EC%9D%BC%EC%A0%95&tqi=U2xK1sprvTVsseMA62NssssssKG-318856";

  @Test
  public void testShouldReturnKboScheduleString() throws IOException {
    // When: Call crawlKboSchedule
    String actual = new Crawling().crawlKboSchedule(NAVER_KBO_SCHEDULE);

    // Then: Should return html string
    String expected =
        "18:30, LG(이민호) vs NC(최성영), 창원\n"
            + "18:30, KIA(가뇽) vs KT(소형준), 수원\n"
            + "18:30, SK(이건욱) vs 키움(요키시), 고척\n"
            + "18:30, 롯데(박세웅) vs 한화(서폴드), 대전\n"
            + "18:30, 삼성(라이블리) vs 두산(최원준), 잠실\n";
    assertEquals(expected, actual);
  }

  @Test
  public void testWhenTodayNotHaveMatch() throws IOException {
    String actual = new Crawling().crawlKboSchedule(URL_OF_NOT_HAVE_MATCH);

    assertEquals("오늘 경기 일정은 없습니다.", actual);
  }
}