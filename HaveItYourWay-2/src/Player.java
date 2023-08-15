/**
 * @author Clara Brorson
 */
public class Player {
    /**
     * Definierar variabler
     */
    String name;
    int points;

    /**
     * Skapar en instans av Player
     * @param name spelarens namn
     * @param points spelarens poäng
     */
    public Player(String name, int points){
        this.name = name;
        this.points = points;
    }

    /** Getters och setters för variablerna
     *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints()
    {
        points++;
    }
    /**
     * reset metod för att återställa poängen
     */
    public void reset() {
        points = 0;
    }
    /**
     * toString metod för att skriva ut spelarens namn och poäng
     * @return spelarens namn och poäng
     */
    public String toString() {
        return "Player: " + name + ", Points: " + points +"/ 10";
    }

}
