#include "Node.h"
#include <vector>
using namespace std;

class Solution{
public:
    vector<int> boundry(Node* root){
        vector<int> ans;

        if(root == NULL) return ans;

        if(!isLeaf(root)) ans.push_back(root->data);

        addLeftBoundry(root, ans);
        addLeaves(root, ans);
        addRightBoundry(root, ans);

        return ans;
    }

    void addLeftBoundry(Node* root, vector<int> res){
        Node* curr = root->left;

        while(curr != NULL){
            if(!isLeaf(curr)){
                res.push_back(curr->data);
            }

            if(curr->left != NULL){
                curr = curr->left;
            } else{
                curr = curr->right;
            }
        }
    }

    void addLeaves(Node* root, vector<int> res){
        if(isLeaf(root)){
            res.push_back(root->data);
            return;
        }

        if(root->left != NULL) addLeaves(root->left, res);
        if(root->right != NULL) addLeaves(root->right, res);
    }

    void addRightBoundry(Node* root, vector<int> res){
        vector<int> temp;

        Node* curr = root->right;

        while(curr != NULL){
            if(!isLeaf(curr)){
                temp.push_back(curr->data);
            }

            if(curr->right != NULL){
                curr = curr->right;
            } else{
                curr = curr->left;
            }
        }

        for(int i=temp.size()-1; i>=0; i--){
            ans.push_back(temp[i]);
        }
    }

    bool isLeaf(Node* root){
        if(root->left == NULL && root->right == NULL){
            return true;
        }

        return false;
    }
}