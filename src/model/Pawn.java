package model;

public class Pawn {
    char color;
    int x,y;

    public Pawn(char color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public boolean canTakePawn(){


        return false;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
