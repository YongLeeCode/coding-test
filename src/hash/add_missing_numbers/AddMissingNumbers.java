package hash.add_missing_numbers;

import java.util.HashSet;

public class AddMissingNumbers {
    // 정답을 맞추고 생각한 것.
    // 중복되는 숫자가 있을 땐 이 방법에는 문제가 생긴다.
    // 그러므로 hashSet을 사용하여 중복체크를 해줘야할 듯 하다.
    public static int solution(int[] numbers) {
        int sum = 0;
        int max = 9;
        HashSet<Integer> set = new HashSet<>();
        for(int number : numbers) {
            if(set.contains(number)) continue;
            set.add(number);
            sum += number;
        }

        return ((max + 1) * max / 2) - sum;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0,4,1};
        int result = solution(numbers);
        System.out.println(result);
    }
}
