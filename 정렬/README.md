# 정렬

🍮버블정렬, 선택정렬, 삽입정렬, 계수정렬은 [10817 세 수] 에 구현해놓음  
🍮병합정렬은 [2751 수 정렬하기 2] 에 구현해놓음  
🍮퀵정렬은 2750 
  
---
  
### 버블 정렬  
**bubble sort -  O(n^2)**  
인접한 두 원소를 비교하고 필요한 경우 위치를 교환하여 정렬하는 알고리즘  
  
<img src="https://github.com/hanseul9/algorithm/assets/102939057/1874e70c-c6bd-44a3-966e-2b795cdf73df" width="400">  
  
🌟이중for문 돌리면서 제일 큰 수는 맨 오른쪽으로 밀어버림. 그럼 맨 오른쪽은 정렬이 끝난거니 거길 제외하고 for문을 돌게됨  
이중 for문이라 성능은 n^2  
  
---  
  
### 선택정렬  
**Selection Sort - O(n^2)**  
정렬되지 않은 부분에서 **최솟값을 선택**하여 정렬된 부분의 마지막에 추가하는 방식으로 정렬하는 알고리즘  
  
<img src="https://github.com/hanseul9/algorithm/assets/102939057/1f699772-7e51-41c6-a6fc-f8314179c641" width="400">  
  
🌟이중으로 돌면서 최소값을 구하고 왼쪽으로 밀어버림. 
이때 왼쪽의 정렬된 요소들은 제외하고 안쪽에서 돌면서 또 최솟값 구하고 정렬된 요소들을 제외한 배열의 첫번째와 최소값을 swap  
  
  
---  
  
### 삽입정렬  
**insertion sort - O(n^2)**  
배열 요소를 하나씩 삽입하면서 정렬하는 알고리즘. 배열 첫 번째 요소는 이미 삽입했다 가정하고 나머지 요소들을 하나씩 삽입함  
  
<img src="https://github.com/hanseul9/algorithm/assets/102939057/12781d15-f2e9-46c6-a696-e52d9a6eb184" width="500">  
  
🌟왼쪽에 정렬된 요소들을 두는 것. 이중 반복문을 돌면서 삽입할 요소를 하나씩 이미 정렬된 요소들 사이에 끼워넣음.  
삽입될 위치는 if문으로 오른쪽으로 밀면서 만들고 안쪽 루프가 종료되면 삽입하여줌  
  
  
---  
  
### 계수 정렬
**Counting sort - O(n+k)**
원소간 비교하지 않고 각 원소가 몇개 등장하는지 갯수를 세서 정렬하는 알고리즘.  
빠르지만 다음과 같은 제약사항을 갖는다  
```
1. 데이터(값)은 양수여야 한다.
2. 값의 범위가 너무 크지 않아야 한다.(메모리 사이즈를 넘어서는 안된다.)
```  
배열을 사용해야하기 때문에 위같은 제약사항이 존재함. (배열의 인덱스는 양수만 존재하고 메모리 이상 활용하지 못하기 때문)  
  
  
<details>
<summary>🔎자세한 방법</summary>
  
1. 원본 데이터를 저장한다.  
  
2. count 배열에 각 숫자가 몇 번 나왔는지 저장한다. 원본 배열의 요소를 count배열의 index에 대응하여 저장한다.
   
3. count 배열을 통해 sum배열을 만들어준다. sum 배열은 내 앞에 숫자가 몇 개 있느냐를 세어준다.
count 배열에 저장되어있는 배열 요소의 개수를 통해 판단하고 마찬가지로 index에 대응하여 앞에 몇 개의 숫자가 있는지 저장한다. 이때 “앞에 있는 수” 는 자기 자신도 포함한다.
여기서 결론적으로 sum 배열은 각각의 요소가 정렬된 배열의 어디에 위치해야하는지 표시하는 것과 같아진다.  
  
4. 마지막으로 정렬 배열에 정리해준다. 원본 배열의 마지막 인덱스부터 순회하여 원본 배열의 요소의 위치는 sum배열에 있으니 sum배열을 통해 정렬 배열에 넣어주고, 다음에 넣을 동일한 값의 요소를 위해 sum배열의 값을 -1 해준다.
   
</details>
  
  
보면 알겠지만 배열에서 사용하지 않는 공간이 많기 때문에 메모리 낭비가 심하다. 
명확한 데이터의 제한이 있다면 이득인 정렬.  

<details>
<summary>역순으로 도는 이유</summary>

  10817 세 수의 couting 구현 메소드를 보면 4번 단계에서 역순으로 도는데, couting sort의 stable한 특성을 깨지게 하지 않기 위해서이다.  

  예를 들어 [ 1, 3(a), 6, 5, 3(b) 2, 4 ] 라는 배열이 있다면 역순으로 돌아야 [ ..., 3(a), 3(b), ... ] 와 같이 순서대로 정렬되기 때문.  

  해당 배열의 sum 배열에서 sum[3] = 4 일 것이고 즉 "4번째" 에 삽입되고 sum[3]--; 가 이뤄져서 sum[3] = 3 이 되어 다음의 3은 "3번째"에 삽입될 것이다.  

  따라서 역순으로 돌아야 stable하게 정렬이 가능해진다.

</details>
  
  
  
---  
  
### 병합 정렬
**Merge Sort - O(nlogn)**  
반으로 나눈 뒤에 각각 정렬하고, 정렬된 두 개의 배열을 합치는 과정을 반복하여 정렬하는 알고리즘  
'분할 정복' 알고리즘을 기반으로 정렬되는 방식  
  
<details>
<summary>🔎자세한 방법</summary>
  
![image](https://github.com/hanseul9/algorithm/assets/102939057/25bfe661-df01-4f43-9c0e-cbb1d070aab9)

  
1. 주어진 리스트를 절반으로 분할하여 부분리스트로 나눈다. (Divide : 분할)
  
2. 해당 부분리스트의 길이가 1이 아니라면 1번 과정을 되풀이한다. (재귀 함수)
   
3. 인접한 부분리스트끼리 정렬하여 합친다. (Conqure : 정복)
  
  * 주의할 점은 각각의 부분 리스트는 정렬된 상태이다.
  * 합치는 과정에서 추가로 배열이 필요함 
</details>
  
  
  
---  
  
### 퀵 정렬
**Quick Sort - O(nlogn)**  
하나의 리스트를 피벗(pivot)을 기준으로 두 개의 부분리스트로 나누어 하나는 피벗보다 작은 값들의 부분리스트, 다른 하나는 피벗보다 큰 값들의 부분리스트로 정렬한 다음, 각 부분리스트에 대해 다시 위 처럼 재귀적으로 수행하여 정렬하는 알고리즘  
- 병합 정렬과 마찬가지로 '분할 정복' 알고리즘을 기반으로 정렬된다. 
-  병합 정렬과 다른 점은
	- 병합 정렬의 경우에는 하나의 리스트를 **절반**으로 나누어 분할정복
	- 퀵 정렬의 경우 피벗 값에 따라 부분리스트의 크기가 다를 수 있음 
	- 일반적으로 퀵 정렬이 더 빠르다 
- 비교정렬 / 제자리 정렬 / 불안정 정렬 
  
<details>
<summary>🔎자세한 방법</summary>

```  
1. 피벗을 하나 선택한다.
  
2. 피벗을 기준으로 양쪽에서 피벗보다 큰 값, 혹은 작은 값을 찾는다. 왼쪽에서부터는 피벗보다 큰 값을 찾고, 오른쪽에서부터는 피벗보다 작은 값을 찾는다.
   
3. 양 방향에서 찾은 두 원소를 교환한다.
  
4. 왼쪽에서 탐색하는 위치와 오른쪽에서 탐색하는 위치가 엇갈리지 않을 때 까지 2번으로 돌아가 위 과정을 반복한다.
  
5. 엇갈린 기점을 기준으로 두 개의 부분리스트로 나누어 1번으로 돌아가 해당 부분리스트의 길이가 1이 아닐 때 까지 1번 과정을 반복한다. (Divide : 분할)
  
6. 인접한 부분리스트끼리 합친다. (Conqure : 정복)
```  
  * 피벗을 선택하는 과정은 대표적으로 [현재 부분배열의 가장 왼쪽 원소가 피벗이 되는 방법, 중간 원소가 피벗이 되는 방법, 마지막 원소가 피벗이 되는 방법] 세 가지가 있다. 
  * 왼쪽 피벗 선택 방식이 가장 쉬우면서 기본적인 방법 
</details>
  
+) 정렬된 상태의 배열을 정렬하고자 할때는 O(n^2)으로 최악의 성능 
  
  
---  
  
  
#### +) Comparable, Comparator  
🍮 Lv3 가장 큰 수 참고  
  
- 모두 객체 비교, 정렬과 관련된 인터페이스로  
Comparable은 클래스 내부에서 정의된 순서를 활용하여 정렬하고 비교하는데 사용되며, Comparator는 외부에서 정의된 비교 기준을 활용하여 정렬하고 비교하는데 사용됨.  
=> 사용자의 목표는 두 인터페이스를 통해 객체를 비교할 수 있도록 만드는 것  

- Comparable의 경우에는 **compare(T o1, T o2)** 를, Comparator의 경우에는 **compareTo(T o)** 를 Override 해줘야함.
- Comparable은 **자기 자신과 매개변수 객체를 비교**하는 것이고, Comparator는 **두 매개변수 객체를 비교**한다

<details>
<summary>🔎Comparable</summary>
  
```  
public class ClassName implements Comparable<Type> { 
 
/*
  ...
  code
  ...
 */
 
	// 필수 구현 부분
	@Override
	public int compareTo(Type o) {
	     /*
		 비교 구현
	      */
	}
}
```
- 가령 우선순위 큐에 사용자 정의 클래스를 넣는다면 위와 같이 클래스간의 비교가 가능하게 구현해줘야함 (백준 1197 참고)
  
  ex)  
```
	class Student implements Comparable<Student> {
	 
		int age;		// 나이
		int classNumber;	// 학급
		
		Student(int age, int classNumber) {
			this.age = age;
			this.classNumber = classNumber;
		}
		
		@Override
		public int compareTo(Student o) { // 비교 구현
	    
			// 자기자신의 age가 o의 age보다 크다면 양수
			if(this.age > o.age) {
				return 1;
			}
			// 자기 자신의 age와 o의 age가 같다면 0
			else if(this.age == o.age) {
				return 0;
			}
			// 자기 자신의 age가 o의 age보다 작다면 음수
			else {
				return -1;
			}
		}
	}
```
- 자신을 기준으로 삼아 대소관계를 파악하여 return 해주도록 구현  
- 자기 자신을 기준으로 상대방과의 차이값 비교하여 반환하므로 **return this.age - o.age** 이런 식으로도 가능  
  단 이 경우에는 overflow에 주의 


- Wrapper 클래스 객체에 사용하는 경우
```
	기준값.compareTo(비교값); 
```
문자열 비교와 숫자 비교 두 가지 방식이 있음  
- **숫자 비교**의 경우 기준이 비교대상보다 크면 양수, 작으면 음수, 동일하면 0을 나타낸다.  
- **문자열 비교**의 경우 두 가지로 나뉜다  
	- 1) 기준값의 앞자리부터 일치하는 문자열이 포함된 경우 (기준 문자열 길이-비교대상 문자열 길이)를 리턴  
	- 2) 비교대상과 전혀 다른 문자열인 경우 첫 char간의 아스키코드 차이값을 리턴  
       
---
  
</details>
  
  
<details>
<summary>🔎Comparator</summary>

```
	import java.util.Comparator;	// import 필요
	public class ClassName implements Comparator<Type> { 
	 
	/*
	  ...
	  code
	  ...
	 */
	 
		// 필수 구현 부분
		@Override
		public int compare(Type o1, Type o2) {
			/*
			 비교 구현
			 */
		}
	}
```
- 매커니즘 자체는 compareTo와 비슷. 자기 자신과 비교가 되느냐 안 되느냐의 차이
  
ex)
```
	import java.util.Comparator;	// import 필요
	class Student implements Comparator<Student> {
	 
		int age;			// 나이
		int classNumber;	// 학급
		
		Student(int age, int classNumber) {
			this.age = age;
			this.classNumber = classNumber;
		}
		
		@Override
		public int compare(Student o1, Student o2) {
	    
			// o1의 학급이 o2의 학급보다 크다면 양수
			if(o1.classNumber > o2.classNumber) {
				return 1;
			}
			// o1의 학급이 o2의 학급과 같다면 0
			else if(o1.classNumber == o2.classNumber) {
				return 0;
			}
			// o1의 학급이 o2의 학급보다 작다면 음수
			else {
				return -1;
			}
		}
	}
```
- o1과 o2를 비교함에 있어 자기 자신은 두 객체 비교에 영향이 없다
- compareTo에서 했던것과 마찬가지로 **return o1.classNumber - o2.classNumber;** 로 간략하게 할 수 있음
- 마찬가지로 overflow 주의
---
</details>

* 간단하게 정리하면 두 메소드 모두 return값이 양수인 경우 순서가 바뀜. 따라서 내림차순을 하고싶다면 뺄셈 순서를 바꿔 return해주면 됨
* compareTo는 자기 자신과 매개변수 하나, compare은 해당 객체와 상관없는 매개변수 둘을 비교한다는 것이 차이
  
  
+) 자바 버전마다 다르지만 Java7 이후부터 Arrays.sort는 Quick sort를 사용하여 평균적으로 O(nlogn)의 시간복잡도를,  
  Collections.sort은 Tim Sort를 사용하여 안정적으로 O(nlogn)의 시간복잡도를 가진다
