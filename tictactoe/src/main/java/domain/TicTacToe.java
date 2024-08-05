package domain;

public class TicTacToe {

    // Encapsulation: Private variables to store the game state

    private int[][] board;
    private int[] rowSum;
    private int[] colSum;
    private int diagSum;
    private int revDiagSum;
    private int n;
    private int winner;

    // Single Responsibility Principle (SRP): Constructor initializes the game state

    public TicTacToe(int n){
        this.n = n;
        board = new int[n][n];
        rowSum = new int[n];
        colSum = new int[n];
        diagSum = 0;
        revDiagSum = 0;
        winner = 0;
    }

    // Method and variable naming: Descriptive names for clarity

    public int move(int player, int row, int col) throws IllegalArgumentException{

        // Exception Handling: Ensure valid moves

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

        // Conditional Logic and Flow Control: Update game state and check for a winner

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

    // Encapsulation: Getter method to access the winner

    public int getWinner(){
        return winner;
    }

    // Method and variable naming: Descriptive names for clarity
    // Encapsulation: Public method to interact with the game state

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
