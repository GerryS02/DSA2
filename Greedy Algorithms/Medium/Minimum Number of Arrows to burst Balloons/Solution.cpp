#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution{
public:
    int findMinArrowShots(vector<vector<int>>& points){
        //sort balloons by their ending x-coordinate (xend)
        sort(points.begin(), points.end(), [](const vector<int>& a, const vector<int>& b){
            return a[1] < b[1];
        });

        int arrow = 1;              //at least one arrow is needed
        int end = points[0][1];     //position the first arrow at the end of the first balloon

        //go through all the balloons
        for(int i=0; i<points.size(); i++){

            //if the start of the current balloon is <= current arrow position,
            //it will be burst by the same arrow, so do nothing
            if(points[i][0] <= end){
                continue;
            } 
            //if the current balloon starts after the arrow position, we need new arrow
            else{
                arrow++;
                end = points[i][1]; //shoot the new arrow at the end of the current balloon
            }
        }

        return arrow;
    }
};