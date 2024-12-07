package skill_level_test.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12919
// 서울에서 김서방 찾기

public class Problem7 {
    public static String solution(String[] seoul) {
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {

                return "김서방은 " + (i) +"에 있다";
            }
        }
        return "김서방은 서울에 없다";
    }
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        String result = solution(seoul);
        System.out.println(result);
    }
}
