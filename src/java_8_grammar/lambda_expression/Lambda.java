package java_8_grammar.lambda_expression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List list = new ArrayList<>();

        list.add("void");
        list.add("public");
        list.add("static");


        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });


        list.sort((Comparator<String>) (str1, str2)-> {
            System.out.println(str1 + " " + str2);
            return 0;
        });
        System.out.println(" --- --- ---");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
