package recursiveFunction.climbing_stairs;

public class ClimbingStairs {
    private static int move_one = 1;
    private static int move_two = 2;

    private static int n = 5;

    public static void solution() {
        int currentMove = 0;
        int count = 0;
//        int result = climb(0, currentMove, count);
        int result = climb2(n);
        System.out.println(result);
    }
    public static int climb(int move, int currentPlace, int count) {

        currentPlace = currentPlace + move;
        if(currentPlace == n){
            count++;
            return count;
        }
        if(currentPlace > n){
            return count;
        }

        int method1 = climb(move_one, currentPlace, count);
        int method2 = climb(move_two, currentPlace, count);
        int result = method1 + method2;

        System.out.println(move + "칸 이동 현재 " + currentPlace + "위치에 있음 " + result +"가지 방법");
        return result;
    }

    public static int climb2(int n) {
        if (n <= 1) {
            return 1;
        }

        return climb2(n - 1) + climb2(n - 2);
    }
}
