package exam2;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static List<String> solution(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() > 12){
            return result;
        }
        return dfs(1,2,3, result, s);

    }
    private static List<String> dfs(int d1, int d2, int d3, List<String> result, String s) {
        if (d1 > s.length() || d2 > s.length() || d3 > s.length()) {
            return result;
        }

        String part1 = s.substring(0, d1);
        String part2 = s.substring(d1, d2);
        String part3 = s.substring(d2, d3);
        String part4 = s.substring(d3);

        if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
            if(result.contains(part1 + "." + part2 + "." + part3 + "." + part4)){
                return result;
            };
            result.add(part1 + "." + part2 + "." + part3 + "." + part4);
        }

        dfs(d1, d2, d3+1, result, s);
        dfs(d1, d2+1, d3+1, result, s);
        dfs(d1+1, d2+1, d3+1, result, s);

        return result;
    }

    private static boolean isValid(String part) {
        if (part.isEmpty() || part.length() > 3 || (part.startsWith("0") && part.length() > 1)) {
            return false;
        }
        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }
    public static void main(String[] args) {
//        String s = "012345";
        String s = "25525511135";
        solution(s);
    }
}

// 999 999 999 999 999 999 99"