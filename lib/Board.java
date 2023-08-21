import java.util.ArrayList;
import java.util.List;

public class Board {
    private String[] board = new String[9]; 
    private String turn; 
    
    public Board(){
        int num = 1;
        for(int i=0; i<9; i++){
            board[i] = Integer.toString(num);
            num++; 
        }
        turn = "X";
    }

    public String getTurn(){
        return turn;
    }
    public String[] getBoard(){
        return board;
    }
    public void setBoard(){    
    }
    public void printBoard(){
        System.out.println("=================");
        System.out.println("|| " + board[0] + " || " + board[1] + " || " + board[2] + " ||");
        System.out.println("|| " + board[3] + " || " + board[4] + " || " + board[5] + " ||");
        System.out.println("|| " + board[6] + " || " + board[7] + " || " + board[8] + " ||");
        System.out.println("=================");
    }

   public boolean checkValid(int wantedmove){
        if(board[wantedmove-1] == "X" || board[wantedmove-1] == "O") //if the spot on board is X or O then NOT a valid move.
            return false;
        return true;
    }

    public void move(int wantedmove){
        board[wantedmove - 1] = turn;
        if(turn == "X")
            turn = "O";
        else
            turn = "X";
    }

   public String checkWinner(){
        String line = null;
        for(int a = 0; a < 8; a++) { //only 8 combinations for win
            switch(a){
                //horizontal wins
                case 0:
                line = board[0] + board[1] + board[2];
                break;
                case 1: 
                line = board[3] + board[4] + board[5];
                break;
                case 2:
                line = board[6] + board[7] + board[8];
                break;
                
                // vertical wins
                case 3: 
                line = board[0] + board[3] + board[6];
                break;
                case 4:
                line = board[1] + board[4] + board[7];
                break;
                case 5: 
                line = board[2] + board[5] + board[8];
                break;

                // diagonal wins
                case 6: 
                line = board[0] + board[4] + board[8];
                break;
                case 7: 
                line = board[2] + board[4] + board[6];
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

   public int randomMove(){
    int random = (int) Math.floor()Math.random() * possiblemoves().size(); //return a random index withing range of possible moves
    return possiblemoves().get(random);
   }
}
