import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception { 

        
        Scanner input = new Scanner(System.in);
        Board testGame = new Board();
        
        boolean done = false; 
        String decision = null;
        do{ 
            System.out.println("Play with Bot? (Y/N)");
            decision = input.nextLine();
            done = decision.equals("Y") || decision.equals("No");
            if(!done)
                System.err.println("Error");
        }
        while(!done);
       
        if(decision.equals("Y")){ //game with BOT
            //game with bot
           while(testGame.checkWinner() == null){ //while there is no winner && board is NOT full
                testGame.printBoard();
                if(testGame.getTurn() == "O"){ //bot move if O 
                    testGame.move(testGame.randomMove());
                }  
                else{
                    System.out.println(testGame.getTurn() + " turn.");
                    System.out.println("Where would you like to go?: "); //check terminal for inputs scanner open until game is done!  
                    int move = input.nextInt();
                    if(testGame.checkValid(move)){
                        testGame.move(move);;
                    }
                    else
                        System.out.println("Invalid input");
                }              
               
    }
            //ask difficulty
            // easy = random number
            // med = tries to win one move ahead
            // hard = min_Max 

        }
        else{ //game with people
            while(testGame.checkWinner() == null){ //while there is no winner && board is NOT full
                testGame.printBoard();
                System.out.println(testGame.getTurn() + " turn.");
                System.out.println("Where would you like to go?: "); //check terminal for inputs scanner open until game is done!  
                int move = input.nextInt();
                if(testGame.checkValid(move)){
                    testGame.move(move);;
                }
                else
                    System.out.println("Invalid input");
    }
        }
      
        input.close(); 

// after game is over 
        testGame.printBoard();
        testGame.printWinner();
        
    }
}
