import java.util.Arrays;

public class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int lo = 1; //min force b/w 2 balls can be 1
        int hi = position[n-1] - position[0]; //max force b/w 2 balls can be difference of largest n smallest values from the array

        int ans = 0;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            //if it's possible to place m balls, with mid min force
            if(isPossible(position, m, mid)){
                ans = mid;  //store mid force as ans
                lo = mid+1; //try another max value
            } else{
                hi = mid-1;
            }
        }

        return ans;
    }

    public boolean isPossible(int[] position, int m, int force){
        int prev = position[0]; //we placed first ball on the position 1

        int count = 1; // we placed 1 ball alredy

        for(int i=1; i<position.length; i++){
            int curr = position[i]; //curr position of the ball

            //if the min force between 2 balls is greater than mid force
            if(curr-prev >= force){
                count++;    //place that ball there
                prev = curr; // update to check for the next ball
            }

            if(count == m){
                break;
            }
        }

        return count == m;  //return if we can place m balls with the given mid force
    }
}
