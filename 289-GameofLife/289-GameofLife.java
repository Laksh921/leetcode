class Solution {
    public void gameOfLife(int[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int neighbours = countNeigbours(board, i, j);
                if(board[i][j] == 1 && (neighbours<2 || neighbours > 3)){
                    board[i][j]=-1;
                }
                if(board[i][j] == 0 && neighbours == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
    }
    private int countNeigbours(int[][] board,int row,int col){
        int[] directions = {-1,0,1};
        int Count=0;
        for(int i:directions){
            for (int j:directions){
                if(i==0 && j==0) continue;
                int r = row + i;
                int c = col + j;
                if(r>=0 && r<board.length && c>=0 && c<board[0].length && (board[r][c]==1 || board[r][c]==-1)){
                    Count++;
                }
            }
        }
        return Count;
    }
}