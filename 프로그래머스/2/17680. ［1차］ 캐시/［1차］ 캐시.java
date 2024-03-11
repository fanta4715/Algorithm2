import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        for (int i=0; i<cities.length; i++) {
            //캐시에 존재하는 경우 -> queue갱신해줌
            if (set.contains(cities[i].toLowerCase())) {
                answer++;  
                
                //queue갱신 
                //1. linkedList를 순회하면서, 해당 값을 찾고 삭제한다.
                //2. queue에 다시 해당 값을 넣어준다.
                for (int j=0; j<cacheSize; j++) {
                    if (((LinkedList<String>)queue).get(j).equals(cities[i].toLowerCase())) {
                        ((LinkedList<String>) queue).remove(j);
                        break;
                    }
                }
                queue.add(cities[i].toLowerCase());
            } 
            
            //캐시에 존재하지 않고, 캐시에 공간이 있는경우 -> 캐시에 집어넣음
            //캐시에 존재하지 않고, 캐시에 공간이 없는경우 -> queue.poll()하고 해당 String을 Set에서 삭제후 새로운 key넣음
            else {
                answer+=5;
                if (set.size() < cacheSize) {
                    queue.add(cities[i].toLowerCase());
                    set.add(cities[i].toLowerCase());
                }
                else {
                    if (cacheSize == 0) continue;
                    String key = queue.poll();
                    set.remove(key);
                    
                    queue.add(cities[i].toLowerCase());
                    set.add(cities[i].toLowerCase());
                }
            }
            
        }
        return answer;
    }
    
}