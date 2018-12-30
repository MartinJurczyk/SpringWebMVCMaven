package pl.edu.uj.wmii.www.entity;

public class Player {
    private String name;
    private int winCount;
    private int looseCount;
    private int drawCount;

    public Player(String name) {
        this.name = name;
        this.winCount = 0;
        this.looseCount = 0;
        this.drawCount = 0;
    }

    public void win() {
        winCount++;
    }

    public void loose() {
        looseCount++;
    }

    public void draw() {
        drawCount++;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", winCount=" + winCount +
                ", looseCount=" + looseCount +
                ", drawCount=" + drawCount +
                '}';
    }
}
