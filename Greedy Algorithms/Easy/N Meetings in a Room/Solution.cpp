#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution{
public:
    int maxMeetings(vector<int>& start, vector<int>& end){
        vector<pair<int, int>> meetings;
        
        //combine {start time, end time} for a meeting
        for(int i=0; i<start.size(); i++){
            meetings.push_back({start[i], end[i]});
        }

        //sort the meetings that finishes earliest
        sort(meetings.begin(), meetings.end(), [](pair<int, int>& a, pair<int, int>& b){
            return a.second < b.second;
        });

        int n = 1;                          //take the first meeting
        int freeTime = meetings[0].second;  //track when the meeting room becomes free

        //check the rest of the meetings
        for(int i=1; i<start.size(); i++){
            
            //if the next meeting starts after the room is free
            if(meetings[i].first > freeTime){
                n++;                            //we can schedule this meeting
                freeTime = meetings[i].second;  //update room's free time
            }
        }

        return n;   //return the maximum number of meetings
    }
};