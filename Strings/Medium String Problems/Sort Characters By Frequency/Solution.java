import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> m = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            m.put(c, m.getOrDefault(c, 0)+1);
        }

        //priority queue (max-heap) to store the characters by frequency
        PriorityQueue<Map.Entry<Character, Integer>> pq = 
         new PriorityQueue<>((entry1, entry2) -> entry2.getValue() - entry1.getValue());

        //add all the entries (character-frequency pairs) from the map to the priority queue
        pq.addAll(m.entrySet());

        StringBuilder sb = new StringBuilder();

        //loop until pq is empty
        while(pq.size() != 0){
            //remove the entry with the highest frequency (top of the queue)
            Map.Entry<Character, Integer> entry = pq.poll();

            //append the character to the StringBuilder based on its frequency
            for(int i=0; i<entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }

        return sb.toString(); //return the StringBuilder
    }
}