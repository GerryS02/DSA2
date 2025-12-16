#include "Node.h"

class Solution{
public:
    bool isSymmetric(Node* root){
        if(root == NULL) return true;

        return isMirror(root->left, root->right);
    }

    bool isMirror(Node* left, Node* right){
        if(left == NULL && right == NULL) return true;
        if(left == NULL || right == NULL) return false;

        return (left->data == right->data) && isMirror(left->left, right->right) 
                && isMirror(left->right, right->left);
    }
}