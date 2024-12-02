package goodCodingTestProblem.lucky_straight;

// 문제
// 어떤 게임의 아웃복서 캐릭터에게는 럭키 스트레이트라는 기술이 존재한다.
// 이 기술은 매우 강력한 대신에 항상 사용할 수는 없으며, 현재 게임 내에서 점수가 특정 조건을 만족할 때만 사용할 수 있다.
//특정 조건이란 현재 캐릭터의 점수를 N이라고 할 때
// 점수 N을 자릿수를 기준으로 반으로 나누어 왼쪽 부분의 각 자릿수의 합과 오른쪽 부분의 각 자릿수의 합을 더한 값이 동일한 상황을 의미한다.
// 예를 들어 현재 점수가 123,402라면 왼쪽 부분의 각 자릿수의 합은 1+2+3, 오른쪽 부분의 각 자릿수의 합은 4+0+2이므로 두 합이 6으로 동일하여 럭키 스트레이트를 사용할 수 있다.

//현재 점수 N이 주어졌을 때, 럭키 스트레이트를 사용할 수 있는 상태인지 아닌지를 알려주는 프로그램을 작성하시오.
// 럭키 스트레이트를 사용할 수 있다면 "LUCKY"를, 사용할 수 없다면 "READY"라는 단어를 출력한다.
// 또한 점수 N의 자릿수는 항상 짝수 형태로만 주어진다. 예를 들어 자릿수가 5인 12,345와 같은 수는 입력으로 들어오지 않는다.

// 예시
// 1+2+3 == 4+0+2 => lucky
// 7+7 != 5+5 => ready

import java.util.ArrayList;
import java.util.List;

public class LuckyStraight {
    public static String solution(int input) {
        int num1 = 0;
        int num2 = 0;

        // String으로 만든다.
        String strInput = String.valueOf(input);
        // split("") 한 후, 리스트에 저장
        ArrayList<String> numbers = new ArrayList<>(List.of(strInput.split("")));

        // split한 길이를 구해서 각각의 반을 더 한 값을 구한다.
        for(int i=0; i<numbers.size()/2; i+=1){
            num1 += Integer.parseInt(numbers.get(i));
        }
        // 나머지 반대쪽 반을 더 한 값을 구한다.
        for(int i=numbers.size()/2; i<numbers.size(); i+=1){
            num2 += Integer.parseInt(numbers.get(i));
        }

        // 조건문으로 출력
        if(num1 == num2) {
            return "LUCKY";
        } else {
            return "READY";
        }
    }

    public static void main(String[] args) {
        int input = 55;
        String output = solution(input);
        System.out.println(output);
    }
}
