#include <iostream>
#include <vector>
using namespace std;

class Solution{
public:
//DFS function to change 'O' to '*'
    void change(vector<vector<char>>& board, int x, int y){
        board[x][y] = '*';

        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        //check all 4 directions
        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            //if the new cell is inside the board and is 'O', continue DFS from there
            if(cx>=0 && cx<board.size() && cy>=0 && cy<board[0].size() && board[cx][cy] == 'O'){
                change(board, cx, cy);
            }
        }
    }

    void solve(vector<vector<char>>& board){
        int n = board.size();
        int m = board[0].size();

        //run DFS from all border cells that contain 'O' and change those to '*'
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    //check if the cell is on the border
                    if(board[i][j] == 'O'){
                        change(board, i, j);
                    }
                }
            }
        }

        //convert all remaining 'O's to 'X'
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        //convert '*' back to 'O'
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }
};