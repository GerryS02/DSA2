import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[1] - b[1]));

        int n = intervals.length;
        int take = 1;
        int end = intervals[0][1];

        for(int[] i : intervals){

            if(i[0] >= end){
                take++;
                end = i[1];
            }
        }

        return n-take;
    }
}