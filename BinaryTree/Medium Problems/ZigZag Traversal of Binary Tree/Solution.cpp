#include "Node.h"
#include <Stack>
#include <vector>

class Solution{
public:
    vector<vector<int>> zigzagLevelOrder(Node* root){
        vector<vector<int>> ans;

        if(root == NULL) return ans;    //if the tree is empty, return empty result

        stack<Node*> currLevel, nextLevel;  //two stacks to store current level and next level nodes

        currLevel.push(root);   //push the root to current level stack

        bool leftToRight = true;    //direction flag
        vector<int> level;

        //continue until all levels are processed
        while(!currLevel.empty()){
            //get the top node from the current level
            Node* temp = currLevel.top();
            currLevel.pop();

            //add current node value to the level list
            level.push_back(temp->data);

            //push children into nextLevel based on direction
            if(leftToRight){

                if(temp->left) nextLevel.push(temp->left);
                if(temp->right) nextLevel.push(temp->right);
            } //right to left
            else{

                if(temp->right) nextLevel.push(temp->right);
                if(temp->left) nextLevel.push(temp->left);
            }

            //if current level is finished
            if(currLevel.empty()){
                ans.push(level);    //add this level to the answer
                level.clear();      //clear level vector for next level

                leftToRight = !leftToRight; //change traversal direction
                swap(currLevel, nextLevel); //move to the next level
            }
        }

        return ans;
    }
}

