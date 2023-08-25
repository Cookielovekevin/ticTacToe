public class Bot extends Board{
    public int random(Board botBoard){
        int random = (int) Math.floor(Math.random() * botBoard.possiblemoves().size()); //return a random index withing range of possible moves
        return botBoard.possiblemoves().get(random);
    }

    public int oneAhead(Board botBoard){
        int move = 0;
        for(int i = 0; i < botBoard.possiblemoves().size(); i++){
            Board copyBoard = new Board(botBoard); 
            copyBoard.move(2);
            botBoard.printBoard();
            copyBoard.printBoard();
            if(copyBoard.checkWinner() == "O"){
                move = i;
                break; 
            }
        }
        
        return move;
    }

}

