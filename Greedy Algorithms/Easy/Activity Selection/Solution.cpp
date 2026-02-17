#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int activitySelection(vector<int> &start, vector<int> &finish) {
        //store activities as pairs {start, finish}
        vector<pair<int, int>> a;

        for(int i=0; i<start.size(); i++){
            a.push_back({start[i], finish[i]});
        }

        //sort activities by finish time (earliest finish first)
        sort(a.begin(), a.end(), [](pair<int, int>& a, pair<int, int>& b){
            return a.second < b.second;
        });

        int take = 1;            //pick the first activity
        int end = a[0].second;  //end time of last selected activity

        //loop through remaining activities
        for(int i=1; i<start.size(); i++){

            //if activity starts after the last selected activity ends
            if(a[i].first > end){
                take++;             //take this activity
                end = a[i].second;  //update end time
            }
        }
        
        return take;
    }
};