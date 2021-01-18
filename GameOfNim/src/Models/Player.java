package Models;

public class Player {

    private String name;
    private int wins;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void addWin() {
        this.wins++;
    }
}
