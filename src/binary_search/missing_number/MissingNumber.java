package binary_search.missing_number;

import java.util.Arrays;

public class MissingNumber {
    public static int solution(int[] nums) {
        int sum = nums.length * (nums.length +1 ) /2;
        int target = sum - Arrays.stream(nums).sum();
        return target;
    }
    public static void main(String[] args) {
        int[] arr = {5,6,2,3, 0, 1};
        int result = solution(arr);
        System.out.println(result);
    }
}
