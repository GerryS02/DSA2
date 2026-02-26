#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
    bool canJump(vector<int>& nums){
        int farthest = 0;   //tracks the farthest index we can reach so far

        //go through each index in the array
        for(int i=0; i<nums.size(); i++){
            //if current index is beyond the farthest reachable, we cannot move forward
            if(i > farthest) return false;

            //update the farthest index we can reach from here
            farthest = max(farthest, i + nums[i]);
        }

        return true;    //if we completed the loop, we can reach the last index
    }
};