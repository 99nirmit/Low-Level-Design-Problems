package domain;

public class TicTacToe {

    private int[][] board;
    private int[] rowSum;
    private int[] colSum;
    private int diagSum;
    private int revDiagSum;
    private int n;
    private int winner;

    public TicTacToe(int n){
        this.n = n;
        board = new int[n][n];
        rowSum = new int[n];
        colSum = new int[n];
        diagSum = 0;
        revDiagSum = 0;
        winner = 0;
    }

    public int move(int player, int row, int col) throws IllegalArgumentException{

        if(row < 0 || col < 0 || row >= n || col >= n){
            throw new IllegalArgumentException("Move Out of board boundary");
        }
        if(board[row][col] != 0){
            throw new IllegalArgumentException("Square is already occupied");
        }
        if(player != 1 && player != 2){
            throw new IllegalArgumentException("Invalid Player");
        }
        if(winner != 0){
            throw new IllegalArgumentException("Game Already has a winner");
        }

        int currentPlayer = player == 1 ? 1 : -1;
        board[row][col] = currentPlayer;
        rowSum[row] += currentPlayer;
        colSum[col] += currentPlayer;

        if(row == col){
            diagSum += currentPlayer;
        }
        if(row == n-1-col){
            revDiagSum += currentPlayer;
        }
        if(Math.abs(rowSum[row] ) == n || Math.abs(rowSum[col]) == n || Math.abs(diagSum) == n || Math.abs(revDiagSum) == n){
            winner = player;
        }
        return getWinner();
    }

    public int getWinner(){
        return winner;
    }

    public void printBoard(){
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                System.out.println(board[i][j] == 1 ? "X" : board[i][j] == -1 ? "O" : ".");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
