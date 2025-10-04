package bruteforce.baek7568;

import java.io.*;
import java.util.*;

// 백준 - 덩치 (14228 KB, 104 ms), 브루트포스
public class Baek7568 {

    static class Person {
        int w;
        int h;
        int rank;

        Person(int w, int h) {
            this.w = w;
            this.h = h;
            this.rank = 1;      // 기본 등수는 1
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();     // 출력 시 " " 간격 고려

        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new Person(w, h));
        }

        // 모든 쌍 비교: j가 i보다 (w, h) 둘 다 크면 i의 등수가 1 증가
        for (int i = 0; i < N; i++) {
            Person a = list.get(i);

            for (int j = 0; j < N; j++) {
                if (i == j) {       // 자기 자신 비교 케이스는 예외 처리
                    continue;
                }

                Person b = list.get(j);

                // 무게와 키가 다 클 경우에만 rank를 증가시킴
                if (b.w > a.w && b.h > a.h) {
                    a.rank++;
                }
            }
        }

        // 결과 출력 (공백으로 구분)
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i).rank);

            if (i < N - 1) {
                sb.append(" ");
            }
        }

        System.out.print(sb.toString());

    }

}
