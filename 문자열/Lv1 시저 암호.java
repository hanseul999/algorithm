/*
    프로그래머스 Lv1 시저 암호
 */



class Main {

    public static void main(String[] args) {
        //문제 입력 예제
        String s = "A  B";  // -> B  C 공백이 두개 이상일수도 있음
        int n = 1;
        //

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {  // 공백의 경우 그대로 추가
                sb.append(c);
                continue;
            }

            if (Character.isLowerCase(c)) {  // 소문자
                c = (char) ((c - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(c)) {  // 대문자
                c = (char) ((c - 'A' + n) % 26 + 'A');
            }

            sb.append(c);
        }
        String answer = String.valueOf(sb);
        System.out.println(answer);
    }
}