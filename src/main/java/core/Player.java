package core;

public class Player {
    private Integer id;
    private String name;
    private int ownMoney;
    private int betMoney;
    private boolean waited;
    private boolean passed;

    public Player(Integer id, String name, int ownMoney, int betMoney) {
        this.id = id;
        this.name = name;
        this.ownMoney = ownMoney;
        this.betMoney = betMoney;
        this.waited = false;
        this.passed = false;
    }

    public Player(Integer id, String name, int ownMoney, int betMoney, boolean waited, boolean passed) {
        this.id = id;
        this.name = name;
        this.ownMoney = ownMoney;
        this.betMoney = betMoney;
        this.waited = waited;
        this.passed = passed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwnMoney() {
        return ownMoney;
    }

    public void setOwnMoney(int ownMoney) {
        this.ownMoney = ownMoney;
    }

    public int getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(int betMoney) {
        this.betMoney = betMoney;
    }

    public boolean isWaited() {
        return waited;
    }

    public void setWaited(boolean waited) {
        this.waited = waited;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
