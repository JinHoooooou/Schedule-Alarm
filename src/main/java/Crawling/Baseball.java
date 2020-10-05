package Crawling;

import Constants.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Getter
public class Baseball extends Crawling {

  private String time;
  private String awayTeamName;
  private String homeTeamName;
  private String awayTeamPitcher;
  private String homeTeamPitcher;
  private String place;

  public Baseball() {
  }

  public Baseball(String time, String awayTeamName, String awayTeamPitcher, String homeTeamName,
      String homeTeamPitcher, String place) {
    this.time = time;
    this.awayTeamName = awayTeamName;
    this.awayTeamPitcher = awayTeamPitcher;
    this.homeTeamName = homeTeamName;
    this.homeTeamPitcher = homeTeamPitcher;
    this.place = place;
  }

  @Override
  public String crawlSchedule(String url) throws IOException {
    Document htmlDocument = Jsoup.connect(url).get();

    List<Baseball> matchList = getTodayMatch(htmlDocument);
    return buildScheduleString(matchList);
  }

  @Override
  public List<Baseball> getTodayMatch(Document htmlDocument) {
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
          .add(new Baseball(time, awayTeamName, awayTeamPitcher,
              homeTeamName, homeTeamPitcher, place));
    }
    return matchList;
  }

  @Override
  public String buildScheduleString(List matchList) {
    if (((List<Baseball>) matchList).isEmpty()) {
      return Constants.NOT_MATCH;
    }
    String result = "";
    for (Baseball match : (List<Baseball>) matchList) {
      result += String.format("%s, %s(%s) vs %s(%s), %s\n",
          match.getTime(), match.getAwayTeamName(), match.getAwayTeamPitcher(),
          match.getHomeTeamName(), match.getHomeTeamPitcher(), match.getPlace());
    }
    return result;
  }
}
