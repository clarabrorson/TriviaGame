import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Hanadi snunu
 */

public class DBFacade {
    SQLite sqLite= new SQLite();

    public DBFacade() throws SQLException {
    }

    /**
     * Method of connecting to the database,
     * Call in the sqlite class for connection in the database
     */
    public void connect(){
        sqLite.connect();
    }

    /**
     * Method for closing connection to the database
     */
    public void disconnect(){
        sqLite.disconnect();
    }

    /**
     * Method of adding players to the database
     * @param player
     */
    public void insertPlayer(Player player){ //lägga till spelare i databasen
        sqLite.insertPlayer(player); //anrop
    }

    /**
     * Method to show top ten
     * @return
     */
    public ArrayList<Player> showTopTen(){
       return sqLite.showTopTen();
    }
}
