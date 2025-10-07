package stack;

import java.io.*;
import java.util.*;

// 백준 - 오큰수
public class Baek17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            result[i] = -1;         // 초기값을 -1로 설정
        }

        for (int i = 0; i < n; i++) {
            // 현재 원소가 스택 top의 원소보다 클 때까지 pop
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            bw.write(result[i] + " ");
        }

        bw.close();
        br.close();
    }

}
