package stack_queue.island_parimeter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class IslandParimeter {

    public static int solution(int[][] grid) {
        Stack<int[]> stack = new Stack<>();
        HashSet<String> visited = new HashSet<>();
        int perimeter = 0;
        int[] island = findIsland(grid);
        stack.push(island);

        while (!stack.empty()) {
            int[] curr = stack.pop();
            if (grid[curr[0]][curr[1]] == 0) {
                perimeter++;
                continue;
            }

            if (visited.contains(Arrays.toString(curr))) {
                continue;
            }
            visited.add(Arrays.toString(curr));

            // 네 방향 중 1인지 확인 & visisted에 포함이 되지 않아야함
            int[][] directions = {
                    {curr[0] - 1, curr[1]},
                    {curr[0] + 1, curr[1]},
                    {curr[0], curr[1] - 1},
                    {curr[0], curr[1] + 1}
            };

            for (int[] direction : directions) {
                int newRow = direction[0];
                int newCol = direction[1];

                // 필드 바깥
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                    perimeter++;
                    continue;
                }
                //물
                if (grid[newRow][newCol] == 0) {
                    perimeter++;
                } else {
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }
        return perimeter;
    }

    private static int[] findIsland(int[][] grid) {
        //세로
        for (int i = 0; i < grid.length; i++) {
            //가로
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int result = solution(grid);
        System.out.println(result);
    }

}
