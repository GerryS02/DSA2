#include "Node.h"

class Solution{
public:
    vector<int> rightView(Node* root){
        if(root == NULL) return {};

        vector<int> ans;

        queue<Node*> q;
        q.push(root);

        while(!q.empty()){
            int size = q.size();

            for(int i=0; i<size(); i++){
                Node* curr = q.front();
                q.pop();

                if(i==0) ans.push_back(curr->data);

                if(curr->right != NULL) q.push(curr->right);
                if(curr->left != NULL) q.push(curr->left);
            }
        }

        return ans;
    }
}