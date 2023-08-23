import java.util.Scanner;

public class App extends Bot {
    static void playGame(Board testGame){
        Scanner input = new Scanner(System.in);
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
        input.close();
    }
    static void playEasyGame(Board testGame){ //bot picks random number
         Scanner input = new Scanner(System.in);
         testGame.printBoard();
         while(testGame.checkWinner() == null){ //while there is no winner && board is NOT full
                if(testGame.getTurn() == "O"){ //bot move if O 
                    testGame.move(random(testGame));
                    testGame.printBoard();
                }  
                else{
                    System.out.println(testGame.getTurn() + " turn.");
                    System.out.println("Where would you like to go?: "); //check terminal for inputs scanner open until game is done!  
                    int move = input.nextInt();
                    if(testGame.checkValid(move)){
                        testGame.move(move);
                    }
                    else
                        System.out.println("Invalid input");
                }
            }   
        input.close();           
    }
    static void playMediumGame(Board testGame){
        Scanner input = new Scanner(System.in);
        testGame.printBoard();
            while(testGame.checkWinner() == null){ //while there is no winner 
                if(testGame.getTurn() == "O"){ //bot move if O 
                    testGame.move(oneAhead(testGame));
                    testGame.printBoard();
                }  
                else{
                    System.out.println(testGame.getTurn() + " turn.");
                    System.out.println("Where would you like to go?: "); //check terminal for inputs scanner open until game is done!  
                    int move = input.nextInt();
                    if(testGame.checkValid(move)){
                        testGame.move(move);
                    }
                    else
                        System.out.println("Invalid input");
                }
            }   
            input.close(); 
    }
    public static void main(String[] args) throws Exception {  
        Scanner input = new Scanner(System.in);
        Board testGame = new Board();
        
        boolean pvE = true;
        boolean done = false; 
        String decision = null;
        do{ 
            System.out.println("Play with Bot? (Y/N)");
            decision = input.nextLine();
            if(decision.equals("Y"))
                pvE = false; 
            else if(decision.equals("N"))
                pvE = true;
            done = decision.equals("Y") || decision.equals("N");
            if(!done)
                System.err.println("Error");
        }
        while(!done);
       
       // actual game
        if(pvE){ //game with vs another player
            playGame(testGame);    
        }
        else{ //game with bot
            boolean valid = false; 
            do{
                System.out.println("What difficulty would you like? ");
                System.out.println("Easy");
                System.out.println("Med");
                System.out.println("Hard");
                decision = input.nextLine();
                if(decision.equals("Easy") || decision.equals("Med") || decision.equals("Hard"))
                    valid = true;
                if(!valid)
                    System.err.println("Error");
            }
            while(!valid);

            if(decision.equals("Easy")){
                playEasyGame(testGame);
            }

            else if(decision.equals("Med")){
                playMediumGame(testGame);
            }

            else if(decision.equals("Hard")){

            }
        }
        
      
        input.close(); 

// after game is over 
        testGame.printBoard();
        testGame.printWinner();
        
    }
}
