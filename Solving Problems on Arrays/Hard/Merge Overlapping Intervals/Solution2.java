// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping 
// intervals and return an array of the non-overlapping intervals that cover all the intervals
// in the input.

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals){
        //Sort the intervals based on their start times
        intervals.sort((a,b)->Integer.compare(a.get(0), b.get(0)));

        List<List<Integer>> list = new ArrayList<>();

        //loop through each interval in the sorted list
        for(List<Integer> curr : intervals){
            //iIf this is the first interval, simply add it to the list
            if(list.size() == 0){
                //make a new list to avoid reference issues
                list.add(new ArrayList<>(curr));
            } else{
                //otherwise, get the last interval added to the result list
                List<Integer> prev = list.get(list.size()-1);

                //if the current interval overlaps with the previous one, merge them by updating the end time
                if(curr.get(0) <= prev.get(1)){
                    prev.set(1, Math.max(prev.get(1), curr.get(1)));
                } else{
                    //if they don’t overlap, add the current interval as a new entry
                    list.add(new ArrayList<>(curr)); //again, create a new list to avoid reference issues
                }
            }
        }

        return list;
    }
}
