import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        int size = clothes.length;
        Map<String, Integer> types = new HashMap<>();
        for (int i = 0; i < size; i++){
            String cloth = clothes[i][1];
            if (!types.containsKey(cloth)) types.put(cloth, 1);
            else types.put(cloth, types.get(cloth) + 1);
        }
        
        Iterator<Integer> it = types.values().iterator();
        while (it.hasNext()){
            answer *= (it.next() + 1);
        }
        
        return answer-1;
    }
}