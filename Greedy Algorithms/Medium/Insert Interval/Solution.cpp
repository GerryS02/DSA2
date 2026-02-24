#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval){
        int n = intervals.size();
        int i = 0;      //pointer to iterate through intervals

        vector<vector<int>> ans;

        //add all intervals that end before newInterval starts -> these intervals do not overlap
        while(i<n && intervals[i][1] < newInterval[0]){
            ans.push_back(intervals[i]);

            i++;
        }

        //merge all overlapping intervals with newInterval -> if intervals overlap, update newInterval boundaries
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = min(intervals[i][0], newInterval[0]);  //update start
            newInterval[1] = max(intervals[i][1], newInterval[1]);  //update end

            i++;
        }

        ans.push_back(newInterval);     //after merging, add the updated newInterval

        //add remaining intervals (those after newInterval) -> these also do not overlap
        while(i<n){
            ans.push_back(intervals[i]);
        }

        return ans;
    }
};