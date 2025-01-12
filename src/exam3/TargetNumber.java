package exam3;

// 문제 출처: 프로그래머스
// 문제 제목: 타겟 넘버

// 코딩 전 문제 풀이 방법
// 1. dfs 메소드를 만든다.
// 2. dfs 메소드에 + 혹은 -와 함께 number를 집어 넣는다.
// 3. 길이가 numbers가 되었을 때 target과 동일한 숫자라면 count 1이 증가한다.
public class TargetNumber {

    public static int solution(int[] numbers, int target) {
        int count = dfs(0, 0, numbers, target);
        return count;
    }

    private static int dfs(int index, int sum, int[] numbers, int target) {
        if (numbers.length == index) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }

        return dfs(index + 1, sum + numbers[index], numbers, target) + dfs(index + 1, sum - numbers[index], numbers, target);

    }

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        int result = solution(numbers, target);
        System.out.println(result);
    }
}
