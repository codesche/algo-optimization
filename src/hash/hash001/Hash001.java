package hash.hash001;

import java.util.*;

// 프로그래머스 - 완주하지 못한 선수
public class Hash001 {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // 참가자 명단 추가
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주자 명단을 참가자 명단에서 제외
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        // 값이 0이 아닌 선수를 출력
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }

        return "";
    }

}
