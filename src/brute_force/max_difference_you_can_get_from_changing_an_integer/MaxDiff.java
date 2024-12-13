package brute_force.max_difference_you_can_get_from_changing_an_integer;

public class MaxDiff {
    public static int maxDiff(int num){
        String strNum = String.valueOf(num);
        String[] numbers = strNum.split("");
        int x = Integer.parseInt(numbers[0]);
        int a = 9 - x;
        int b = x - 1;
        String result = "";
        result += String.valueOf(a + b);
        for(int i = 1; i < numbers.length; i++) {
            if(x == Integer.parseInt(numbers[i])){
                result += String.valueOf((a + b));
            } else if (x == 1 && Integer.parseInt(numbers[i]) == 2){
                result += "2";
            } else if (x == 9) {
                result += String.valueOf(x - Integer.parseInt(numbers[i]));
            } else {
                result += "0";
            }
        }
        return Integer.parseInt(result);
    }
    public static void main(String[] args) {
        int result = maxDiff(9967);
        System.out.println(result);
    }
}
