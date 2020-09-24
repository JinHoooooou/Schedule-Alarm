import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Crawling {

  public String crawlKboSchedule(String url) throws IOException {
    Document htmlDocument = Jsoup.connect(url).get();

    List<Baseball> matchList = new ArrayList<>();
    Element matchTable = htmlDocument.selectFirst("tbody._scroll_content");
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

    String result = "";
    for (Baseball match : matchList) {
      result += String.format("%s, %s(%s) vs %s(%s), %s\n",
          match.getTime(), match.getAwayTeamName(), match.getAwayTeamPitcher(),
          match.getHomeTeamName(), match.getHomeTeamPitcher(), match.getPlace());
    }

    return result;
  }
}
