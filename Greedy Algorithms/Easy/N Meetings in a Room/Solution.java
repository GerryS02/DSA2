import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int maxMeetings(int[] start, int[] end){
        ArrayList<int[]> m = new ArrayList<>();

        for(int i=0; i<start.length; i++){
            m.add(new int[]{start[i], end[i]});
        }

        Collections.sort(m, (x,y) -> x[1]-y[1]);

        int n = 1;
        int freeTime = m.get(0)[1];

        for(int i=1; i<start.length; i++){

            if(m.get(i)[0] > freeTime){
                n++;
                freeTime = m.get(i)[1];
            }
        }

        return n;
    }    
}
