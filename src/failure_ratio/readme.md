
## 실패율

### 참조
https://school.programmers.co.kr/learn/courses/30/lessons/42889
### 문제 설명
슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.

- 실패율은 다음과 같이 정의한다.
  - 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

***

### 제한사항
- 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
- stages의 길이는 1 이상 200,000 이하이다.
- stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
  - 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
  - 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
- 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
- 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.


### 입출력 예
| N      | stages                   | result          |
|--------|--------------------------|-----------------|
| 5      | [2, 1, 2, 6, 2, 4, 3, 3] | [3, 4, 2, 1, 5] |
| 4      | [4, 4, 4, 4, 4]          | [4, 1, 2, 3]    |

### 문제의 키 포인트
- 실패율 == 스테이지에 도달했으나 아직 클리어 못 한 사람들 / 스테이지에 도달한 모든 사람들
- N+1 == 마지막 스테이지 클리어한 사람
- 배열, 리스트 정렬하는 법

### 풀이 과정
- 두 개의 HashMap을 만들었다.
  - map은 그 스테이지에 도달하고 해결 못한 사람들
  - reachedStagePlayer는 그 스테이지에 도달한 경험이 있는 사람들
- 첫번째 반복문:
  - map에 stage의 숫자가 없을 경우 key에 1을 default하여 map에 추가, key가 있을 경우 기존 value +1
- 두번째 반복문:
  - 이중 for문을 사용해서 첫번째 반복문과 비슷한 방법으로 스테이지에 도달한 사람 수를 구함
- 세번째 반복문:
  - 앞서 만들었던 변수들을 사용해서 각 스테이지별 실패율 구하기
- 순서 정렬
  - lambda 표현식을 사용하여 순위를 만듬

### 풀이 과정 중 찾아본 것
- lambda 표현식

### 후기
고민이 많았던 부분은 '스테이지 도달한 플레이어 수를 어떻게 구할까?'였다.
왠만하면 이중반복문을 사용하고 싶지 않았지만 방법을 찾지 못했다.
문제를 완벽하게 풀지 못했다.
프로그래머스에서 문제를 제출해보니 66퍼센트의 문제만 정답으로 나왔다.
아직 어떤 문제를 찾지 못해서 고민해봐야할 것 같다.

### 시간 복잡도
- 첫번째 반복문:
  - stages의 크기 만큼 돌기 때문에 O(stages)이라고 생각한다.
- 두번째 반복문:
  - N의 반복문 안에 stages의 반복이 있기 때문에 O(N* stages)이라고 생각한다.
- 세번째 반복문:
  - N의 크기 만큼 도는 반복문이기 때문에 O(N)
- 정렬: 람다식 표현법은 O(N logN)으로 알고 있다.

결론: O(N*M)