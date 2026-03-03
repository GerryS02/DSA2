#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution{
public:

    //comparator function to sort jobs in descending order of profit -> higher profit jobs should come first
    static bool compare(vector<int>& a, vector<int>& b){
        return a[2] > b[2];
    }

    vector<int> JobScheduling(vector<vector<int>>& jobs){
        // jobs = {id, deadline, profit}

        //sort jobs by profit (highest first)
        sort(jobs.begin(), jobs.end(), compare);

        //find maximum deadline
        //this tells us how many time slots we need
        int d = 0;
        for(auto j : jobs){
            d = max(d, j[1]);
        }

        //create time slots array
        //slots[i] = -1 means slot i is free
        vector<int> slots(d+1, -1);

        int countJobs = 0;   //number of jobs scheduled
        int maxProfit = 0;   //total profit

        //try to schedule each job
        for(auto j : jobs){
            int deadline = j[1];

            //try to place job in the latest possible free slot -> (so earlier slots remain free for other jobs)
            for(int i = deadline; i > 0; i--){

                // if slot is free
                if(slots[i] == -1){      
                    slots[i] = j[0];     //place job in slot
                    countJobs++;         //increase job count
                    maxProfit += j[2];   //add profit
                    break;               //move to next job
                }
            }
        }

        //return total jobs done and total profit
        return {countJobs, maxProfit};
    }
};