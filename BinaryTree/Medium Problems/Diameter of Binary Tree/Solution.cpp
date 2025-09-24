#include "Node.h"

class Soltuion{
public:
    int diameterOfBinaryTree(Node* root){
        if(root == NULL) return 0;

        int leftDiam = diameterOfBinaryTree(root->left);
        int rightDiam = diameterOfBinaryTree(root->right);

        int currDiam = height(root->left) + height(root->right);

        return max(currDiam, max(leftDiam, rightDiam));
    }

    int int height(Node* root){
        if(root == NULL) return 0;

        int lh = height(root->left);
        int rh = height(root->right);

        return max(lh, rh) +1;
    }
};