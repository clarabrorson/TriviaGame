/**
 * @author Clara Brorson
 */
public class APIFacade {

    /**
     * Skapar en instans av API
     */
    API api = new API();
    /**
     * Skapar en instans av Question
     */
    Question question;

    String difficultyAsString;
    String type="boolean";

    /**
     * Hämtar en fråga från API och skapar en instans av Question
     * @param category kategorin som användaren valt
     * @param difficulty svårighetsgraden som användaren valt

     *
     */
    public void sendQuery(int category, int difficulty) {


        switch (category) {
            case 1 : // Movies
                category=11;
                break;
            case 2: // Geography
                category=22;
                break;
            case 3:// Video Games
                category=15;
                break;
            case 4: // Mathematics
                category=19;
                break;
            case 5:
                category=20;
                break;
            default:
                System.out.println("Invalid input");

        }
        switch (difficulty) {
            case 1:
                difficultyAsString = "easy";
                break;
            case 2:
                difficultyAsString = "medium";
                break;
            case 3:
                difficultyAsString = "hard";
                break;
            default:
                System.out.println("Invalid input");
        }


        /**
         * Anropar getQuestionFromAPI i API.java och skickar med category, difficulty och type.
         */
        question = api.getQuestionFromAPI(category,difficultyAsString,type);

    }

    /**
     * Hämtar frågan från Question.java
     * @return frågan
     */
    public String getAnswer() {

        return question.getCorrectAnswer();
    }
    /**
     * Hämtar svaret från Question.java
     * @return svaret
     */
    public String getQuestion() {

        return question.getQuestion();
    }
}






