package skill_level_test.level1;

import java.util.Arrays;
import java.util.HashMap;

public class Problem2 {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int[] result = new int[photo.length];
        for(int i = 0; i < photo.length; i++){
            for(String personPoint : photo[i]) {
                if(map.containsKey(personPoint)) {
                    result[i] += map.get(personPoint);
                    System.out.println(result[i]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] name = {"Joy", "Robin", "Jack", "Cody"};
        int[] yearning = {5, 4 ,3, 1};
        String[][] photo = {{"Joy", "Robin"}, {"Jack", "Roberts", "Cody"}, {"Robin", "Jack", "Cody", "Joy"}};

        int[] result = solution(name, yearning, photo);
        System.out.println(Arrays.toString(result));
    }
}
