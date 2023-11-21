## 분할 정복 - Divide and Conquer
작은 문제로 분할하여 문제를 해결  
  
* DP와의 차이 : 작은 문제의 중복 여부  
 - 다이나믹 : 중복O 메모리제이션으로 중복을 제거  
  - 분할정복 : 중복X 모두 한 번씩 푼다.  
  
  
----
  
#### 이분 탐색  
O(logn)  
  
> 이분 탐색은 이진 탐색, Binary Search 라고도 한다.
> 
> 순차적 탐색보다 빠른 탐색을 위해 나온 탐색 방법으로 실제로 이분 탐색의 시간복잡도가 순차적 탐색보다 낮다.
>
  
  
**🔎구현 방법**
재귀함수 또는 반복문으로 구현 가능  
먼저 수들을 정렬하고 아래 그림처럼 시작  
  
![image](https://github.com/hanseul9/algorithm/assets/102939057/1a910a56-0dff-4fd9-acba-7838ff8fa9ac)  
1. mid와 찾는 요소가 같다면 탐색 종료  
2. "mid < 찾는 요소" 일때는 left를 mid+1 로 하여 탐색 재시작  
3. "mid > 찾는 요소" 일때는 right를 mid-1 로 하여 탐색 재시작  
4. 만약 " left > right" 가 된다면 찾는 요소가 배열에 없는 것  
  
  
  
  
##### lower bound와 upper bound
  
> 특정 값이 배열에서 시작하는 인덱스와 끝나는 인덱스를 찾기 위해 사용됨. 
> 
> 중복된 원소가 많은 경우 최악의 경우 원소 전체를 살펴봐야 하기에 그런 경우 해당 방법 사용
>
  
- 찾으려는 값이 N일때  
    - Lower Bound: N보다 크거나 같은 첫 번째 원소의 위치  
    - Upper Bound: N보다 큰 첫 번째 원소의 위치 
	-> upper - lower => 중복된 원소의 갯수  
  
<details>
<summary>🔎좀 더 자세히</summary>
(10816 숫자 카드 2 참고)  
	
- Lower Bound:  
	- Lower Bound의 목표는 주어진 값 num보다 크거나 같은 첫 번째 원소의 위치(index)를 찾는 것  
	- 이를 위해 cards[mid]의 값이 num보다 크거나 같다면 정답은 mid 혹은 그보다 왼쪽에 있을 것이라고 판단됨. 따라서 right를 mid로 이동시켜 탐색 범위를 왼쪽으로 좁힌다.  
	- 반대로 cards[mid]의 값이 num보다 작으면 정답은 mid의 오른쪽에 있을 것이므로 left를 mid + 1로 업데이트하여 탐색 범위를 오른쪽으로 좁힌다  
   
- Upper Bound:  
	- Upper Bound의 목표는 주어진 값 num보다 큰 첫 번째 원소의 위치(index)를 찾는 것  
	- cards[mid]의 값이 num과 같거나 작다면 정답은 mid의 오른쪽에 있을 것이라고 판단됨. 따라서 left를 mid + 1로 업데이트하여 탐색 범위를 오른쪽으로 좁힌다.
	- 반대로 cards[mid]의 값이 num보다 크면 정답은 현재 mid 위치에 있거나 그보다 왼쪽에 있을 것이므로 right를 mid로 이동시켜 탐색 범위를 왼쪽으로 좁힌다.  
  
주어진 조건에 따라 탐색 범위를 좁혀나가는 것이 핵심
   
</details>
  
  
