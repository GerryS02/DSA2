#include <iostream>
#include <vector>
#include <unordered_set>
#include <queue>
using namespace std;

class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        queue<vector<string>> q;
        q.push({beginWord});

        //put all words into a set for fast lookup and deletion
        unordered_set<string> st(wordList.begin(), wordList.end());

        //this stores words used in the current level of BFS
        //we will remove them after the level finishes
        vector<string> usedOnLevel;
        usedOnLevel.push_back(beginWord);

        //current BFS level (based on path length)
        int level = 0;
        vector<vector<string>> ans;

        //start BFS
        while(q.size() > 0){
            
            //get the current path
            vector<string> vec = q.front();
            q.pop();

            //if we moved to a deeper level
            //(path length increased)
            if(vec.size() > level){
                level++;
                
                //remove all words used in previous level
                //this prevents revisiting them in future levels
                for(auto it : usedOnLevel){
                    st.erase(it);
                }
            }

            //get the last word in the current path
            string word = vec.back();

            // If we reached the end word
            if(word == endWord){
                
                //if this is the first shortest path found
                if(ans.size() == 0){
                    ans.push_back(vec);
                } 
                //if another path has same shortest length
                else if(ans[0].size() == vec.size()){
                    ans.push_back(vec);
                }
            }

            //try changing each character of the word
            for(int i = 0; i < word.size(); i++){
                char original = word[i];

                //try replacing with every letter from a to z
                for(char ch = 'a'; ch <= 'z'; ch++){
                    
                    word[i] = ch;

                    //if the new word exists in the set
                    if(st.count(word) > 0){
            
                        vec.push_back(word);            //add new word to current path
                        q.push(vec);                    //push new path into queue
                        usedOnLevel.push_back(word);    //mark word as used in this level
                        vec.pop_back();                 //backtrack (remove word for next transformation)
                    }
                }

                //restore original character before next position
                word[i] = original;
            }
        }

        return ans;
    }
};
