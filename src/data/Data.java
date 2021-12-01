package data;

import model.Coordinate;

public class Data {
    String fileName;
    Coordinate coo;
    Coordinate nextCoo;

    public Coordinate getCoo() {
        return coo;
    }

    public void setCoo(Coordinate coo) {
        this.coo = coo;
    }

    public Coordinate getNextCoo() {
        return nextCoo;
    }

    public void setNextCoo(Coordinate nextCoo) {
        this.nextCoo = nextCoo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
