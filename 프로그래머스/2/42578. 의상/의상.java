import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        int size = clothes.length;
        Map<String, Integer> types = new HashMap<>();
        List<String> type = new ArrayList<>();
        for (int i = 0; i < size; i++){
            String cloth = clothes[i][1];
            if (!types.containsKey(cloth)) types.put(cloth, 1);
            else types.put(cloth, types.get(cloth) + 1);
            
            if (!type.contains(cloth)) type.add(cloth);
        }
        
        if (type.size() != 0) answer = 1;
        
        for (String tmp : type){
            answer *= (types.get(tmp) + 1);
        }
        
        return answer-1;
    }
}