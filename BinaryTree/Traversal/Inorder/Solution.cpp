#include <vector>
#include <Node.h>

//left, root, right
class Solution{
public:
    vector<int> inorderTraversal(Node* root){
        vector<int> ans;

        inorder(root, ans);

        return ans;
    }

    void inorder(Node* root, vector<int>& ans){
        if(root == NULL) return NULL;

        inorder(root->left, ans);
        ans.push_back(root->data);

        inorder(root->right, ans);
    }
};