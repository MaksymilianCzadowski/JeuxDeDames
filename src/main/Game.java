package main;

import model.Coordinate;
import model.Pion;
import utilitaires.Move;
import utilitaires.SetupPlateau;
import utilitaires.Utilitaires;

import java.util.ArrayList;

public class Game {

    char[][] plateau = new char[12][12];
    ArrayList<Pion> allPion = new ArrayList<Pion>();
    Coordinate pionTomove = new Coordinate();
    char turnTo = 'b';
    int turn = 1;
    boolean gameOn = true;

    public void run() {
        setup();
        do {
            newTurn();
            Move.MovePion(pionTomove, plateau, allPion, turnTo);
            Utilitaires.printPlateau(plateau);

        }while (gameOn);
    }

    private void newTurn() {
        turn+=1;
        switch (turn%2){
            case 1:
                turnTo = 'n';
                break;
            case 0:
                turnTo = 'b';
                break;
        }
    }

    public void setup(){
        createPion();
        SetupPlateau.fillPlateau(plateau);
        SetupPlateau.addPionToPlateau(allPion, plateau);
        Utilitaires.printPlateau(plateau);
    }

    private void createPion() {
        int x = 2,y = 1;
        for(int i = 1; i < 41; ++i){
            if(i < 21){
                allPion.add(new Pion('b', x, y));

            }
            else{
                allPion.add(new Pion('n', x, y));

            }

            if(i%5 == 0){
                if(x == 10){
                    x = 1;
                    ++y;
                }else if(x == 9){
                    x = 2;
                    ++y;
                }
            }else
                x+=2;
            if(y == 5)
                y+=2;
        }
    }
}
