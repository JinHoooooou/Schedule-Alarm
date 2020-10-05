package Crawling;

import Constants.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Getter
public class Lol extends Crawling {

  private String time;
  private String team1;
  private String team2;
  private String state;
  private static Map<String, String> league = new HashMap<>();

  static {
    league.put("담원 게이밍", "LCK");
    league.put("DRX", "LCK");
    league.put("젠지 이스포츠", "LCK");

    league.put("Top Esports", "LPL");
    league.put("JD Gaming", "LPL");
    league.put("Suning Gaming", "LPL");
    league.put("LGD Gaming", "LPL");

    league.put("G2 Esports", "LEC");
    league.put("Rogue", "LEC");
    league.put("Fnatic", "LEC");

    league.put("Team SoloMid", "LCS");
    league.put("FlyQuest", "LCS");
    league.put("Team Liquid", "LCS");

    league.put("Machi Esports", "PCS");
    league.put("PSG Talon", "PCS");

    league.put("Unicorns of Love", "LCL");

  }

  public Lol() {
  }

  public Lol(String time, String state, String team1, String team2) {
    this.time = time;
    this.state = state;
    this.team1 = team1;
    this.team2 = team2;
  }

  @Override
  public String crawlSchedule(String url) throws IOException {
    Document htmlDocument = Jsoup.connect(url).get();

    List<Lol> matchList = getTodayMatch(htmlDocument);
    return buildScheduleString(matchList);
  }

  @Override
  public List<Lol> getTodayMatch(Document htmlDocument) {
    List<Lol> matchList = new ArrayList<>();
    Elements matchTable = htmlDocument.select("li.schedule_box");
    for (Element element : matchTable) {
      String time = element.select("span.game_time").text();
      String state = element.select("span.game_state").text();
      String team1 = element.select("a.team_txt").get(0).text();
      String team2 = element.select("a.team_txt").get(1).text();
      matchList.add(new Lol(time, state, team1, team2));
    }
    return matchList;
  }

  @Override
  public String buildScheduleString(List matchList) {
    if (((List<Lol>) matchList).isEmpty()) {
      return Constants.NOT_MATCH;
    }
    String result = "";
    for (Lol match : (List<Lol>) matchList) {
      result += String.format("%s, %s,  %s(%s) vs %s(%s)\n",
          match.getTime(), match.getState(),
          match.getTeam1(), league.get(match.getTeam1()),
          match.getTeam2(), league.get(match.getTeam2()));
    }
    return result;
  }
}
