package skill_level_test.level1;

import java.util.Arrays;
import java.util.HashSet;

public class Problem1 {

    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int lostButreserve = 0;
        for(int j = 0; j < lost.length; j++){
            for(int i = 0; i < reserve.length; i++) {
                if(lost[j] == reserve[i]) {
                    lostButreserve++;
                    lost[j] = -1;
                    reserve[i] = -1;
                }
            }
        }

        int joinClass = n - lost.length + lostButreserve;
        for(int j= 0; j < lost.length; j++) {
            if (lost[j] == -1) continue;
            for(int i = 0; i < reserve.length; i++) {
                if (reserve[i] == -1) continue;
                if(Math.abs(lost[j]- reserve[i]) == 1){
                    System.out.println(joinClass + " " + n + " " + lost[j] + " " + reserve[i]);
                    joinClass++;
                    reserve[i] = -1;
                    lost[j] = -1;

                    break;
                }
            }
        }

        return Math.min(joinClass, n);
    }

    public static void main(String[] args) {
        int n = 4;
        int[] lost = {2,3};
        int[] reserve = {3, 4};
        int result = solution(n, lost, reserve);
        System.out.println(result);
    }

    public int anotherGuySolution(int n, int[] lost, int[] reserve) {
        int answer = n;
        HashSet<Integer> resList = new HashSet<>();
        HashSet<Integer> losList = new HashSet<>();

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i : reserve)
            resList.add(i);
        for (int i : lost) {
            if(resList.contains(i))
                resList.remove(i);
            else
                losList.add(i);
        }
        for (int i : lost) {
            if(losList.contains(i)) {
                if(resList.contains(i-1))
                    resList.remove(i-1);
                else if(resList.contains(i+1))
                    resList.remove(i+1);
                else
                    answer--;
            }
        }
        return answer;
    }
}
