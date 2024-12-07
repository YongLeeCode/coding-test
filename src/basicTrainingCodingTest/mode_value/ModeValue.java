package basicTrainingCodingTest.mode_value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ModeValue {

    public static int mySolution(int[] array) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int arrNum : array) {
            if (numbers.containsKey(arrNum)) {
                int add = numbers.get(arrNum) + 1;
                numbers.put(arrNum, add);
            } else {
                numbers.put(arrNum, 1);
            }
        }
        int resultNumber = 0;
        int resultCount = 0;
        for (Entry<Integer, Integer> entry : numbers.entrySet()) {
            if (entry.getValue() > resultCount) {
                resultCount = entry.getValue();
                resultNumber = entry.getKey();
            } else if (entry.getValue() == resultCount) {
                resultNumber = -1;
            }
        }
        System.out.println(resultNumber + " " + resultCount);
        return resultNumber;
    }

    public static int anotherSolution1(int[] array) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Entry<Integer,Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

        if(entries.size()>1){
            if(entries.get(0).getValue() == entries.get(1).getValue()) return -1;
        }
        return entries.get(0).getKey();
    }

    public static int anotherSolution2(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : array) {
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int mode = 0;
        int modeNum = 0;
        for(int x : map.keySet()){
            if(map.get(x) > modeNum){
                mode = x;
                modeNum = map.get(x);
            }
        }

        int modeCount = 0;
        for(int x : map.values()){
            if(x == modeNum) modeCount++;
            if(modeCount > 1) return -1;
        }
        return mode;
    }
}
