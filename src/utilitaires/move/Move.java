package utilitaires.move;

import model.Coordinate;
import model.Pion;
import utilitaires.Utilitaires;

import java.util.ArrayList;


public class Move {
    public static void MovePion(Coordinate coo, char[][] plateau, ArrayList<Pion> allPion, char turnTo) {
        boolean move = true;
        Coordinate nextCoo = new Coordinate();
        System.out.print("Coordonné du pion à bouger (ex: D 2) : ");
        Utilitaires.getChoice(coo);
        do{
            if(isPion(coo,plateau)){
                System.out.print("Où voulez vous le faire bouger : ");
                Utilitaires.getChoice(nextCoo);
                if(canMove(nextCoo, plateau, coo, turnTo)){
                    newCooOfPoin(coo,nextCoo,plateau,allPion, turnTo);
                    move = false;
                }
            }else{
                System.out.println("Les coordonnée rentrées ne correspondent pas à un pion !" +
                        "Veuillez réessayer svp.");
                Utilitaires.getChoice(coo);
            }

        }
        while (move);
    }

    private static void newCooOfPoin(Coordinate coo, Coordinate nextCoo, char[][] plateau, ArrayList<Pion> allPion, char turnTo) {
        int index = 0;
        for (Pion c : allPion) {
            ++index;
            if(index == getPionFromCoo(coo,plateau,turnTo)){
                c.setY(nextCoo.getY());
                c.setX(nextCoo.getX());
                plateau[coo.getY()][coo.getX()] = ' ';
                plateau[nextCoo.getY()][nextCoo.getX()] = c.getName();
            }
        }
    }

    private static int getPionFromCoo( Coordinate coo, char[][] plateau, char turnTo) {
        int nbPiont = 0;

        for(int i = 0; i < plateau.length; ++i){
            for(int j = 0; j < plateau.length; ++j){
                if(plateau[i][j] == turnTo){
                    ++nbPiont;
                }
            }
        }
        return nbPiont;
    }

    private static boolean canMove(Coordinate nextCoo, char[][] plateau, Coordinate coo, char turnTo) {
        char pion = plateau[coo.getY()][coo.getX()];

        if(pion == 'b'){
            if((nextCoo.getX() == coo.getX()+1 && nextCoo.getY() == coo.getY()+1)
                    || (nextCoo.getX() == coo.getX()-1 && nextCoo.getY() == coo.getY()+1)){
                if(plateau[nextCoo.getY()][nextCoo.getX()] != 'b' && plateau[nextCoo.getY()][nextCoo.getX()] != '|'
                        && plateau[nextCoo.getY()][nextCoo.getX()] != '-' && plateau[nextCoo.getY()][nextCoo.getX()] != '+'){
                    return true;
                }else
                    System.out.println("Mouvement Impossible ! réessayer svp.");
                    return false;
            }else
                return false;
        }else if(pion == 'n'){
            if((nextCoo.getX() == coo.getX()+1 && nextCoo.getY() == coo.getY()-1)
                    || (nextCoo.getX() == coo.getX()-1 && nextCoo.getY() == coo.getY()-1)){
                if(plateau[nextCoo.getY()][nextCoo.getX()] != 'n' && plateau[nextCoo.getY()][nextCoo.getX()] != '|'
                    && plateau[nextCoo.getY()][nextCoo.getX()] != '-' && plateau[nextCoo.getY()][nextCoo.getX()] != '+'){
                    return true;
                }else
                    System.out.println("Mouvement Impossible ! réessayer svp.");
                    return false;
            }else
                return false;
        }else
            return false;
    }

    public static boolean isPion(Coordinate coo, char[][] plateau){
        for(int i = 0; i < plateau.length; ++i){
            for(int j = 0; j < plateau.length; ++j){
                if(coo.getX() == j && coo.getY() == i && (plateau[i][j] == 'b' || plateau[i][j] == 'n')){
                    //System.out.println("i = " + i + " | j = " + j + " | pion = " + plateau[i][j]);
                    return true;
                }
            }
        }
        return false;
    }
}

