![](https://velog.velcdn.com/images/yong-lee/post/a0a9f397-ab54-4218-b9fa-89dc1504a691/image.png)

## 가장 많이 받은 선물 - 2024 카카오 겨울 인턴


### 문제 설명
선물을 직접 전하기 힘들 때 카카오톡 선물하기 기능을 이용해 축하 선물을 보낼 수 있습니다. 당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.
- 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
    - 예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.

- 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
    - 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
    - 예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다. B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다. 만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.
    - 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.

위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.
 
친구들의 이름을 담은 1차원 문자열 배열 **friends** 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 **gifts**가 매개변수로 주어집니다. 이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.

***

### 제한사항
- 2 ≤ friends의 길이 = 친구들의 수 ≤ 50
    - friends의 원소는 친구의 이름을 의미하는 알파벳 소문자로 이루어진 길이가 10 이하인 문자열입니다.
    - 이름이 같은 친구는 없습니다.
- 1 ≤ gifts의 길이 ≤ 10,000
    - gifts의 원소는 "A B"형태의 문자열입니다. A는 선물을 준 친구의 이름을 B는 선물을 받은 친구의 이름을 의미하며 공백 하나로 구분됩니다.
    - A와 B는 friends의 원소이며 A와 B가 같은 이름인 경우는 존재하지 않습니다.


***
> 입출력 예

![](https://velog.velcdn.com/images/yong-lee/post/81a259e0-111b-42ba-b978-aa10b63b1410/image.png)

> 주고받은 선물과 선물 지수 표

![](https://velog.velcdn.com/images/yong-lee/post/659a8dcf-e488-4b22-a5c3-6396bd6f40ed/image.png)

![](https://velog.velcdn.com/images/yong-lee/post/8cf964cd-ce24-442d-8a40-be2cca256696/image.png)


***
### 풀이한 코드

```java
package kakaoCodingTest.max_gift_count;

import java.util.Arrays;

// 선물 양 a > b - 다음 달 b가 선물 1개 줌
// 주고 받은 수 가 같을 때, 선물 지수 낮은 사람이 선물 1개 줌

public class MaxGiftCount {
    public static void solveProblem(String[] friends, String[] gifts){

        int[][] moveGifts = new int[friends.length][friends.length];

        for(String gift : gifts){
            String[] giftGiverAndReceiver = gift.split(" ");
            String giver = giftGiverAndReceiver[0];
            String receiver = giftGiverAndReceiver[1];

            int giverPoint = 0;
            int receiverPoint = 0;
            for(int i = 0; i < friends.length; i++){
                if(friends[i].equals(giver)){
                    giverPoint = i;
                }
            }
            for(int i = 0; i < friends.length; i++){
                if(friends[i].equals(receiver)){
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
                } else if (moveGifts[i][j] == moveGifts[j][i]){
                    int person1 = Arrays.stream(moveGifts[i]).sum();
                    int person2 = Arrays.stream(moveGifts[j]).sum();
                    if(person1 > person2){
                        giftIndex[i]++;
                    }
                }
                receivedGiftCount += moveGifts[j][i];
            }
            giveMinusreceive[i] = givenGiftCount - receivedGiftCount;
        }

        System.out.println("giftIndex: " + Arrays.toString(giftIndex));

        if(areAllEqual(giveMinusreceive)){
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

}
```

***

### 참조
[프로그래머스 - 가장 많이 받은 선물](https://school.programmers.co.kr/learn/courses/30/lessons/258712)