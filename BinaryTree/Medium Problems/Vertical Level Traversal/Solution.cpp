#include "Node.h"
#include <vector>
#include <map>
#include <set>
#include <queue>
using namespace std;

class Solution{
public:
    vector<vector<int>> verticalTraversal(Node* root){
        vector<vector<int>> ans;
        if(root == NULL) return ans;    //if tree is empty, return empty result

        // col -> row -> node value
        map<int, map<int, multiset<int>>> m;

        // node -> {row, col}
        queue<pair<Node*, pair<int, int>>> q;
        q.push({root, {0,0}});

        while(q.size() > 0){
            auto p = q.front();
            q.pop();

            Node* node = p.first;
            int x = p.second.first;
            int y = p.second.second;

            m[y][x].insert(node->data);     //store the node value at its column and row

            if(node->left){
                q.push({node->left, {x+1, y-1}});
            }

            if(node->right){
                q.push({node->right, {x+1, y+1}});
            }
        }

        for(auto colPair : m){
            vector<int> level;
            for(auto rowPair: colPair.second){
                for(int val : rowPair.second){
                    level.push_back(val);
                }
            }

            ans.push_back(level);
        }

        return ans;
    }
}