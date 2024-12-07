package skill_level_test.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/77884
// 약수 개수와 덧셈

public class Problem8 {

    //첫번째 코드 실패
//    public static int solution(int left, int right) {
//        int leftSum = 0;
//        int rightSum = 0;
//
//        for(int i = 1; i <= left; i++) {
//            if(left % i == 0) {
//                leftSum += i;
//            }
//        }
//
//        for(int i = 1; i <= right; i++) {
//            if(right % i == 0) {
//                rightSum += i;
//            }
//        }
//
//        if(leftSum % 2 == 1) {
//            leftSum = -leftSum;
//        }
//        if (rightSum % 2 == 1) {
//            rightSum = -rightSum;
//        }
//        return leftSum + rightSum;
//    }

    public static int solution(int left, int right) {
        int sum = 0;
        int count = 0;
        for (int i = left; i <= right; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count % 2 == 1) {
                sum += -i;
            } else {
                sum += i;
            }
            count = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = solution(13, 17);
        System.out.println(result);
    }
}
