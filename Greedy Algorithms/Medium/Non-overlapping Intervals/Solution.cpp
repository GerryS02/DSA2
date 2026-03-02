#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution{
public:
    bool static compare(vector<int>& a, vector<int>& b){
        return a[1] < b[1];
    }

    int eraseOverlapIntervals(vector<vector<int>>& intervals){
        sort(intervals.begin(), intervals.end(), compare);

        int n = intervals.size();
        int take = 1;
        int end = intervals[0][1];

        for(int i=0; i<n; i++){

            if(intervals[i][0] >= end){
                take++;
                end = intervals[i][1];
            }
        }
        
        return n-take;
    }
};