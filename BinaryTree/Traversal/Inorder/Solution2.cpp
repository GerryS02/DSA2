//iterative Inorder traversal
#include <vector>
#include "Node.h"

class Solution2{
public:
    vector<int> inorder(Node* root){
        vector<int> ans;

        if(root == NULL) return ans;

        stack<Node*> st;
        Node* curr = root;

        while(!st.empty() || curr != NULL){
            //get to the leftmost node
            while(curr != NULL){
                st.push(curr);
                curr = curr->left;
            } else{
                //print the node
                curr = st.top();
                st.pop();
                ans.push_back(curr->data);

                //visit the right subtree
                curr = curr->right;
            }

        }

        return ans;
    }
};