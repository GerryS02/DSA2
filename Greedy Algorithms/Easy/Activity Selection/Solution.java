import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    int activitySelection(int[] start, int[] finish){
        //store activities as {start, finish} pairs in a list
        List<int[]> a = new ArrayList<>();
        
        for(int i=0; i<start.length; i++){
            a.add(new int[]{start[i], finish[i]});
        }

        //srt activities by finish time (earliest finish first)
        Collections.sort(a, (x,y)-> x[1]-y[1]);

        int take = 1;                   //pick the first activity
        int end = a.get(0)[1];   //end time of last selected activity

        //loop through remaining activities
        for(int i=0; i<start.length; i++){
            //if activity starts after the last selected one ends
            if(a.get(i)[0] > end){
                take++;             //take that activity
                end = a.get(i)[1];  //update the end time
            }
        }

        return take;
    }
}
