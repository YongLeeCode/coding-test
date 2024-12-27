package exam3;

// 가로 최대: 10^5
// 세로 최대: 10^4
// 최대 넓이: 10^9 = 10억

import java.util.LinkedList;
import java.util.Queue;

// 가운데에서부터 찾아가기
// 가운데에서 높은 숫자 남겨놓고 낮은 쪽 움직이기

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;

        while (left != right) {

            int length = right - left;
            //두 포인터의 높이
            int lh = height[left];
            int rh = height[right];

            int currWidth = Math.min(lh, rh) * length;


            if (max < currWidth) {
                max = currWidth;
            }

            if (lh > rh) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(h);
        System.out.println(result);
    }
}