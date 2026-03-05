//package Greedy Algorithms.Medium.Minimum Number of Platforms Required for a Railway;

import java.util.Arrays;

class Solution {
    public int findPlatform(int[] Arrival, int[] Departure) {
        //your code goes here

        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int n = Arrival.length;
        int i = 0 ;
        int j = 0;
        int maxTrains = 0;
        int platforms = 0;

        while(i < n && j < n){
            if(Arrival[i] <= Departure[j]){
                maxTrains++;
                i++;
            } else{
                maxTrains--;
                j++;
            }

            platforms = Math.max(platforms, maxTrains);
        }

        return platforms;
    }
}
