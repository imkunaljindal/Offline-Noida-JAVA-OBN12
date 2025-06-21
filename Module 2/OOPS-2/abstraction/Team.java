package abstraction;

public abstract class Team {

    int getNumberOfPlayers() {
        return 11;
    }

    abstract String getCaptain();

    abstract int getRank();
}
