package stack_queue.flood_fill;

import java.util.Arrays;
import java.util.Stack;

public class FloodFill {

    public static int[][] solution(int[][] image, int sr, int sc, int color) {
        Stack<int[]> stack = new Stack<>();
        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }
        stack.push(new int[]{sr, sc});

        while (!stack.empty()) {
            int[] curr = stack.pop();
            int row = curr[0];
            int col = curr[1];
            image[row][col] = color;

            int[][] directions = {{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1},};

            for (int[] d : directions) {
                if (d[0] < 0 || d[1] < 0 || d[0] >= image.length || d[1] >= image[0].length) {
                    continue;
                }
                if (image[d[0]][d[1]] == originalColor) {
                    int[] pointer = {d[0], d[1]};
                    stack.push(pointer);
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] result = solution(image, sr, sc, color);
        System.out.println(Arrays.toString(result[0]));
        System.out.println(Arrays.toString(result[1]));
        System.out.println(Arrays.toString(result[2]));
    }
}
