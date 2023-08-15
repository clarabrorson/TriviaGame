/**
 * @autor: David
 */

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Question {

    private String question;
    private String correctAnswer;

    public Question(String question, String correctAnswer){
        this.question = question;
        this.correctAnswer = correctAnswer;

    }
    public String getQuestion(){
        return question;
    }
    public String getCorrectAnswer(){
        return correctAnswer;
    }

    public static Question fromJson(String json){
        JSONObject jsonObject = new JSONObject(json); // Skapar en JSON-objekt från en JSON-sträng

        JSONArray results = jsonObject.getJSONArray("results"); // Hämtar en array av resultat från JSON-objektet
        JSONObject firstQuestion = results.getJSONObject(0); // Hämtar det första frågeobjektet från resultatarrayen
        String apiQuestion = firstQuestion.getString("question"); // Hämtar frågetexten från frågeobjektet
        String apiCorrectAnswer = firstQuestion.getString("correct_answer"); // Hämtar det korrekta svaret från frågeobjektet
        apiQuestion=decodeHtmlEntities(apiQuestion); // Avkodar HTML-entiteter i frågetexten


        return new Question(apiQuestion, apiCorrectAnswer);

    }
    public static String decodeHtmlEntities(String input) {
        return input
                .replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">")
                .replace("&quot;", "\"")
                .replace("&#039;", "'");

        //target ersätts med replacement
    }
    }




