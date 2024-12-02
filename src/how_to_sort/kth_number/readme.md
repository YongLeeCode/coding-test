## K번째 수

***
### 참조
https://school.programmers.co.kr/learn/courses/30/lessons/42748

***
### 문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

- array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
- 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
- 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.


***
### 제한사항
- array의 길이는 1 이상 100 이하입니다.
- array의 각 원소는 1 이상 100 이하입니다.
- commands의 길이는 1 이상 50 이하입니다.
- commands의 각 원소는 길이가 3입니다.

***
| array            | commands                          | return    |
|------------------|-----------------------------------|-----------|
| [1,5,2,6,3,7,4]  | [[2, 5, 3], [4, 4, 1], [1, 7, 3]] | [5, 6, 3] |

***
### 문제의 키 포인트
- copyOfRange 메서드 혹은 for문으로 구현
- 배열 정렬(sort)

***
### 코드 작성 전 설계
- commands의 forloop을 만든다.
- for문 안에서 command의 [0]-1의 값부터 [1]까지의 값을 array를 substring한다.
- for문 안에서 [2]에 해당하는 잘려진 array의 숫자를 구한다.
- arrayList에 저장한다.

### 처음 설계한 것의 문제점
- substring은 String에만 사용
  - 배열에서 자를 수 있는 방법: copyOfRange 메서드를 사용
- 잘려진 array를 오름차순으로 정렬해야함
  - Arrays.sort()라는 간단한 방법을 찾음
- 정렬된 잘려진 array에서 slicedArray[commands[i][2]-1] 이런식으로 -1을 해줘야 원하는 값을 가져올 수 있음

### 풀이 과정
- 정답의 int배열 변수 선언
- commands의 길이까지의 for loop 사용 
- for loop 안
  - command[0]부터 command[1]까지의 array까지 잘라서 새로운 배열 변수에 선언
  - 잘린 array의 정렬
- 정렬된 잘린 array에서 command[2]번째의 숫자 찾기

### 풀이 과정 중 찾아본 것
- copyOfRange 메서드

### 후기
배열을 자르는 법만 알면 크게 어렵지 않은 문제였다.

### 시간 복잡도
- 반복문: O(commands의 길이) = O(N)
- 배열 자르기: O(array의 길이) = O(M)
- 정렬: O(M logM)

결론: O(N * M logM)
