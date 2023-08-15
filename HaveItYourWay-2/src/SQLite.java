import java.sql.*;
import java.util.ArrayList;

/**
 * @author Hanadi and Wakana
 */

public class SQLite {
    String dbName = "Leaderbord";
    Connection conn;
    String URL="jdbc:sqlite:" + dbName+ ".db";

    // The constructor for SQLite class calls connect() and createTable() methods.
    public SQLite() throws SQLException {
        connect();
        createTable();
    }
    /**
     * @author Hanadi snunu
     * code to connect to a database by using JDBC and
     * handles any exceptions that may occur during the connection
     * by printing an error message.
     */
    public void connect() {
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @author Hanadi snunu
     * Code to close the connection to a database and
     * handle any exceptions that may occur at closure
     * by printing an error message.
     */
    public void disconnect(){
            try {
                conn.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }


        //create a table named "PLAYERS" in the database if it does not already exist.
    public void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS PLAYERS (\n" +
                "  PLAYERID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  NAME VARCHAR(50) NOT NULL,\n" +
                "  POINTS INTEGER\n" +
                ")";
        try{
            Statement stm = conn.createStatement();
            stm.execute(sql);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //Add player's name and Points to database
    public void insertPlayer(Player player){
        String sql = "INSERT INTO PLAYERS (NAME, POINTS) VALUES (?, ?)";

        try{
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,player.getName());
            pstmt.setInt(2,player.getPoints());
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //Retrieve the top 10 players from the database.
    public ArrayList<Player> showTopTen(){
        String sql = "SELECT NAME,POINTS FROM  PLAYERS ORDER BY POINTS DESC limit 10";
        Player player = null;
        ArrayList<Player> topTen = new ArrayList<>();

        try{
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();

            while(rst.next()){
                player = new Player(
                        rst.getString("Name"),
                        rst.getInt("Points"));
                topTen.add(player);
            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return topTen;
    }


}
