package main;

import model.Pion;
import utilitaires.Move;
import utilitaires.SetupPlateau;
import utilitaires.Utilitaires;

import java.util.ArrayList;

public class Game {

    char[][] plateau = new char[12][12];
    ArrayList<Pion> allPion = new ArrayList<Pion>();

    public void run() {
        setup();
        int ch = 6;
        Move.MovePion(ch, plateau, allPion);
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
                allPion.add(new Pion('w', x, y));

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
