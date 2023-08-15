import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.text.StringEscapeUtils;


/**
 * @author David
 */
public class API {


    public Question getQuestionFromAPI(int category, String difficulty, String type){
        String apiUrl = "https://opentdb.com/api.php?amount=1&category=" + category +"&difficulty=" + difficulty+  "&type=" + type; // Skapar API-anropets URL med specifikationer för kategori, svårighetsgrad och typ av frågor


        StringBuffer response;  // En buffer för att lagra API-svaret


        try{
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // Sätter anslutningens HTTP-metod till GET

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Skapar en BufferedReader för att läsa API-svaret


            String inputLine;
            response = new StringBuffer(); // Skapar en StringBuffer för att lagra API-svaret
            while ((inputLine = in.readLine()) != null) { // Läser rad för rad från API-svaret och lagrar det i StringBuffer
                response.append(inputLine);
            }
            in.close();




            String jsonResponse = response.toString(); // Konverterar StringBuffer till en sträng
            String unescapedResponse = StringEscapeUtils.unescapeHtml4(jsonResponse); // Avkodar HTML-entiteter i API-svaret
            return Question.fromJson(response.toString()); // Konverterar API-svaret till en fråga genom att använda metoden fromJson i frågeklassen


        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }


    }

}












