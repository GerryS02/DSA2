#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

class Solution{
public:
    int findPlatform(vector<int>& Arrival, vector<int>& Departure){

        // Sort arrival and departure times to process trains in chronological order
        sort(Arrival.begin(), Arrival.end());
        sort(Departure.begin(), Departure.end());

        int n = Arrival.size();

        int i = 0;  //pointer for arrival array
        int j = 0;  //pointer for departure array

        int maxTrains = 0;   //number of trains currently at the station
        int platforms = 0;   //maximum platforms needed at any time

        //traverse both arrays
        while(i < n && j < n){

            //if next train arrives before the earliest train departs
            if(Arrival[i] <= Departure[j]){
                maxTrains++;  //one more train at the station
                i++;          //move to next arrival
            } else{
                //a train departs before the next one arrives
                maxTrains--;  //one platform becomes free
                j++;          //move to next departure
            }

            //update the maximum platforms needed
            platforms = max(platforms, maxTrains);
        }

        //return the maximum number of platforms required
        return platforms;
    }
};