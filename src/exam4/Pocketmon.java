package exam4;


import java.util.HashMap;

public class Pocketmon {
    public static int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return Math.min(nums.length / 2, map.size());
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2, 2};
        int result = solution(nums);
        System.out.println(result);
    }
}
