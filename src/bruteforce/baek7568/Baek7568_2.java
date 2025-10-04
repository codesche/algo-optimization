package bruteforce.baek7568;

import java.io.*;
import java.util.*;

// 2번째 반복
public class Baek7568_2 {

    static class Person {
        int w;
        int h;
        int rank;

        Person(int w, int h) {
            this.w = w;
            this.h = h;
            this.rank = 1;          // 기본 등수는 1위
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();         // 출력 고려

        int N = Integer.parseInt(br.readLine());        // N 입력

        // 객체 활용
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());           // 몸무게
            int h = Integer.parseInt(st.nextToken());           // 키
            list.add(new Person(w, h));
        }

        // 모든 쌍을 비교: j가 i보다 (w, h) 둘 다 크면 i의 등수가 1 증가
        for (int i = 0; i < N; i++) {
            Person a = list.get(i);

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                Person b = list.get(j);

                // 무게와 키가 다 클 경우에만 rank를 증가시킴
                if (b.w > a.w && b.h > a.h) {
                    a.rank++;
                }
            }
        }

        // 공백 출력
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i).rank);

            if (i < N - 1) {
                sb.append(" ");
            }
        }

        System.out.print(sb);
    }

}

















