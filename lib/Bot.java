public class Bot extends Board{
    public static int random(Board botBoard){
        int random = (int) Math.floor(Math.random() * botBoard.possiblemoves().size()); //return a random index withing range of possible moves
        return botBoard.possiblemoves().get(random);
    }

    public static int oneAhead(Board botBoard){
        int move = random(botBoard);
    
        for(int i = 0; i < botBoard.possiblemoves().size(); i++){
            Board copyBoard = new Board();
            copyBoard.setBoard(botBoard.getBoard()); 
            copyBoard.printBoard();
            copyBoard.move(copyBoard.possiblemoves().get(i));
            if(copyBoard.checkWinner() == "O"){
                move = i;
                break; 
            }
        }
        
        return move;
    }
    return move;


}
}
