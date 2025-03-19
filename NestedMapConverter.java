/* 
Input: {‘A’:1, ‘B.C’: 2, ‘B.D.E’: 3} 
Output: {A:1,B{C:2,D{E:3}} 
*/
import java.util.*;
public class NestedMapConverter {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A",1);
        map.put("B.C", 2);
        map.put("B.D.E", 3);

        Map<String, Object> result = findNestedMapConverter(map);
        System.out.println(result);
    }

    static Map<String, Object> findNestedMapConverter(Map<String, Integer> map){
        Map<String, Object> ans = new HashMap<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String[] words = entry.getKey().split("\\.");
            int value = entry.getValue();
            Map<String, Object> current = ans;
            for(int i = 0; i < words.length -1; i++){
                if(!current.containsKey(words[i])){
                    current.put(words[i], new HashMap<>());
                }
                current = (Map<String, Object>) current.get(words[i]);
            }
            current.put(words[words.length - 1], value);
        }
        return ans;
    }
}
