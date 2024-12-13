//package menu_renewal;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class MenuRenewal {
//
////    public static String[] solution(String[] orders, int[] course) {
////        String[][] peopleOrders = new String[orders.length][];
////        findOverLappingMenus(orders);
//////        for(int i = 0; i < orders.length; i++) {
//////            String[] personOrders = orders[i].split("");
//////            Arrays.sort(personOrders);
//////            System.out.println(Arrays.toString(personOrders));
//////            peopleOrders[i] = personOrders;
//////        }
//////        System.out.println(Arrays.toString(peopleOrders));
//////
//////        ArrayList<String> result = new ArrayList<>();
//////        for(int c : course) {
//////            int maxCount = 2;
//////            ArrayList<String> candidates = new ArrayList<>();
//////
//////
//////        }
////
////        return orders;
////    }
//
////    public static void findOverLappingMenus(String[] orders) {
////        ArrayList<Set<Character>> orderSets = new ArrayList<>();
////        for(String order : orders) {
////            Set<Character> foodSet = new HashSet<>();
////            for(char c : order.toCharArray()){
////                foodSet.add(c);
////            }
////            orderSets.add(foodSet);
////        }
////
////        for(int i = 0; i < orderSets.size()-1; i++) {
////            for(int j = i + 1; j < orderSets.size(); j++) {
////                Set<Character> intersection = new HashSet<>();
////                intersection.retainAll(orderSets.get(j));
////
////                if (intersection.size() >= 2) {
////                    System.out.println("Order " + (i + 1) + " and Order " + (j + 1) + " have overlapping items: " + intersection);
////                }
////            }
////        }
////    }
//
////    public static String[] solution(String[] orders, int[] course) {
////        ArrayList<String[]> arrOrders = new ArrayList<>();
////        for(String order : orders) {
////            String[] arrOrder = order.split("");
////            Arrays.sort(arrOrder);
////            arrOrders.add(arrOrder);
////        }
////
////        for(int c : course) {
//////            for(orders)
////        }
////        return orders;
////    }
////
////    public static void makeCombo() {
////
////    }
//
//    public static String[] solution(String[] orders, int[] course) {
//        HashMap<Character, List<Integer>> map = new HashMap<>();
//
//        // key: 요리 - c[j] , value: 손님 번호 - i
//        for (int i = 0; i < orders.length; i++) {
//            char[] c = orders[i].toCharArray();
//            for (int j = 0; j < c.length; j++) {
//                int customer = i + 1;
//
//                // 병합 - 각각의 요리들을 시킨 손님 번호를 리스트 마다 병합
//                ArrayList<Integer> arr = new ArrayList<>();
//                if (!map.containsKey(c[j])) {
//                    arr.add(customer);
//                } else {
//                    arr.addAll(map.get(c[j]));
//                    arr.add(customer);
//                }
//                map.put(c[j], arr);
//            }
//
//        }
//
//        List<String> result = new ArrayList<>();
//        for (int c : course) {
//            HashMap<String, Integer> comboCount = new HashMap<>();
//            List<Character> foodList = new ArrayList<>(map.keySet());
//
//            generateCombos(foodList, 0, c, new ArrayList<>(), map, comboCount);
//        }
//        return orders;
//    }
//
//    private static void generateCombos(
//            List<Character> foodList,
//            int curr,
//            int size,
//            ArrayList<Character> currentCombo,
//            HashMap<Character, List<Integer>> map,
//            HashMap<String, Integer> comboCount
//            ) {
//
//        currentCombo.add(foodList.get(curr));
//        if(currentCombo.size() > size){
//            return;
//        }
//        if(currentCombo.size() == size){
//            ArrayList<Integer> foodPurchaser = new ArrayList<>();
//            for(int i = 0; i < )
//            for(int i = 0; i < size; i++){
//              foodPurchaser.retainAll(map.get(currentCombo.get(i)));
//            }
//            System.out.println(foodPurchaser);
//        }
//    }
//
//    public static void main(String[] args) {
//        String[] order = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] course = {2, 3, 4};
//        String[] result = solution(order, course);
////        System.out.println(result);
//    }
//
//}
//
//// course = length
//// orders = 각 사람들이 주문한 요리들
//// result = 2 사람 이상이 똑같은 주문을 했을 때
//
//// split해서 array에 집어넣기
//// course별로 나누기