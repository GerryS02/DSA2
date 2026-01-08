#include "Node.h"
#include <vector>
#include <queue>
#include <map>
using namespace std;

class Solution{
public:
    vector<int> bottomView(Node* root){
        vector<int> ans;

        if(root == NULL) return ans;

        queue<pair<Node*, int>> q;
        q.push({root, 0});

        map<int, int> m;  //{horizontal distance, node}

        while(!q.empty()){
            Node* curr = q.front().first;
            int currHd = q.front().second;
            q.pop();

            m[currHd] = curr->data;

            if(curr->left){
                q.push({curr->left, currHd-1});
            }

            if(curr->right){
                q.push({curr->right, currHd+1});
            }
        }

        for(auto it : m){
            ans.push_back(it.second);
        }

        return ans;
    }
}
