public class Baseball {

  private String time;
  private String awayTeamName;
  private String homeTeamName;
  private String awayTeamPitcher;
  private String homeTeamPitcher;
  private String place;

  public Baseball(String time, String awayTeamName, String awayTeamPitcher, String homeTeamName,
      String homeTeamPitcher, String place) {
    this.time = time;
    this.awayTeamName = awayTeamName;
    this.awayTeamPitcher = awayTeamPitcher;
    this.homeTeamName = homeTeamName;
    this.homeTeamPitcher = homeTeamPitcher;
    this.place = place;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getAwayTeamName() {
    return awayTeamName;
  }

  public void setAwayTeamName(String awayTeamName) {
    this.awayTeamName = awayTeamName;
  }

  public String getHomeTeamName() {
    return homeTeamName;
  }

  public void setHomeTeamName(String homeTeamName) {
    this.homeTeamName = homeTeamName;
  }

  public String getAwayTeamPitcher() {
    return awayTeamPitcher;
  }

  public void setAwayTeamPitcher(String awayTeamPitcher) {
    this.awayTeamPitcher = awayTeamPitcher;
  }

  public String getHomeTeamPitcher() {
    return homeTeamPitcher;
  }

  public void setHomeTeamPitcher(String homeTeamPitcher) {
    this.homeTeamPitcher = homeTeamPitcher;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }
}
