package heap;

import java.util.*;

// 2번째 반복
// 시간: O(n log n), 공간: O(n)
public class Heap001_2 {
    public int solution(int[] scoville, int K) {
        // 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 큐에 스코빌 지수 담기
        for (int s : scoville) {
            pq.offer(s);
        }

        // answer 변수 선언
        // 스코빌 지수가 K 이상이 될 때까지 반복
        int answer = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + second * 2);
            answer++;
        }

        return pq.peek() >= K ? answer : -1;
    }
}
