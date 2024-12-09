package skill_level_test.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem13 {
    public static void solution(String[][] book_times) {
        int[][] booked = new int[book_times.length][2];
        for (int i = 0; i < book_times.length; i++) {
            int start = Integer.parseInt(book_times[i][0].substring(0, 2)) * 60 + Integer.parseInt(book_times[i][0].substring(3, 5));
            int end = Integer.parseInt(book_times[i][1].substring(0, 2)) * 60 + Integer.parseInt(book_times[i][1].substring(3, 5));
            booked[i] = new int[]{start, end + 10}; // 퇴실 후 10분 청소 시간 추가
        }

        // 시작 시간 기준으로 정렬
        Arrays.sort(booked, (a, b) -> Integer.compare(a[0], b[0]));

        // 우선순위 큐를 이용해 종료 시간을 관리
        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();
        for (int[] time : booked) {
            // 현재 예약의 시작 시간보다 종료 시간이 작거나 같은 방은 사용 가능
            if (!roomEndTimes.isEmpty() && roomEndTimes.peek() <= time[0]) {
                roomEndTimes.poll();
            }
            // 새로운 종료 시간 추가
            roomEndTimes.add(time[1]);
        }

        // 필요한 방의 수는 우선순위 큐의 크기
        System.out.println(roomEndTimes.size());

//        int[][] booked = new int[book_times.length][2];
//        int count = 0;
//        for(int i = 0; i < book_times.length; i ++) {
//            int start = Integer.parseInt(book_times[i][0].substring(0, 2)) * 60 + Integer.parseInt(book_times[i][0].substring(3, 5));
//            int end = Integer.parseInt(book_times[i][1].substring(0, 2)) * 60 + Integer.parseInt(book_times[i][1].substring(3, 5));
//
//            booked[i] = new int[]{start, end};
//            count++;
//        }
//
//        for(int i = 0; i < booked.length; i++) {
//            for(int j = 0; j <= i; j++) {
//                if(i == j) continue;
//                if(booked[i][0] - 10 >= booked[j][1] || booked[i][1] + 10 <= booked[j][0]){
//                    count--;
//                    continue;
//                }
//
//            }
//        }
//        System.out.println(count);
    }

    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        solution(book_time);
        System.out.println();
    }
}

//호텔을 운영 중인 코니는 최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다. 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용할 수 있습니다.
//예약 시각이 문자열 형태로 담긴 2차원 배열 book_time이 매개변수로 주어질 때, 코니에게 필요한 최소 객실의 수를 return 하는 solution 함수를 완성해주세요.