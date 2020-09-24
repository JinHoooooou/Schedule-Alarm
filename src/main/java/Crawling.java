import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Crawling {

  public String crawlKboSchedule(String url) throws IOException {
    Document htmlDocument = Jsoup.connect(url).get();

    List<Baseball> matchList = getTodayMatch(htmlDocument);
    return buildScheduleString(matchList);
  }

  private String buildScheduleString(List<Baseball> matchList) {
    if (matchList.isEmpty()) {
      return "오늘 경기 일정은 없습니다.";
    }
    String result = "";
    for (Baseball match : matchList) {
      result += String.format("%s, %s(%s) vs %s(%s), %s\n",
          match.getTime(), match.getAwayTeamName(), match.getAwayTeamPitcher(),
          match.getHomeTeamName(), match.getHomeTeamPitcher(), match.getPlace());
    }
    return result;
  }

  private List<Baseball> getTodayMatch(Document htmlDocument) {
    List<Baseball> matchList = new ArrayList<>();
    Element matchTable = htmlDocument.selectFirst("tbody._scroll_content");
    if (matchTable == null) {
      return new ArrayList<>();
    }
    for (Element element : matchTable.getElementsByTag("tr")) {
      String time = element.select("span.bg_none").text();
      String place = element.select("td.place").text();
      Element awayTeam = element.selectFirst("td.l_team");
      Element homeTeam = element.selectFirst("td.r_team");
      String awayTeamName = awayTeam.selectFirst("span > a").text();
      String awayTeamPitcher = awayTeam.selectFirst("span > p").text().split(" ")[1];
      String homeTeamName = homeTeam.selectFirst("span > a").text();
      String homeTeamPitcher = homeTeam.selectFirst("span > p").text().split(" ")[1];

      matchList
          .add(new Baseball(time, awayTeamName, awayTeamPitcher, homeTeamName, homeTeamPitcher,
              place));
    }
    return matchList;
  }
}
