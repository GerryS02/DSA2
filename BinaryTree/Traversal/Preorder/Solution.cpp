#include <vector>
#include <Node.h>

class Solution{
public:
    vector<int> preorderTraversal(Node* root){
        vector<int> ans;

        preorder(root, ans);

        return ans;
    }

    void preorder(Node* root, vector<int>& ans){
        if(root == NULL) return;

        ans.push_back(root->data);

        preorder(root->left, ans);
        preorder(root->right, ans);
    }
};