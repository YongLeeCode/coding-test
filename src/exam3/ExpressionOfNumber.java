package exam3;

public class ExpressionOfNumber {
    public static int solution(int n) {
        if(n == 0) {
            return 0;
        }
        // 숫자 자기 자신 (15 = 15) 상황을 위한 1 추가
        int answer = 1;
        // 홀수면 중간값 +1, 짝수면 0
        // 7 + 8 = 15, 8 + 9 != 16

        for(int i = 1; i <= n/2; i++) {
            int sum = 0;
            int curr = i;
            while(sum < n) {
                sum += curr;
                curr++;
            }
            if(sum == n) {
                answer++;
            }
        }

        return answer;

    }
    public static void main(String[] args) {
        int result = solution(3);
        System.out.println(result);
    }

}
