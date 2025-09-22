#include <vector>
#include <cstddef>
#include <Node.h>

class Solution{
public:
    static int idx = -1;

    Node* buildTree(vector<int> preOrder){
        idx++;

        if(preOrder[idx] == -1) return NULL:

        Node* root = new Node(preOrder[idx]);
        root->left = buildTree(preOrder); //left sub tree
        root->right = buildTree(preOrder); //right sub tree

        return root;
    }
};