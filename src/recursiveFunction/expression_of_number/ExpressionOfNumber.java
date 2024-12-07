package recursiveFunction.expression_of_number;

public class ExpressionOfNumber {
    public static int answer = 0;
    public static void solution() {
        int n = 15;
        count(n, n);
        System.out.println(answer);
    }

    public static void count(int num, int matchNumber) {

        if(num == matchNumber) {
            answer++;
        }
        // answer = n + (n-1) ...

        if(num != 0) {
            count(num-1, matchNumber);
        }

        // 경우1 : 합친 숫자가 15보다 작을 때
        // 경우2 : 합친 숫자가 15보다 클 때
    }
}
