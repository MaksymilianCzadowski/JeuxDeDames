package main;

import model.Coordinate;
import model.Pawn;
import model.Player;
import utilitaires.move.Move;
import utilitaires.takePawn.TakePawn;
import utilitaires.SetupPlateau;
import utilitaires.Utilitaires;

import java.util.ArrayList;

public class Game {

    Player p1 = new Player('b');
    Player p2 = new Player('n');
    char[][] plateau = new char[12][12];
    ArrayList<Pawn> allPawn = new ArrayList<Pawn>();
    Coordinate pionTomove = new Coordinate();
    char turnTo = 'b';
    int turn = 1;
    boolean gameOn = true;

    public void run() {
        setup();
        do {
            newTurn();
            //if(TakePawn.HaveToTakePawn(plateau, turnTo, allPawn)){
              //  System.out.println("Menace pour :" + turnTo);
            //}
            Move.MovePion(pionTomove, plateau, allPawn, turnTo);
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
        SetupPlateau.addPionToPlateau(allPawn, plateau);
        Utilitaires.printPlateau(plateau);
    }

    private void createPion() {
        int x = 2,y = 1;
        for(int i = 1; i < 41; ++i){
            if(i < 21){
                allPawn.add(new Pawn('b', x, y));

            }
            else{
                allPawn.add(new Pawn('n', x, y));

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
