import static org.junit.Assert.*;

import org.junit.Test;

public class CrawlingTest {

  @Test
  public void testWhenUrlIsMelon() {
    // Given: Set melon url
    String url = "https://www.melon.com/index.htm";

    // When: Call getWebPageTitle method
    String actual = new Crawling().getWebPageTitle(url);

    // Then: Should return "Melon::음악이 필요한 순간, 멜론"
    String expected = "Melon::음악이 필요한 순간, 멜론";
    assertEquals(expected, actual);
  }
}