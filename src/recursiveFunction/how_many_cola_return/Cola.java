package recursiveFunction.how_many_cola_return;

public class Cola {
    static int newColaCount = 0;

    public static int solution(int a, int b, int n) {
        int newCola = n / a * b;
        int emptyBottle = n % a + n / a * b;

        newColaCount += newCola;

        if(n / a > 0){
            solution(a, b, emptyBottle);
        }
        return newColaCount;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        int n = 20;
        int output = solution(a, b, n);
        System.out.println(output);
    }
}
