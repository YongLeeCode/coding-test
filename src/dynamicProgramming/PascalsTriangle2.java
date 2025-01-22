package dynamicProgramming;

// 출처: leetcode
// 문제 제목: Pascal's Triangle

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(0, new ArrayList<>(List.of(0)));
        for(int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    list.add(1);
                } else if (j == i) {
                    list.add(1);
                } else {
                    list.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
                }
            }
            rows.add(i, list);
        }
        return rows.get(rowIndex);
    }

    public static void main(String[] args) {
        List<Integer> result = getRow(3);
        System.out.println(result);
    }
}
