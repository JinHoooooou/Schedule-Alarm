public abstract class CssName {

  public abstract String getName();

  public static String getCssName(String contents) {
    if (contents.equals(Selenium.EVERY_TIME_ID)) {
      return new Id().getName();
    } else if (contents.equals(Selenium.EVERY_TIME_PASSWORD)) {
      return new Password().getName();
    }
    return new Text().getName();
  }
}

class Id extends CssName {

  @Override
  public String getName() {
    return "userid";
  }
}

class Password extends CssName {

  @Override
  public String getName() {
    return "password";
  }
}

class Text extends CssName {

  @Override
  public String getName() {
    return "text";
  }
}