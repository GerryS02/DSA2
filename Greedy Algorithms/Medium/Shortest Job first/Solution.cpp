#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution{
public:
    long long solve(vector<int>& bt){
        sort(bt.begin(), bt.end());

        int time = 0;
        int waitTime = 0;

        for(int i=0; i<bt.size(); i++){
            waitTime += time;
            time += bt[i];
        }

        return waitTime/bt.size();
    }
};