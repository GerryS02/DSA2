import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[][] merge(int[][] intervals){
        //sort intervals by their start value (interval[0])
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], a[0]));

        ArrayList<int[]> list = new ArrayList<>();  //use a list to store the merged intervals

        //go through each interval
        for(int[] curr : intervals){
            //if list is empty, just add the first interval
            if(list.size() == 0){
                list.add(curr);
            } else{
                //get the last interval in the merged list
                int[] prev = list.get(list.size()-1);

                //if current interval overlaps with the last interval
                if(curr[0] <= prev[1]){
                    //merge them by updating the end of the last interval
                    prev[1] = Math.max(prev[1], curr[1]);
                } else{
                    //if it does not overlap, just add current interval to the list
                    list.add(curr);
                }
            }
        }
        
        //convert the ArrayList back to a 2D array before returning
        return list.toArray(new int[list.size()][]);
    }
    
}
