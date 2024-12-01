# 코딩 테스트

## 1. 숫자 문자열과 영단어 - 2021 카카오 채용연계형 인턴십

### 문제 설명
네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.

### 입출력 예
|s(입력)              | result |
|--------------------|--------|
| "one4seveneight"   | 1478   |
| "23four5six7"      | 234567 |
| "2three45sixseven" | 234567 |
| "123"              | 123    |

### 풀이 클래스
- kakaoCodingTest.EnglishWordWithDigit

### 풀이 과정에서 찾아 본 것
- map 사용법
- matches method 사용법


## 2. 럭키 스트레이트

### 문제 설명
어떤 게임의 아웃복서 캐릭터에게는 럭키 스트레이트라는 기술이 존재한다. 
이 기술은 매우 강력한 대신에 항상 사용할 수는 없으며, 현재 게임 내에서 점수가 특정 조건을 만족할 때만 사용할 수 있다.

특정 조건이란 현재 캐릭터의 점수를 N이라고 할 때 점수 N을 자릿수를 기준으로
반으로 나누어 왼쪽 부분의 각 자릿수의 합과 오른쪽 부분의 각 자릿수의 합을 더한 값이 동일한 상황을 의미한다. 
예를 들어 현재 점수가 123,402라면 왼쪽 부분의 각 자릿수의 합은 1+2+3, 
오른쪽 부분의 각 자릿수의 합은 4+0+2이므로 두 합이 6으로 동일하여 럭키 스트레이트를 사용할 수 있다.

현재 점수 N이 주어졌을 때, 럭키 스트레이트를 사용할 수 있는 상태인지 아닌지를 알려주는 프로그램을 작성하시오. 
럭키 스트레이트를 사용할 수 있다면 "LUCKY"를, 사용할 수 없다면 "READY"라는 단어를 출력한다. 
또한 점수 N의 자릿수는 항상 짝수 형태로만 주어진다. 
예를 들어 자릿수가 5인 12,345와 같은 수는 입력으로 들어오지 않는다.

### 입출력 예
| (입력)  | result  |
|--------|---------|
| 123402 | "LUCKY" |
| 7755   | "READY  |
| 555111 | "LUCKY" |
| 1234   | "READY" |

### 풀이 클래스
- baekjoonCodingTest.LuckyStraight

### 풀이 과정에서 찾아 본 것
- 없음


## 3. 주차 요금 계산 - 2022 KAKAO BLIND RECRUITMENT

### 문제 설명
주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 
차량별로 주차 요금을 계산하려고 합니다. 아래는 하나의 예시를 나타냅니다.

### 입출력
| fees(입력) | records(입력) | result |
|---------|-----------------|--------|
| [180, 5000, 10, 600]	  | ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]         |    [14600, 34400, 5000]    |
| [120, 0, 60, 591]  | ["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]          |    [0, 591]    |
| [1, 461, 1, 10] | ["00:00 1234 IN"]         |    [14841]    |

### 풀이 클래스
- kakaoCodingTest.ParkingPriceCalculator

### 풀이 과정에서 찾아 본 것
- 풀이 중


