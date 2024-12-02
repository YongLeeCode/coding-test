package kakaoCodingTest.max_gift_count;

import java.util.Arrays;

// 선물 양 a > b - 다음 달 b가 선물 1개 줌
// 주고 받은 수 가 같을 때, 선물 지수 낮은 사람이 선물 1개 줌

public class MaxGiftCount {

    public static void solveProblem(String[] friends, String[] gifts) {

        int[][] moveGifts = new int[friends.length][friends.length];

        for (String gift : gifts) {
            String[] giftGiverAndReceiver = gift.split(" ");
            String giver = giftGiverAndReceiver[0];
            String receiver = giftGiverAndReceiver[1];

            int giverPoint = 0;
            int receiverPoint = 0;
            for (int i = 0; i < friends.length; i++) {
                if (friends[i].equals(giver)) {
                    giverPoint = i;
                }
            }
            for (int i = 0; i < friends.length; i++) {
                if (friends[i].equals(receiver)) {
                    receiverPoint = i;
                }
            }
            moveGifts[giverPoint][receiverPoint] += 1;
        }

        // friends 어레이를 이용해서 가장 많은 다음 달 리시버 찾기
        // 받은 선물 < 준 선물
        int[] giftIndex = new int[friends.length];
        int[] giveMinusreceive = new int[friends.length];
        for (int i = 0; i < moveGifts.length; i++) {
            int givenGiftCount = Arrays.stream(moveGifts[i]).sum();
            int receivedGiftCount = 0;
            for (int j = 0; j < moveGifts.length; j++) {
                if (moveGifts[i][j] > moveGifts[j][i]) {
                    giftIndex[i]++;
                } else if (moveGifts[i][j] == moveGifts[j][i]) {
                    int person1 = Arrays.stream(moveGifts[i]).sum();
                    int person2 = Arrays.stream(moveGifts[j]).sum();
                    if (person1 > person2) {
                        giftIndex[i]++;
                    }
                }
                receivedGiftCount += moveGifts[j][i];
            }
            giveMinusreceive[i] = givenGiftCount - receivedGiftCount;
        }

        System.out.println("giftIndex: " + Arrays.toString(giftIndex));

        if (areAllEqual(giveMinusreceive)) {
            System.out.println(0);
        } else {
            int nextMaxGift = Arrays.stream(giftIndex).max().getAsInt();
            System.out.println("다음 달 최고 많은 선물 수는: " + nextMaxGift);
        }
    }

    public static boolean areAllEqual(int[] array) {
        if (array == null || array.length == 0) {
            return false; // 비어있는 배열은 같다고 할 수 없음
        }

        // 첫 번째 요소와 나머지 요소들을 비교
        int firstElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != firstElement) {
                return false; // 하나라도 다르면 false 리턴
            }
        }
        return true; // 모든 요소가 같으면 true 리턴
    }

    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        solveProblem(friends, gifts);
    }
}
