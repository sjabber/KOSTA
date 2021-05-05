package week3.Day_04_20;

import java.util.ArrayList;

public class Movie implements Comparable<Movie>, key, I {
    MovieS s; // 테이블 스키마가 담긴 객체 생성

    String[] title = {"레옹", "쉰들러리스트", "타이타닉", "기생충", "클래식"};
    String[] director = {"뤽베송", "스필버그", "카메론", "봉준호", "곽재용"};
    String[] genre = {"액션", "드라마", "드라마", "스릴러", "멜로"};
    String[] count = {"100만", "300만", "900만", "1000만", "150만"}; // 관객수
    String[] actor = {"장르노", "리암 니슨", "디카프리오", "송강호", "조승우"};
    String[] actress = {"나탈리", "엠베스", "케이트", "조여정", "손예진"};
    String[] time = {"120분", "200분", "160분", "120분", "120분"};

    public Movie() {

        s = new MovieS();
        s.setTitle(title[0]);
        s.setDirector(director[0]);
        s.setGenre(genre[0]);
        s.setCount(count[0]);
        s.setActor(actor[0]);
        s.setActress(actress[0]);
        s.setTime(time[0]);

    }

    public Movie(int n) {

        s = new MovieS();
        s.setTitle(title[n]);
        s.setDirector(director[n]);
        s.setGenre(genre[n]);
        s.setCount(count[n]);
        s.setActor(actor[n]);
        s.setActress(actress[n]);
        s.setTime(time[n]);

    }

    @Override
    public int compareTo(Movie o) {
        // 자연어 정렬
        return this.s.getTitle().compareTo(o.s.getTitle());
    }

    @Override
    public String[] print_key() {
        String[] str = title;
        return str;
    }

    @Override
    public ArrayList<String> GetList() {
        return null;
    }

    @Override
    public ArrayList<String> GetTuple(int n) {
        return null;
    }
}
