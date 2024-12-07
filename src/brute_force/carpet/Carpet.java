package brute_force.carpet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carpet {

    public static void solution(int brown, int yellow) {
        int carpet = brown + yellow;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < carpet; i++) {
            if (carpet % i == 0) {
                list.add(i);
            }
        }

        int index = list.size() / 2;
        if (list.size() % 2 == 0) {
            int[] result = {list.get(index), carpet/list.get(index)};
            System.out.println(Arrays.toString(result));
        } else {
            int[] result = {list.get(index + 1), carpet/list.get(index+1)};
            System.out.println(Arrays.toString(result));
        }
    }
}
