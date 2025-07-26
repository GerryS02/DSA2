// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping 
// intervals, and return an array of the non-overlapping intervals that cover all the intervals
// in the input.

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals){
        //sort the intervals based on the start time
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        ArrayList<int[]> list = new ArrayList<>(); 

        //iterate through each interval
        for(int[] curr : intervals){
            //if the list is empty, just add the current interval
            if(list.size() == 0){
                list.add(curr);
            } else{
                //get the last interval added to the list
                int[] prev = list.get(list.size()-1);

                //if current interval overlaps with the previous one
                if(curr[0] <= prev[1]){
                    //merge the intervals by updating the end of the previous interval
                    prev[1] = Math.max(prev[1], curr[1]);
                } else{
                    //if not, just add the current interval
                    list.add(curr);
                }
            }
        }

        //convert the list of intervals back to a 2D array and return it
        return list.toArray(new int[list.size()][]);
    }
}
