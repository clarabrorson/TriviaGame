import java.util.Scanner;

/**
@author Emil Sivertsson
 */
public class Menu {

    static Scanner scanner = new Scanner(System.in);
    /**
    Prints a greeting to the user.
     */
    static void greeting() {
        System.out.println("Welcome to the Quiz Game!");
        System.out.println( "Test you knowledge of the world!");
    }

    /**
    Prints the main menu to the user.
     */
    static void  showMainMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Play Game");
        System.out.println("2. See the leaderboard");
        System.out.println("3. Quit game");
        System.out.println("Please enter a number: ");
    }

    /**
     * Prints a prompt for the user to enter their name.
     */
    static void name() {
        System.out.println("Please enter your name: ");
    }

    /**
     * Prints the category menu to the user.
     */
    static void categoryMenu() {
        System.out.println("Please choose a category: ");
        System.out.println("1. Movies");
        System.out.println("2. Geography");
        System.out.println("3. Video Games");
        System.out.println("4. Mathematics");
        System.out.println("5. Mythology");
        System.out.println("Please enter a number: ");
    }

    /**
     * Prints the difficulty menu to the user.
     */
    static void difficultyMenu() {
        System.out.println("Please choose a difficulty: ");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.println("Please enter a number: ");
    }

    /**
     * Prints a prompt for the user to enter their answer.
     */
    static void enterAnswer() {
        System.out.println("Please enter your answer: ");
        System.out.println("1 for true and 2 for false");
    }

    /**
     * Prints in case of wrong answer.
     */
    static void wrongAnswer() {
        System.out.println("Sorry, that is incorrect.");
    }

    /**
     * Prints in case of right answer.
     */
    static void correctAnswer() {
        System.out.println("That is correct!");
    }

    /**
     * Prints in case of invalid input.
     */
    static void invalidInput() {
        System.out.println("That is not a valid input.");
    }

    /**
     * Prints a goodbye to the user.
     */
    static void quit() {
        System.out.println("Thank you for playing!");
    }

    public static void leaderboard() {
        System.out.println("Leaderboard");
        System.out.println("These are the top 10 players:");
    }

    public static void pressEnter() {
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }


    public static void thankYou(String name) {
        System.out.println("Thank you for playing "+ name + "!");
    }
}

