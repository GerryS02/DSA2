#include <vector>
#include "Node.h"

//left, right, root
class Solution{
public:
    vector<int> postorder(Node* root){
        vector<int> ans;
        postorder(root, ans);

        return ans;
    }

    void postorder(node* root, vector<int>& ans){
        if(root == NULL) return NULL;

        postorder(root->left, ans);
        postorder(root->right, ans);
        ans.push_back(root->data);
    }

};