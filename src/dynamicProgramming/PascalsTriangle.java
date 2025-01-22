package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

// 출처: leetcode
// 문제 제목: Pascal's Triangle
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(0, new ArrayList<>(List.of(1)));

        for(int i = 1; i < numRows; i++) {
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    l.add(1);
                } else if (j == i) {
                    l.add(1);
                } else {
                    l.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(i, l);
        }
        return list;
    }
    public static void main(String[] args) {
        int num = 5;
        List<List<Integer>> result = generate(num);
        System.out.println(result);
    }
}
