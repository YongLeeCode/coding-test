package how_to_sort.kth_number;

import java.util.Arrays;

public class KthNumber {

    public static int[] solution(int[] array, int[][] commands) {

        int[] selectedNumbers = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int[] slicedArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            int[] sortedSlicedArray = Arrays.stream(slicedArray).sorted().toArray();
            selectedNumbers[i] = sortedSlicedArray[command[2] - 1];

        }
        return selectedNumbers;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = solution(array, commands);
        System.out.println(Arrays.toString(result));
    }
}
