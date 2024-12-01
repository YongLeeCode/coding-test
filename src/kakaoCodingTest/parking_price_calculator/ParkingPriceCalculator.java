// 기본 시간, 기본 요금, 단위 시간, 단위 요금 변수로 새로 정의하기
// for문으로 records를 record로 하나씩 구한다.
// record를 split => 시각, 차량번호, 내역

// ??시:??분을 분 단위로 만드는 메서드 (가장 높은 많은 시각 1439)
// map을 사용하여 차량번호를 key 시각을 value로 가져온다

// 내역: 입차 일 때, map에 새로운 key value 추가
// 출차: 출차 일 때, map의 key가 있을 테니 출차 시각 - 입차 시각(value) 및 나간 차량의 key 삭제
// 주차 요금 계산

// int[]에 추가하여 요금 집어 넣기
// 만약 map에 차량이 있다면 1339 - (입차시각)value

//int[]에 마지막 차량까지 집어넣기

package kakaoCodingTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ParkingPriceCalculator {
    public static int[] fees = {180, 5000, 10, 600};
    public static String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
            "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

    public static void solveProblem() {
        List<Integer> finalPrice = new ArrayList<>();
        Map<String, Integer> hashNum = new HashMap<>();
        Map<String, Integer> hashParkingTimes = new HashMap<>();

        for (String record : records) {
            String[] recStr = record.split(" ");
            String[] clock = recStr[0].split(":");
            int minutes = getMinutes(clock[0], clock[1]);
            String carNum = recStr[1];
            String history = recStr[2];

            if (history.equals("IN")) {
                hashNum.put(carNum, minutes);
            } else if (history.equals("OUT") && !hashParkingTimes.containsKey(carNum)) {
                hashParkingTimes.put(carNum, minutes - hashNum.get(carNum));
                hashNum.remove(carNum);
            } else if (history.equals("OUT") && hashParkingTimes.containsKey(carNum)) {
                hashParkingTimes.put(carNum, (minutes - hashNum.get(carNum)) + hashParkingTimes.get(carNum));
                hashNum.remove(carNum);
            }
        }

        // hashNum에 아직 남아 있는 키 확인
        if (!hashNum.isEmpty()) {
            for (Entry<String, Integer> entry : hashNum.entrySet()) {
                String carNum = entry.getKey();
                Integer minutes = entry.getValue();
                if (hashParkingTimes.containsKey(carNum)) {
                    hashParkingTimes.put(carNum, hashParkingTimes.get(carNum) + (1439 - minutes));
                } else {
                    hashParkingTimes.put(carNum, 1439 - minutes);
                }
            }
        }

        for (Entry<String, Integer> parkingTime : hashParkingTimes.entrySet()) {
            finalPrice.add(calculatePayment(parkingTime));
        }

        System.out.println(finalPrice);

    }

    private static int calculatePayment(Entry<String, Integer> parkingTime) {
        int normalTime = fees[0];
        int normalPrice = fees[1];
        int extraTime = fees[2];
        int extraPrice = fees[3];

        if(parkingTime.getValue() > normalTime){
             double priceD =  normalPrice + Math.ceil((double) (parkingTime.getValue() - normalTime) / extraTime) * extraPrice;
            return (int) priceD;
        } else {
            return normalPrice;
        }

    }

    private static int getMinutes(String hour, String minute) {
        return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }
}

