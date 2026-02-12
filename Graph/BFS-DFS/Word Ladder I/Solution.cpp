#include <iostream>
#include <queue>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution{
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList){
        queue<pair<string, int>> q; //{current word, number of steps taken}
        q.push({beginWord, 1});     //start BFS with beginWord and step count = 1

        //store all words in a set for fast lookup
        unordered_set<string> st(wordList.begin(), wordList.end());
        st.erase(beginWord);

        while(q.size() > 0){
            //get front word and its step count
            string word = q.front().first;
            int steps = q.front().second;
            q.pop();

            //if we reached endWord, return steps
            if(word == endWord) return steps;

            //try changing each character of the word
            for(int i=0; i<word.size(); i++){
                char original = word[i];    //save original character

                //replace with letters from a to z
                for(char ch='a'; ch<='z'; ch++){
                    word[i] = ch;

                    //if new word exists in wordList set
                    if(st.find(word) != st.end()){
                        st.erase(word);             //remove it so we don't visit again
                        q.push({word, steps+1});    //push new word into queue with step+1
                    }
                }

                word[i] = original; //restore original character before moving to next position
            }

        }

        return 0;
    }    
};