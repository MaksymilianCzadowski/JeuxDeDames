package model;

public class Pion {
    char name;
    int x,y;

    public Pion(char name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
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
