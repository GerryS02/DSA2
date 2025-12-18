#include "Node.h"

class Solution{
public:
    vector<int> leftView(Node* root){
        //if tree is empty, return empty vector
        if(root == NULL) return {};

        //queue for level order traversal (BFS)
        queue<Node*> q;
        a.push(root);

        vector<int> ans; //vector to store left view nodes

        //traverse the tree level by level
        while(!q.enpty()){
            int size = q.size(); //number of nodes at current level

            //process all nodes of current level
            for(int i=0; i<size; i++){
                //get the front node
                Node* curr = q.front();
                q.pop();

                //add the first node to ans
                if(i==0) ans.push_back(curr->data);

                //add left and right child to the queue if it exists
                if(curr->left != NULL){
                    q.push(curr->left);
                }
                if(curr->right != NULL){
                    q.push(curr->right);
                }
            }
        }

        return ans;
    }
}