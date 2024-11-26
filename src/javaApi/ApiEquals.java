package javaApi;

// equals() method
// - Object 클래스의 메서드
// - ==와 동일하게 주소값을 비교하는 메서

import java.util.ArrayList;
import java.util.List;

// equals와 Object의 차이
// == : 비교하는 두 대상의 주소값을 비교
// equals() : 비교하는 두 대상의 값을 비교
public class ApiEquals {

    public static void testWithString() {
        String test1 = "test";
        String test2 = "test";
        String test3 = new String("test");

        // test1,test2는 주소값이 동일
        System.out.println(test1==test2);
        System.out.println(test1.equals(test2));

        //test3은 주소값이 다름
        System.out.println(test1==test3);
        System.out.println(test1.equals(test3));
    }

    public static void testWithList() {
        List<Integer> test1 = new ArrayList<>();
        List<Integer> test2 = new ArrayList<>();

        test1.add(1);
        test2.add(1);

        System.out.println(test1==test2);
        System.out.println(test1.equals(test2));
    }
}

