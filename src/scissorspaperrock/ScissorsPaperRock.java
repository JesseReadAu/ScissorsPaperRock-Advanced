package scissorspaperrock;

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class ScissorsPaperRock {

    /**
    *
    * @author ${user}
    */
    static int playerChoice = 0;
    static int computerChoice = 0;
    static boolean isGameRunning = true;
    //Wins {Player, Computer, Tie}
    static int[] results = {0,0,0};
        
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        
        boolean validSelection = false;
        boolean showResult = false;
        
        while(isGameRunning)
        {
        //Display title and game information to the player
        System.out.println(Title("Scissors - Paper - Rock"));
        
        if(showResult)
        {
            CheckForWinner();
        }
        
        String resultsString = "Wins: " + results[0] + " -  Loses: " + results[1] + " - Ties: " + results[2];
        System.out.println(resultsString + "\n" + TitleToDash(resultsString));
        
        
        computerChoice = rand.nextInt(3);
        
        // Make the player select a valid game choice 0-2 or exit 9
        while(!validSelection)
        {
            boolean validInput = true;
            System.out.println("Choose one of the following numbers:\n0. Scissors\n1. Paper\n2. Rock\n9. Exit\n");
            System.out.print("Player's choice: ");
            try{
                playerChoice = scan.nextInt();           
            }
            catch(InputMismatchException e)
            {
                validInput = false;
                scan.next();
            }
            if(validInput)
            {
                if(playerChoice == 9)
                    System.exit(0);
                else if(playerChoice > 2 || playerChoice < 0)
                    System.out.println("Invalid number selected. Please choose 0, 1 or 2.\n");
                else
                    validSelection = true;
            }
        }
        
		//Shows results after game has run once.
        showResult = true;


        /* Remove comment to verify game results
            DebugGameResults();
        */
        
        //Reset Game
        validSelection = false;
        System.out.println("\n\n");
        }
    }
    
	//Display if someone has won, add result
	//Use logic to determine the winner. Logic is based on the lower int wins when two ints are next to each other. Wrappers around to 0.
    private static void CheckForWinner()
    {
        if(computerChoice == playerChoice)
        {
            System.out.println("Both players have tied!");
            results[2]++;
        }
        
        if((playerChoice + 1) % 3 == computerChoice)
        {
            System.out.println("The player has won!");
            results[0]++;
        }
        
        if((computerChoice + 1) % 3 == playerChoice)
        {
            System.out.println("The computer has won!");
            results[1]++;
        }
    }
    
	//Debug - Game Results
    private static void DebugGameResults()
    {
        System.out.println("*** Debug ***");
        System.out.println("Player Selected: " + playerChoice + " - Computer selected: " + computerChoice);
    }
    
	// Calculate Dashes to add under a title
    private static String TitleToDash(String title)
    {
        String result = "";
        char[] charArr = new char[title.length()];
        for(char a : charArr)
        {
            result += "-";
        }
        return result;
    }
    
	// String with title with dashes under it
    private static String Title(String input)
    {
        return input + "\n" + TitleToDash(input);
    }
}
