package utilitaires;

import model.Coordinate;
import model.Pion;

import java.util.ArrayList;

public class Move {
    public static void MovePion(int ch, char[][] plateau, ArrayList<Pion> allPion) {
        if(canMove(ch,plateau,allPion)){
            System.out.println("ok");
        }
    }

    public static boolean canMove(int ch, char[][] plateau, ArrayList<Pion> allPion){
        Coordinate co = new Coordinate();
        Utilitaires.transformToCoordinate(ch, plateau, co);
        return true;
    }

}
