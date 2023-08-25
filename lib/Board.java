import java.util.ArrayList;
import java.util.List;

public class Board {
    private String[] board; 
    private String turn; 
    
    public Board(){
        board = new String[9];
        int num = 1;
        for(int i=0; i<9; i++){
            this.board[i] = Integer.toString(num);
            num++; 
        }
        this.turn = "X";
    }
    public Board(Board copyBoard){
        this.board = copyBoard.board;
        this.turn = copyBoard.turn;
    }

    public String getTurn(){
        return this.turn;
    }
    public void setTurn(String turn){
        if(turn.equals("X") || turn.equals("O")){
            this.turn = turn;
        }
    }
    public String[] getBoard(){
        return this.board;
    }
    public void setBoard(String[] board){
        this.board = board; 
    }
    public void printBoard(){
        System.out.println("=================");
        System.out.println("|| " + this.board[0] + " || " + this.board[1] + " || " + this.board[2] + " ||");
        System.out.println("|| " + this.board[3] + " || " + this.board[4] + " || " + this.board[5] + " ||");
        System.out.println("|| " + this.board[6] + " || " + this.board[7] + " || " + this.board[8] + " ||");
        System.out.println("=================");
    }

   public boolean checkValid(int wantedmove){
        if(board[wantedmove-1] == "X" || board[wantedmove-1] == "O") //if the spot on board is X or O then NOT a valid move.
            return false;
        return true;
    }

    public void move(int wantedmove){
        this.board[wantedmove - 1] = this.turn;
        if(turn == "X")
            this.turn = "O";
        else
            this.turn = "X";
    }

   public String checkWinner(){
        String line = null;
        for(int a = 0; a < 8; a++) { //only 8 combinations for win
            switch(a){
                //horizontal wins
                case 0:
                line = this.board[0] + this.board[1] + this.board[2];
                break;
                case 1: 
                line = this.board[3] + this.board[4] + this.board[5];
                break;
                case 2:
                line = this.board[6] + this.board[7] + this.board[8];
                break;
                
                // vertical wins
                case 3: 
                line = this.board[0] + this.board[3] + this.board[6];
                break;
                case 4:
                line = this.board[1] + this.board[4] + this.board[7];
                break;
                case 5: 
                line = this.board[2] + this.board[5] + this.board[8];
                break;

                // diagonal wins
                case 6: 
                line = this.board[0] + this.board[4] + this.board[8];
                break;
                case 7: 
                line = this.board[2] + this.board[4] + this.board[6];
                break;
            }
            if(line.equals("XXX"))
                return("X");
            if(line.equals("OOO"))
                return("O");
        }
        for(int a = 1; a <= 9; a++){
            if(checkValid(a)) //if valid moves are available
                break;
            else if (a==9) //every single spot is NOT a valid move even a=9 aka btm right corner 
                return("Draw");    
        }
        
        return null;
   }

   public void printWinner(){

    if(checkWinner() == "X" || checkWinner() == "O"){
        System.out.println("The winner is " + checkWinner());
    }
    else
        System.err.println("Draw");
   }

   // bot functionality 
   public List<Integer> possiblemoves(){
    List<Integer> possiblemoves = new ArrayList<Integer>();
    for(int i = 1; i < 9; i++){
        if(checkValid(i)) // if possible move than add to list
            possiblemoves.add(i);
    }
    return possiblemoves;
   }

   public int random(){
    int random = (int) Math.floor(Math.random() * this.possiblemoves().size()); //return a random index withing range of possible moves
    return this.possiblemoves().get(random);
    }

    public int oneAhead(Board copee){
        Board copyBoard = new Board(copee);
        copee.printBoard();
        copyBoard.printBoard();

        copee.move(3);
        copyBoard.move(2);

        copee.printBoard();
        copyBoard.printBoard();
        return 2;
    }
}
