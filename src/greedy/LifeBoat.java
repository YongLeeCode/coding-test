package greedy;

// 출처: 프로그래머스
// 문제: 구명보트


// 최대 2명, 무게 제한

// 정렬
// 무게 높은 사람부터 구조
// 한 명을 태우고 그 다음 무게 높은 사람부터 태울 수 있는지 체크
// 가능한 사람을 찾으면 추가

import java.util.Arrays;


// 리스트에서 제외 시키기
// 40 40 50 50 60 60
public class LifeBoat {

    public static int solution(int[] people, int limit) {
        int count = 0;
        int right = people.length - 1;
        int left = 0;

        Arrays.sort(people);

        while(left <= right) {
            if(people[right] + people[left] <= limit) {
                left++;
            }
            right--;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int result = solution(people, limit);
        System.out.println(result);
    }
}
