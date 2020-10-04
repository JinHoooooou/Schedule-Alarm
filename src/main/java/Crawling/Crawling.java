package Crawling;

import java.io.IOException;
import java.util.List;
import org.jsoup.nodes.Document;

public abstract class Crawling<T> {

  public abstract String crawlSchedule(String url) throws IOException;

  public abstract List<T> getTodayMatch(Document htmlDocument);

  public abstract String buildScheduleString(List<T> matchList);
}
