#include "Node.h"

class Solution{
public:
    bool isSameTree(Node* p, Node* q){
        if(p == NULL || q == NULL){
            return p == q;
        }

        bool isLeft = isSameTree(p->left, q->left);
        bool isRight = isSameTree(p->right, q->right);

        return isLeft && isRight && (p->data == q->data);
    }
};