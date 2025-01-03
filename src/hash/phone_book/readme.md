## 전화번호 목록

***
### 참조
https://school.programmers.co.kr/learn/courses/30/lessons/42577

***
### 문제 설명
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

- 구조대 : 119
- 박준영 : 97 674 223
- 지영석 : 11 9552 4421

전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

***
### 제한 사항
- phone_book의 길이는 1 이상 1,000,000 이하입니다.
    - 각 전화번호의 길이는 1 이상 20 이하입니다.
    - 같은 전화번호가 중복해서 들어있지 않습니다.

***
| array                             | return |
|-----------------------------------|--------|
| ["119", "97674223", "1195524421"] | false  |

***
### 문제의 키 포인트
- 어떻게 접두사를 찾을지

***
### 코드 작성 전 설계
- HashSet에 번호들을 집어 넣는다.
- 번호들을 split("")하여 String[][] 형태의 letters로 바꾼다.
- 이중 for loop으로 겹치는 번호 찾기

### 처음 설계한 것의 문제점
- 이런식으로 하면 자기 번호도 이중 for loop를 돌릴 때, 반드시 걸려서 모든 결과가 false로 나온다.

### 풀이 과정
- 코드 작성 전 설계대로 한 후 안 되는 것을 알고 다른 방법을 찾아냈다.
- 바로 substring을 사용하여 접두어를 찾아내는 방식이다.

### 풀이 과정 중 찾아본 것
- 없음

### 후기
다른 사람들은 startsWith라는 메서드를 알았다면 조금 더 쉽게 풀었을 거라 생각이 든다.

### 시간 복잡도
- 첫번째 반복문: O(phone_book의 길이) => O(N)
- 두번째 반복문: O(phone_book의 길이 * 각 번호의 길이) => O(N * M)

결과: O(N*M)