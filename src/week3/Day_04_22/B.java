package week3.Day_04_22;

public class B extends Bs {
    String[] title = {"레옹", "쉰들러리스트", "타이타닉", "기생충", "클래식"};
    String[] director = {"뤽베송", "스필버그", "카메론", "봉준호", "곽재용"};
    String[] genre = {"액션", "드라마", "드라마", "스릴러", "멜로"};
    String[] count = {"100만", "300만", "900만", "1000만", "150만"}; // 관객수
    String[] actor = {"장르노", "리암 니슨", "디카프리오", "송강호", "조승우"};
    String[] actress = {"나탈리", "엠베스", "케이트", "조여정", "손예진"};
    String[] time = {"120분", "200분", "160분", "120분", "120분"};

    public B() {
        super();
    }

    public B (int i) {
        setTitle(title[i]);
        setDirector(director[i]);
        setGenre(genre[i]);
        setCount(count[i]);
        setActor(actor[i]);
        setActress(actress[i]);
        setTime(time[i]);
    }


    @Override
    public int getLength() {
        return title.length;
    }
}
