package schedular;

public class Game {
    private String gameName;
    private int noOfPlayers;

    public Game() {
    }

    public Game(String gameName, int noOfPlayers) {
        this.gameName = gameName;         // Fixed assignment
        this.noOfPlayers = noOfPlayers;   // Fixed assignment
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getNoOfPlayers() {
        return noOfPlayers;
    }

    public void setNoOfPlayers(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game g = (Game) o;
        return gameName != null && gameName.equals(g.gameName);
    }

    @Override
    public int hashCode() {
        return gameName != null ? gameName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return this.gameName;
    }
}