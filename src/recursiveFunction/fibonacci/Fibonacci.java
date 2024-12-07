package recursiveFunction.fibonacci;

public class Fibonacci {
    public static int max_size = 2000;
    public static int index = 2;
    public static int result;
    public static void solution(int num1, int num2) {
        getFibonacciNumber(num1, num2, max_size);

    }

    private static void getFibonacciNumber(int offsetNum1, int offsetNum2, int maxSize) {
        int num1 = offsetNum2;
        int num2 = offsetNum1 + offsetNum2;
        index++;
//        System.out.println(index + " "+ num2);
        if(num2 >= maxSize){
            return ;
        }

        getFibonacciNumber(num1, num2, maxSize);
    }

    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        solution(num1, num2);
    }

}
