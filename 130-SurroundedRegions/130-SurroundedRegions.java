class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            if(!visited[i][0] && board[i][0] == 'O'){
                dfs(board, i, 0, visited);
            }
            if(!visited[i][m-1] && board[i][m-1] == 'O'){
                dfs(board, i, m-1, visited);
            }
        }
        for(int j=0; j<m; j++){
            if(!visited[0][j] && board[0][j] == 'O'){
                dfs(board, 0, j, visited);
            }
            if(!visited[n-1][j] && board[n-1][j] == 'O'){
                dfs(board, n-1, j, visited);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j, boolean[][] visited){
        if(i<0 || j< 0 || i>= board.length || j>=board[0].length || visited[i][j] || board[i][j] != 'O'){
            return;
        }
        visited[i][j] = true;
        dfs(board, i+1, j, visited);
        dfs(board, i, j+1, visited);
        dfs(board, i-1, j, visited);
        dfs(board, i, j-1, visited);
    }
}