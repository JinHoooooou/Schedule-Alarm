package Constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface Constants {

  String EVERYTIME_ID = System.getenv("EVERY_TIME_ID");
  String EVERYTIME_PW = System.getenv("EVERY_TIME_PASSWORD");

  String NOT_MATCH = "오늘 경기 일정은 없습니다.";

  String EVERYTIME_SECRET_BOARD_URL = "https://everytime.kr/255668";
  String KBO_SCHEDULE_URL = "https://search.naver.com/search.naver?ie=UTF-8&query=kbo%EC%9D%BC%EC%A0%95&sm=chr_hty";
  String LOL_WORLDS_SCHEDULE_URL = "https://search.naver.com/search.naver?ie=UTF-8&query=%EB%A1%A4%EB%93%9C%EC%BB%B5+%EC%9D%BC%EC%A0%95&sm=chr_hty";

  String DATE_FORMAT = new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
  String[] WEEK_DAY = {"일", "월", "화", "수", "목", "금", "토"};
}



/* sample
 *  2020년 10월 04일 (일)
 *
 *  LOL Worlds Championship 일정
 *  일정
 *
 *  LCK 화이팅!
 *
 *  ----------------
 *
 *  KBO 일정
 *  일정
 *
 *  롯데 화이팅!
 *
 *  -----------------
 *  EPL 일정
 *  일정
 *
 *  맹구 화이팅!
 * */