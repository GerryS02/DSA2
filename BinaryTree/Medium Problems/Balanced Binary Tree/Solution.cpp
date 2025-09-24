#include "Node.h"

class Solution{
public: 
    bool isBalanced(Node* root) {
        
        if(root == NULL){
            return true;
        }
        if(isBalanced(root->left) == false){
            return false;
        }
        if(isBalanced(root->right) == false){
            return false;
        }

        int lh = height(root->left);
        int rh = height(root->right);

        if(abs(lh - rh) <= 1){
            return true;
        }else{
            return false;
        }
    }

    int height(Node* root){
        
        if(root == NULL){
            return 0;
        }

        int lh = height(root->left);
        int rh = height(root->right);

        return max(lh, rh) + 1;
    }
};