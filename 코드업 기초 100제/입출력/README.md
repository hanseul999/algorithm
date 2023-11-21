  
#### System.out.println() / System.out.printf()  
println은 줄바꿈 자동  
printf는 포맷 문자열(format string)을 사용하여 출력을 처리해줌.  
format string : 출력할 값의 형식을 지정하고 이를 나타내는 인수를 지정하는 방식  
  
자바에서도 C에서 했던 것처럼 출력할 수 있구나~..  
  
+) format 문자열에서 %0Nd << 해당 정수값이 N자리보다 작으면 앞에 0을 채워넣음  
  
---
     
#### StringTokenizer  
문자열 분리시 사용하면 좋은 클래스  
1. StringTokenizer st = new StringTokenizer(문자열); << 띄어쓰기를 기준으로 문자열 분리  
2. StringTokenizer st = new StringTokenizer(문자열, 구분자); << 구분자를 기준으로 문자열 분리  
3. StringTokenizer st = new StringTokenizer(문자열, 구분자, true or false); << 구분자를 기준으로 문자열을 분리하고, true/false에 따라 구분자를 토큰에 포함시키거나 포함시키지 않음.(별도의 토큰으로 분류되는 거임) 디폴트는 false
  
그리고 nextToken()으로 꺼내쓰면 됨  
  
---
   
#### split()  
split()는 주어진 정규 표현식 또는 문자열로 String을 분할함. 따라서 "." 을 기준으로 분할할 경우 split("\\\\.")와 같이 이스케이프 문자를 함께 사용하여 의도하지 않은 결과가 나오는 것을 방지하는 것이 좋음.
    
+) "\\\\." 에서 역슬래시를 하나가 아닌 두 개를 사용하는 이유  
일단 split는 정확히는 정규 표현식을 기반으로 String을 분할함.  
 . 는 정규표현식에서 특별한 의미를 갖는 meta character이므로 이를 리터럴 문자로 사용하기 위해 . 을 이스케이프 시켜야함.  
근데 \도 메타문자라 \를 이스케이프 시켜줘야함  
하여 결론적으로 \\\\. 와 같은 형태를 사용하는 것 
  
---
   
#### next() / nextLine()  
둘 다 Scanner 클래스의 메소드로,  
next()는 공백(space) 전까지 입력받은 문자열을 반환,  
nextLine()은 Enter 전까지 입력받은 문자열 모두를 반환함  
  
---
   
#### StringBuilder  
String 객체는 immutable 객체이기 때문에 한 번 생기면 수정되지 않음  
따라서 String 객체끼리 더하면 새로운 String 객체를 생성하기 때문에 덧셈 연산이 많은 상황에선 성능상 부정적인 영향을 줌  
이럴때 쓰는게 **StringBuilder**로 문자열을 mutable 객체로 다룰 수 있는 클래스임.  
연결시 append()사용  
```
StringBuilder stringBuilder = new StringBuilder();
stringBuilder.append("문자열 ").append("연결");
```
  
+) **StringBuffer**  
StringBuilder와 거의 비슷한데 동기화 여부에 차이가 있음.  
StringBuilder는 동기화를 보장하지 않는 반면 StringBuffer는 내부적으로 Synchronized 키워드를 사용하여 멀테스레드 환경에서도 동기화를 지원  
  
  
