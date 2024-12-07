package how_to_use_string.strange_string_creator;

//조건 stringbuilder 사용하기
public class StrangeStringCreator {
    public static void solution() {
        String s = "try hello world";
        boolean upper = true;
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isAlphabetic(c) && upper){
                builder.append((char)(c + ('A'-'a')));
                upper = false;
            } else {
                builder.append(c);
                upper = true;
            }
        }

        int n = 45;

        String str = Integer.toString(n, 3);
        String reversed = new StringBuilder(str).reverse().toString();
        int result = Integer.valueOf(reversed, 3);
        System.out.println(result);
        System.out.println(builder.toString());
    }
}
