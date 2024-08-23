    import java.util.Scanner;
public class Tictac {




    public char[][] grid;
    
    public char activePlayer;

    public Tictac(){
        
        grid = new char[3][3];
        activePlayer = 'X';
        setupGrid();
        
    }

    public void setupGrid(){
        
        for (int i = 0; i < 3; i++){
            
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '-';
            }
            
        }
    }

    public void displayGrid(){
        
        System.out.println("-------------");
        
        for (int i = 0; i < 3; i++){
            
            
            System.out.print("| ");
            
            for (int j = 0; j < 3; j++){
                
                
                System.out.print(grid[i][j] + " | ");
                
            }
            
            
            System.out.println();
            System.out.println("-------------");
        }
    }

    public void startGame(){
        
        boolean hasWinner = false;
        boolean isDraw = false;

        while(!hasWinner && !isDraw){
            
            displayGrid();
            playerTurn();
            hasWinner = verifyWinner();
            
            if(!hasWinner){
                
                isDraw = verifyDraw();
                
                if(!isDraw){
                    
                    switchPlayer();
                    
                }
            }
        }

        displayGrid();
        
        if (hasWinner){
            
            System.out.println("Congratulations! t0 Player " + activePlayer + " is a champion");
            
        } else if (isDraw){
            
            System.out.println("Game ends as DRAW.");
            
        }
        
        
    }

    public void playerTurn(){
        
        Scanner input = new Scanner(System.in);
        
        int x, y;

        while(true){
            
            System.out.println("Player " + activePlayer + ", enter your move (row [1-3] and column [1-3]): ");
            x = input.nextInt() - 1;
            y = input.nextInt() - 1;

            if (x >= 0 && y >= 0 && x < 3 && y < 3 && grid[x][y] == '-'){
                
                grid[x][y] = activePlayer;
                
                break;
                
            } else {
                
                System.out.println("Invalid move, try again.");
            }
        }
    }

    public boolean verifyWinner() {
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0] == activePlayer && grid[i][1] == activePlayer && grid[i][2] == activePlayer) ||
                (grid[0][i] == activePlayer && grid[1][i] == activePlayer && grid[2][i] == activePlayer)) {
                return true;
            }
        }

        if ((grid[0][0] == activePlayer && grid[1][1] == activePlayer && grid[2][2] == activePlayer) ||
            (grid[0][2] == activePlayer && grid[1][1] == activePlayer && grid[2][0] == activePlayer)) {
            return true;
        }

        return false;
    }

    public boolean verifyDraw(){
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void switchPlayer() {
        if (activePlayer == 'X') {
            activePlayer = 'O';
        } else {
            activePlayer = 'X';
        }
    }

    public static void main(String[] args) {
        
        
        Tictac xoGame = new Tictac();
        
        xoGame.startGame();
        
    }
    
    
}
