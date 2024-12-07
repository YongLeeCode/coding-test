package hash.parallel;

import java.util.HashSet;

public class Parallel {
    // 정답 경우
    // y1 - y2 == y3- y4, x는 diff
    // x1 - x-2 == x3 - x4, y는 diff

    // 코드 작성 전 설계
    // 기울기 : (y2 - y1) / (x2 - x1)
    // forloop을 dots의 사이즈를 돌렸을 때 동일한 기울기가 있으면 return 1;

    // 놓친 부분: j = i + 1로 했던 부분은 또 하지 않게 하기


    public static int solution(int[][] dots) {
        HashSet<Double> set = new HashSet<>();
        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double slope = getSlope(dots[j][0], dots[i][0], dots[i][1], dots[j][1]);
                System.out.println(slope);
                if (set.contains(slope)) {
                    return 1;
                }
                set.add(slope);
            }
        }

        return 0;
    }

    private static double getSlope(int x1, int x2, int y1, int y2) {
        return (double) (x1 - x2) / (y1 - y2);
    }

    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        int result = solution(dots);
        System.out.println(result);
    }
}
