import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Emil Sivertsson
 */
public class Application {

    Scanner scanner = new Scanner(System.in);

    DBFacade dbFacade = new DBFacade();

    APIFacade apiFacade = new APIFacade();

    Player player = new Player("", 0);

    int numberOfQuestions = 0;
    int category;
    int difficulty;

    public Application() throws SQLException {
    }

    /**
     * starts the application, and handels the main menu,
     * where the player can choose to start a new game,
     * see the leaderboard or quit the game.
     */
    public void start(){
        while(true) {
            Menu.greeting();
            Menu.showMainMenu();
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                showWrongInput();
                continue;
            }

            switch (choice) {
                case 1:
                    newGame();
                    break;
                case 2:
                    showTopTen();
                    break;
                case 3:
                    Menu.quit();
                    System.exit(0);
                    break;
                default:
                    Menu.invalidInput();
                    break;
            }
        }
    }

    /**
     * shows the Invalid input message to the user och prompts them to press enter.
     */
    public void showWrongInput() {
        Menu.invalidInput();
        Menu.pressEnter();
    }

    /**
     * show the leaderboard to the user.
     * connects to the database, and saves the top ten players into an ArrayList.
     * disconnects from the database and prints the top ten players to the user.
     */
    public void showTopTen() {
        Menu.leaderboard();
        dbFacade.connect();
        ArrayList<Player> topTen = dbFacade.showTopTen();
        dbFacade.disconnect();
        for (Player player: topTen) {
            System.out.println(player.getName() + " got " + player.getPoints() + " of 10 points");
        }
        Menu.pressEnter();
    }

    /**
     * Starts a new game, where the player first enters their name, and choose category and difficulty.
     * The player then gets a question, and enters their answer.
     * If the answer is correct, the player gets a point, and the game continues.
     * The game runs until the player has answered 10 questions.
     * the player is then added to the database.
     */
    public void newGame() {
        Menu.name();
        player.setName(scanner.nextLine());

        while (numberOfQuestions < 10) {
            selectCategory();
            selectDifficulty();
            apiFacade.sendQuery(category, difficulty);
            System.out.println(apiFacade.getQuestion());
            compareAnswer();
        }

        dbFacade.connect();
        dbFacade.insertPlayer(player);
        dbFacade.disconnect();
        Menu.thankYou(player.getName());
        Menu.pressEnter();
        reset();
    }

    /**
     * converts the players answer to a boolean, to match the answer from the API.
     * if the answer is correct, the player gets a point, and a point is added to the number of questions.
     * if the answer is wrong, the player gets no points. and a point is added to the number of questions.
     */
    public void compareAnswer() {
        int guess = 0;
        try {
            Menu.enterAnswer();
            guess = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            Menu.invalidInput();
            Menu.pressEnter();
            compareAnswer();
        }

        String playerAnswer = "";
        switch (guess) {
            case 1:
                playerAnswer = "True";
                break;
            case 2:
                playerAnswer = "False";
                break;
            default:
                Menu.invalidInput();
                compareAnswer();
                break;
        }

        if (playerAnswer.equals(apiFacade.getAnswer())) {
            Menu.correctAnswer();
            player.setPoints();
        } else {
            Menu.wrongAnswer();
        }
        numberOfQuestions++;
    }

    /**
     * Lets the player choose a category.
     * and checks if the input is valid and in range.
     */
    public void selectCategory() {
            try {
                Menu.categoryMenu();
                category = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                Menu.invalidInput();
                Menu.pressEnter();
                selectCategory();
            }
            if (category < 1 || category > 5) {
                Menu.invalidInput();
                Menu.pressEnter();
                selectCategory();
        }
    }

    /**
     * Lets the player choose a difficulty.
     * and checks if the input is valid and in range.
     */

    private void selectDifficulty() {
        try {
            Menu.difficultyMenu();
            difficulty = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            Menu.invalidInput();
            Menu.pressEnter();
            selectDifficulty();
        }
        if (difficulty > 3 || difficulty < 1) {
            Menu.invalidInput();
            Menu.pressEnter();
            selectDifficulty();
        }
    }

    /**
     * resets the number of questions, category, difficulty and the player points.
     */
    public void reset() {
        numberOfQuestions = 0;
        category = 0;
        difficulty = 0;
        player.reset();
    }
}
