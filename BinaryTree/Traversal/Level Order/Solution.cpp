#include "Node.h"
#include <queue>

class Node{
public:
    vector<vector<int>> levelOrder(Node* root){
        vector<vector<int>> ans;

        queue<Node*> q;
        q.push(root);

        while(!q.empty()){
            int levelSize = q.size(); //number of nodes at current level
            vector<int> level; //values at this level;

            for(int i=0; i<levelSize; i++){
                Node* curr = q.front();
                q.pop();
                level.push_back(curr->data);

                if(curr->left != NULL){
                    q.push(curr->left);
                }
                if(curr->right != NULL){
                    q.push(curr->right);
                }
            }

            ans.push_back(level);
        }

        return ans;
    }
};