package skill_level_test.level1;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Stack;

public class Problem14 {
    public static void solution(int[] numbers, int target) {
        int index = 0;
        int count = 0;
        Stack stack = new Stack<>();
    }
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int[] numbers2 = {4, 1, 2, 1};
        int target = 3;
        solution(numbers, target);
        System.out.println();

        int[] b = Arrays.stream(numbers).sorted().toArray();
        int[] a = Arrays.stream(numbers).sorted().toArray();
        long c = Arrays.stream(numbers).count();
        double d = Arrays.stream(numbers).average().getAsDouble();
//        Arrays.stream(numbers).
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(a));
        System.out.println(d);
    }
}

//n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.