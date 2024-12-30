package exam3;

public class NextBigNumber {
    public static int solution(int n) {
        String binaryN = Integer.toBinaryString(n);
        int count = binaryN.length() - 1;
        System.out.println(binaryN + " " + count);
        while(count >= 0) {
            if(binaryN.charAt(count) == '1') {
                if(count != 1 || binaryN.charAt(count - 1) == '0') {
                    String a = binaryN.substring((binaryN.length() - 1) - count);
                    System.out.println(count);
                }
            }
            count--;
        }

        return 0;
    }
    public static void main(String[] args) {
        int result = solution(78);
        System.out.println(result);
    }
}


//시간초과
//int next = n + 1;
//int count = 0;
//int nextCount = 0;
//
//String binaryN = Integer.toBinaryString(n);
//String binaryNext = Integer.toBinaryString(next);
//
//        for(int i = 0; i < binaryN.length(); i++) {
//        if(binaryN.charAt(i) == '1') count++;
//        }
//        System.out.println(count);
//
//        while(nextCount != count) {
//nextCount = 0;
//        for(int i = 0; i < binaryNext.length(); i++) {
//        if(binaryNext.charAt(i) == '1') nextCount++;
//        }
//        System.out.println(nextCount);
//next++;
//binaryNext = Integer.toBinaryString(next);
//        }
//
//                System.out.println(Integer.parseInt(binaryNext, 2));