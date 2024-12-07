## H-Index

***
### 참조
https://school.programmers.co.kr/learn/courses/30/lessons/42747

***
### 문제 설명
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

***
### 제한사항
- 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
- 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

***
| numbers         | result       |
|-----------------|--------------|
| [3, 0, 6, 1, 5] | 3            |

***
### 코드 작성 전 설계
- citations를 정렬
- citations의 길이를 구하기
- citations 길이/2의 값을 얻는다
- 만약 citations의 길이가 짝수라면?
  - 중간 값을 구해야하나?

### 처음 설계한 것의 문제점
- citations 길의 중간 값을 구하는 문제가 아님을 알게 되었다.
- 정렬후 citations의 뒤에서부터 h의 인덱스를 구한다. 이것을 h번째로 정의한다.
- citations[citations.length-h] <=h여야 한다. 

### 풀이 과정
- 코드 작성 전 첫 설계대로 만들고 실패
- 새로운 코드 작성 시작
- citations를 정렬
- citations의 길이를 내림차순으로 반복문 만들기
  - h가 citations의 citations길이-h의 값 보다 작은지 true, false로 체크
  - 위에 조건이 성공 했을 때의 h가 정답

***
### 문제의 키 포인트
- 문제를 완벽하게 이해하기

### 풀이 과정 중 찾아본 것
- 없음

### 후기
문제를 이해하지 못해 상당한 시간을 사용했다.

### 시간 복잡도
- 정렬: O(citations 길이의 정렬) == O(N logN)
- 반복문: O(citations 길이) == O(N)

결론: O(N logN)
