package hash.phone_book;

import java.util.HashSet;

public class PhoneBook {

//    public static boolean solution(String[] phone_book) {
//        HashSet<String> set = new HashSet<>();
//        String[][] letters = new String[phone_book.length][];
//        for(int i = 0; i < phone_book.length; i++) {
//            set.add(phone_book[i]);
//            letters[i] = phone_book[i].split("");
//        }
//        for(int i = 0; i < letters.length; i++) {
//            String num = "";
//            for(int j = 0; j < letters[i].length; j++) {
//                num += letters[i][j];
//                if(set.contains(num)){
//                    return false;
//                }
//            }
//        }
//        System.out.println(Arrays.deepToString(letters));
//        return true;
//    }

    public static boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();

        for (String phone : phone_book) {
            set.add(phone);
        }

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean result = solution(phone_book);
        System.out.println(result);
    }
}
