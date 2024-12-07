import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

//        int[] array = {1,2,3,3,3,4};
//        int[] array = {1,1,2,2};
//        int result = basicTrainingCodingTest.mode_value.ModeValue.anotherSolution1(array);
//        System.out.println(result);

//        int n = 10;
//        int[] answer = new int[(int) Math.ceil((double) n /2)];
//        int currentNum = 1;
//        int increment = 0;
//        while(currentNum <= n){
//            answer[increment] = currentNum;
//            increment++;
//            currentNum += 2;
//        }
//        System.out.println(Arrays.toString(answer));

//        how_to_use_string.strange_string_creator.StrangeStringCreator.solution();

//        recursiveFunction.tree_traversal.TreeTraversal.solution(7, "ABCBD.CEFE..");


//        int num1 = 0;
//        int num2 = 1;
//        recursiveFunction.fibonacci.Fibonacci.solution(num1, num2);

//        recursiveFunction.climbing_stairs.ClimbingStairs.solution();

//        Integer[] array = {1,2,3,4,5};
//        reverse(array);
//        System.out.println(Arrays.toString(array));

//        brute_force.mock_exam.MockExam.solution();

//        int brown = 1;
//        int yellow = 2;
//        brute_force.carpet.Carpet.solution(brown, yellow);

//        String expression = "100-200*300-500+20";
//        brute_force.greatest_value.Greatest_Value.solution(expression);

//        int sum = sum(10);
//        System.out.println(sum);
//        int a = 1;
//        int b = 2;
//        int c = 3;
//        int n = 4;
//        hanoi(n, a, b, c);

//        int[] num_list = {1,2,3,4,5};
//
//        System.out.println(Arrays.toString(num_list));

        int[] num_list = {1,2,3,4,5};
        int[] answer = new int[num_list.length];
        for(int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[num_list.length-i-1];
        }
        System.out.println(Arrays.toString(answer));
    }
//    public static int sum(int i) {
//        if(i <= 1) {
//            return i;
//        }
//        System.out.println(i);
//        return sum(i-1) * i;
//    }
//    public static void hanoi(int n, int a, int b, int c){
//        if(n > 0) {
//            hanoi(n-1, a, c ,b);
//            System.out.printf("%d 에서 %d 로 가장 맨 위의 원판 이동 %d c 원판\n", a,b,c);
//            hanoi(n-1, b, a ,c);
//        }
//    }
//    public static void reverse(Integer[] array) {
//        Collections.reverse(Arrays.asList(array));
//        System.out.println();
//    }


}