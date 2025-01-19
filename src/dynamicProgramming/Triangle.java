package dynamicProgramming;

// 출처: 프로그래머스
// 문제 제목: 정수 삼각형
public class Triangle {

    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];

        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];

        int max = 0;
        for (int i = 2; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        int result = solution(triangle);
        System.out.println(result);
    }
}
