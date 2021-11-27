package model;

public class Player {
    int nbOfPawn = 20;
    char color;

    public Player(char color) {
        this.color = color;
    }

    public int getNbOfPawn() {
        return nbOfPawn;
    }

    public void setNbOfPawn(int nbOfPawn) {
        this.nbOfPawn = nbOfPawn;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
}
