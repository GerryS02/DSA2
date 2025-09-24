#include "Node.h"
#include <vector>

//postorder traversal using 1 stack
class solution2{
public:
    vector<int> postorder(Node* root){
        vector<int> ans;

        if(root == NULL) return ans;

        stack<Node*> st;

        Node* curr = root; //current node pointer
        Node* lastVisited = NULL: //keeps track of the last node that was visited

        while(curr != NULL || !st.empty()){
            if(curr != NULL){
                //go as left as possible, pushing all the nodes along the way
                st.push(curr);
                curr = curr->left;
            } else{
                //look at the node on top of the stack without removing it
                Node* seen = st.top();

                //if right child exists and hasn't been visited yet, move to the right child
                if(seen->right && lastVisited != seen->right){
                    curr = seen->right;
                } else{
                    //if there's no right child or it's already been visited,
                    //we can now visit this node (i.e., process it)
                    ans.push_back(seen->data);
                    lastVisited = seen; //mark this node as visited
                    st.pop(); //remove it from the stack
                }
            }
        }

        return ans;
    }
};