class Solution {
public:
    bool check(int i, int j, int n, int m){
        if(i>=0 && j>=0 && i<n && j<m ) return true;
        return false;
    }
    bool ans = false;
    void dfs(int i, int j, int parI, int parJ, vector<vector<char>>& grid, vector<vector<char>>&vis,int n, int m, char ch){
        vis[i][j] = 1;
        int a1[] = {1,-1,0,0};
        int a2[] = {0,0,1,-1};
        for(int k=0; k<4; k++){
            int r = i + a1[k];
            int c = j + a2[k];
            if(check(r,c,n,m) && vis[r][c] && grid[r][c] == ch && r != parI && c != parJ){
                ans = true;
            }
            else if(check(r,c,n,m) && !vis[r][c] && grid[r][c] == ch){
                dfs(r,c,i,j,grid,vis,n,m,ch);
            }
            
        }
    }
    bool containsCycle(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<char>>vis(n,vector<char>(m,0));
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j]){
                    dfs(i,j,-1,-1,grid,vis,n,m,grid[i][j]);
                }
            }
        }
        return ans;
    }
};
