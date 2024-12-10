package menu_renewal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MenuRenewal {

//    public static String[] solution(String[] orders, int[] course) {
//        String[][] peopleOrders = new String[orders.length][];
//        findOverLappingMenus(orders);
////        for(int i = 0; i < orders.length; i++) {
////            String[] personOrders = orders[i].split("");
////            Arrays.sort(personOrders);
////            System.out.println(Arrays.toString(personOrders));
////            peopleOrders[i] = personOrders;
////        }
////        System.out.println(Arrays.toString(peopleOrders));
////
////        ArrayList<String> result = new ArrayList<>();
////        for(int c : course) {
////            int maxCount = 2;
////            ArrayList<String> candidates = new ArrayList<>();
////
////
////        }
//
//        return orders;
//    }

//    public static void findOverLappingMenus(String[] orders) {
//        ArrayList<Set<Character>> orderSets = new ArrayList<>();
//        for(String order : orders) {
//            Set<Character> foodSet = new HashSet<>();
//            for(char c : order.toCharArray()){
//                foodSet.add(c);
//            }
//            orderSets.add(foodSet);
//        }
//
//        for(int i = 0; i < orderSets.size()-1; i++) {
//            for(int j = i + 1; j < orderSets.size(); j++) {
//                Set<Character> intersection = new HashSet<>();
//                intersection.retainAll(orderSets.get(j));
//
//                if (intersection.size() >= 2) {
//                    System.out.println("Order " + (i + 1) + " and Order " + (j + 1) + " have overlapping items: " + intersection);
//                }
//            }
//        }
//    }

    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String[]> arrOrders = new ArrayList<>();
        for(String order : orders) {
            String[] arrOrder = order.split("");
            Arrays.sort(arrOrder);
            arrOrders.add(arrOrder);
        }

        for(int c : course) {
//            for(orders)
        }
        return orders;
    }

    public static void makeCombo() {

    }

    public static void main(String[] args) {
        String[] order = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        String[] result = solution(order,course);
//        System.out.println(result);
    }

}

// course = length
// orders = 각 사람들이 주문한 요리들
// result = 2 사람 이상이 똑같은 주문을 했을 때

// split해서 array에 집어넣기
// course별로 나누기