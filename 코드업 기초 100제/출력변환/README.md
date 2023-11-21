- 8진수 출력

```
System.out.printf("%o", i);
```

- 16진수 출력

```
System.out.printf("%x", i);
```

- 10진수를 n진수로 형변환

```
valueOf(String s, int radix)
```

문자열을 주어진 진법(radix)으로 해석하여 Integer 객체로 변환

  
- char형을 정수로 형변환 하면 유니코드로 암시적인 형변환이 일어남
  
char형 자체가 유니코드 값으로 표현되는 하나의 문자를 나타내기에 문자(char)를 정수로 형변환할 때는 암시적인 형변환이 일어남.

+) 유니코드 ⊃ 아스키코드