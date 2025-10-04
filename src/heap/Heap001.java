package heap;

import java.util.*;

// 프로그래머스 - 더 맵게
public class Heap001 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }

        int answer = 0;
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }

            // 가장 맵지 않은 음식의 스코빌 지수 - 최소힙으로 간주
            int first = pq.poll();
            int second = pq.poll();
            int newScoville = first + (second * 2);

            pq.offer(newScoville);
            answer++;
        }

        return answer;
    }
}
