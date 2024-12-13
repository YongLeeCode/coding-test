package exam2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// 3중 forloop을 사용하는 brute force
// DFS를 사용하기
public class ThreeSum {
//    public static List<List<Integer>> solution(int[] nums) {
//    public static void solution(int[]nums){
//        List<List<Integer>> result = new ArrayList<>();
//
//        result = dfs(result, 0, 1, 2, nums);
//        System.out.println(result);
//    }
//
//    private static List<List<Integer>> dfs(List<List<Integer>> result, int p1, int p2, int p3, int[] nums){
//        if(p3 >= nums.length || p2 >= nums.length || p1 >= nums.length){
//            return result;
//        }
//
//        if (p1 < p2 && p2 < p3) {
//            int sum = nums[p1] + nums[p2] + nums[p3];
//            if (sum == 0) {
//                ArrayList<Integer> triplet = new ArrayList<>();
//                triplet.add(nums[p1]);
//                triplet.add(nums[p2]);
//                triplet.add(nums[p3]);
//                triplet.sort(Integer::compareTo);
//                if(!result.contains(triplet)){
//                    result.add(triplet);
//                }
//            }
//        }
//
//        dfs(result, p1, p2, p3 + 1, nums);
//        dfs(result, p1, p2 + 1, p3 + 1, nums);
//        dfs(result, p1 + 1, p2 + 1, p3 + 1, nums);
//
//        return result;
//    }

    public static List<List<Integer>> solution(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(i, nums[i]);
        }

        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                int needs = -(nums[i] + nums[j]);
                if(map.containsValue(needs)){
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(needs);
                    arr.sort(Integer::compareTo);
                    if(!result.contains(arr)){
                        result.add(arr);
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
//        solution(nums);
        List<List<Integer>> result = solution(nums);
    }
}
