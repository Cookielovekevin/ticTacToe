import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Board testGame = new Board();
        Scanner input = new Scanner(System.in);
        System.out.println(testGame.checkWinner());
        while(testGame.checkWinner() == null){ //while there is no winner && board is NOT full
            testGame.printBoard();
            System.out.println(testGame.getTurn() + " turn.");
            System.out.println("Where would you like to go?: ");
            int move = input.nextInt();
            if(testGame.checkValid(move)){
                testGame.Move(move);;
            }
            else
                System.out.println("Invalid input");
            
        }
        input.close();

        testGame.printBoard();
        if(testGame.checkWinner() == "X" || testGame.checkWinner() == "O"){
            System.out.println("The winner is " + testGame.checkWinner());
        }
        else
            System.out.println("Draw");
        //check terminal for inputs scanner open until game is done!
    }
}
