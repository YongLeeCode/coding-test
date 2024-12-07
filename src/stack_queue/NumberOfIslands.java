package stack_queue;

import java.util.HashSet;
import java.util.Stack;

public class NumberOfIslands {
    public static int solution(char[][] grid) {
        Stack<int[]> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1') {
                    count++;
                    stack.push(new int[]{i, j});
                    grid[i][j] = 0;

                    int[][] directions = {
                            {i+1, j},
                            {i-1, j},
                            {i, j+1},
                            {i, j-1},
                    };

                    for(int[] d : directions) {
                        int row = d[0];
                        int col = d[1];

                        if (grid[row][col] == 0 ) {
                            continue;
                        }

                        if(grid[row][col] == '1') {
                            grid[row][col] = '0';
                            count--;
                        }
                    }
                }
            }
        }

        while(!stack.empty()){
            int[] land = stack.pop();
            if(grid[land[0]][land[1]] == 0){
                continue;
            }
            int[][] directions = {
                    {land[0] + 1, land[1]},
                    {land[0] - 1, land[1]},
                    {land[0], land[1] + 1},
                    {land[0], land[1] - 1},
            };

            for(int[] d : directions) {
                int row = d[0];
                int col = d[1];

                if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                    continue;
                }

                if(grid[row][col] == '1') {
                    grid[land[0]][land[1]] = '0';
                    count--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','1'}
        };
        int result = solution(grid);
        System.out.println(result);
    }
}
