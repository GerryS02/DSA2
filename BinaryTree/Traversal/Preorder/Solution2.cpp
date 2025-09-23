#include "Node.h"
#include <vector>

class Solution2{
public:
    vector<int> preorder(Node* root){
        vector<int> ans;

        if(root == NULL) return ans;

        stack<Node*> st;
        st.push(root);

        while(!st.empty()){
            Node* curr = st.top();
            st.pop();
            ans.push_back(curr->data);

            //push right first so left is processed first
            if(curr->right != NULL) st.push(curr->right);
            if(curr->left != NULL) st.push(curr->left);
        }

        return ans;
    }
};