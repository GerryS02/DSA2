#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
    int jump(vector<int>& nums){
        int j = 0;          //count of jumps we make
        int currEnd = 0;    //end of the current jump range
        int farthest = 0;   //farthest index we can reach in the next jump
        
        //from start to the last element
        for(int i=0; i<nums.size()-1; i++){
            //update the farthest index reachable from current or previous positions
            farthest = max(farthest, i + nums[i]);

            //if we reach the end of the current jump range
            if(i == currEnd){
                j++;                //make a jump
                currEnd = farthest; //update the current jump range
            }
        }

        return j;
    }
};