package leetcode.map_sum_pairs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
class MapSum {
        //    HashMap<Character, Integer> map;
        //    HashMap<String, Integer> word;
        //    public MapSum() {
        //        map = new HashMap();
        //        word = new HashMap();
        //    }

//    public void insert(String key, int val) {
//        char[] c = key.toCharArray();
//        int num = val - word.getOrDefault(key, 0);
//        word.put(key, val);
//        HashSet<Character> set = new HashSet<>();
//        for(int i = 0; i < c.length; i++){
//            set.add(c[i]);
//        }
//        for(char ct : set) {
//
//            map.put(ct, map.getOrDefault(ct, 0) + num);
//        }
//    }
//
//    public int sum(String prefix) {
//
//        char[] c = prefix.toCharArray();
//        int result = 1000;
//
//        for(int i = 0; i < c.length; i++){
//            Integer value = map.get(c[i]);
//            if(value == null){
//                value = 0;
//            }
//
//            result = Math.min(result, value);
//        }
//        return result;
//    }
    Map<String, Integer> map;
    Map<String, Integer> score;
    public MapSum() {
        map = new HashMap();
        score = new HashMap();
    }
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        String prefix = "";
        for (char c: key.toCharArray()) {
            prefix += c;
            score.put(prefix, score.getOrDefault(prefix, 0) + delta);
        }
    }
    public int sum(String prefix) {
        return score.getOrDefault(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */