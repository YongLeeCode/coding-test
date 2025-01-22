package dynamicProgramming;

// 출처: leetcode
// 문제 제목: Is Subsequence
public class IsSubsequence {

    //이 문제는 문자의 순서를 바꾸면 안되는 문제였음....
//    public static boolean isSubsequence(String s, String t) {
//        if(s.equals("") && t.equals("")) {
//            return true;
//        }
//
//        String[] arrS = s.split("");
//        String[] arrT = t.split("");
//
//        Arrays.sort(arrS);
//        Arrays.sort(arrT);
//        int index = 0;
//        for(int i = 0; i < arrT.length; i++) {
//            if(arrT[i].equals(arrS[index])) {
//                index++;
//            }
//
//            if (index >= s.length()) {
//                break;
//            }
//        }
//
//        return index == s.length();
//    }

    // 생각한 다른 방법
//    public static boolean isSubsequence(String s, String t) {
//        if(s.equals("") && !t.isEmpty()) {
//            return true;
//        }
//        int sindex = 0;
//        for(int i = 0; i < t.length(); i++) {
//            char tChar = t.charAt(i);
//            char sChar = s.charAt(sindex);
//            if(tChar == sChar) {
//                sindex++;
//            }
//
//            if(sindex >= s.length()) {
//                break;
//            }
//        }
//        return sindex == s.length();
//    }

    // 다른 사람이 풀었던 가장 효율적인 방법
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        String s = "abdcz";
        String t = "ahbgdc";
        boolean result = isSubsequence(s, t);
        System.out.println(result);
    }
}
