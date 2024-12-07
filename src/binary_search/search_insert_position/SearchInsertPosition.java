package binary_search.search_insert_position;

import java.util.Arrays;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        if (result < 0) {
            return Math.abs(result) - 1;
        }
        return result;
    }

    public static int solution2(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (end > start) {
            int mid = (start + end) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

//        int output = searchInsert(nums, target);
        int output = solution2(nums, target);
        System.out.println(output);
    }
}
