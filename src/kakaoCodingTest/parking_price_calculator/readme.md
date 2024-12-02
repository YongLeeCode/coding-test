## 3. 주차 요금 계산 - 2022 KAKAO BLIND RECRUITMENT

### 문제 설명
주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때,
차량별로 주차 요금을 계[EnglishWordWithStrDigit.java](../engilsh_word_with_string_digit/EnglishWordWithStrDigit.java)산하려고 합니다. 아래는 하나의 예시를 나타냅니다.

### 입출력
| fees(입력)                | records(입력) | result |
|-------------------------|-----------------|--------|
| [180, 5000, 10, 600]	   | ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]         |    [14600, 34400, 5000]    |
| [120, 0, 60, 591]       | ["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]          |    [0, 591]    |
| [1, 461, 1, 10]         | ["00:00 1234 IN"]         |    [14841]    |

### 풀이 클래스
- kakaoCodingTest.parking_price_calculator.ParkingPriceCalculator

### 풀이 과정에서 찾아 본 것
- Map.of()는 immutable이기 때문에 key value를 새로 바꿀 수 없다. 그래서 hashmap을 사용했다.
- HashMap은 put, get, containsKey, remove method를 가지고 있다.
- HashMap에 있는 key, value를 보려면 setEntry 메서드 사용

### 풀이 과정에서 알게된 것
- HashMap은 순서대로 가져오지 않는다. 이유는 HashMap 자체가 key, value로 가져오기 때문에 순서라는 개념이 없다.
- 그렇다면 대신 사용해야 하는 것은? LinkedHashMap

### 보완해야 할 것
- 데이트 메서드 사용해보기
- 변수 네이밍 신경쓰기
- 