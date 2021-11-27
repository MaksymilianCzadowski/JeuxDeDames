package utilitaires.takePawn;

import model.Coordinate;
import model.Pawn;
import model.Player;
import utilitaires.Utilitaires;
import utilitaires.move.Move;

import java.util.ArrayList;

public class TakePawn {

    public static boolean HaveToTakePawn(char[][] plateau, char turnTo, ArrayList<Pawn> allPawn) {
        char c = 65;
        if(turnTo == 'b'){
            for (Pawn pw : allPawn) {
                if(pw.getColor() == 'b'){
                    if((plateau[pw.getY() + 1][pw.getX() - 1] == 'n' && plateau[pw.getY() + 2][pw.getX() - 1] == ' ')
                            || (plateau[pw.getY() + 1][pw.getX() + 1] == 'n' && plateau[pw.getY() + 2][pw.getX() + 1] == ' ')){
                        c += pw.getX();
                        System.out.println("Le pion en " + c + " " + pw.getY() + " doit manger un pion");
                        return true;
                    }
                }
            }
        }else if(turnTo == 'n'){
            for (Pawn pw: allPawn) {
                if(pw.getColor() == 'n'){
                    if((plateau[pw.getY() - 1][pw.getX() - 1] == 'b' && plateau[pw.getY() - 2][pw.getX() - 1] == ' ')
                            || (plateau[pw.getY() - 1][pw.getX() + 1] == 'b' && plateau[pw.getY() - 2][pw.getX() + 1] == ' ')){
                        c += pw.getX();
                        System.out.println("Le pion en " + c + pw.getY() + " doit manger un pion");
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static void TakePawn(char[][] plateau, char turnTo, ArrayList<Pawn> allPawn, Player p1, Player p2) {
        boolean prise = true;
        Coordinate coo = new Coordinate();
        Coordinate nextCoo = new Coordinate();
        System.out.print("Coordoonées du piont à bouger : ");

        do {
        Utilitaires.getChoice(coo);
            if(Move.isPion(coo, plateau, turnTo)){
                System.out.print("Où voulez vous le faire bouger : ");
                Utilitaires.getChoice(nextCoo);
                if(canEatPawn(plateau, nextCoo, coo, turnTo)){
                    eatPawn(plateau, coo, nextCoo, allPawn, p1, p2, turnTo);
                    prise = false;
                }else {
                    System.out.print("Les coordonnées rentrée pour faire une prise sont incorrect !" +
                            "Veuillez réessayer svp : ");
                }
            }else{
                System.out.print("Les coordonnée rentrées ne correspondent pas à l'un de vos pions !  \n" +
                        "Veuillez réessayer svp : ");
            }

        }while (prise);
    }

    private static void eatPawn(char[][] plateau, Coordinate coo, Coordinate nextCoo, ArrayList<Pawn> allPawn, Player p1, Player p2, char turnTo) {
        Coordinate cooToDelete = new Coordinate();
        int index = 0;
        for (Pawn pw : allPawn) {
            if(pw.getY() == coo.getY() && pw.getX() == coo.getX() && pw.getColor() == 'b'){
                if(pw.getX() - nextCoo.getX() < 1){
                    plateau[pw.getY()+1][pw.getX()+1] = ' ';
                    cooToDelete.setY(pw.getY()+1);
                    cooToDelete.setX(pw.getX()+1);
                    pw.setY(nextCoo.getY());
                    pw.setX(nextCoo.getX());
                    index = findIndexToDelete(allPawn, cooToDelete, p1, p2, 'n');
                }else if(pw.getX() - nextCoo.getX() > 1){
                    plateau[pw.getY()+1][pw.getX()-1] = ' ';
                    cooToDelete.setY(pw.getY()+1);
                    cooToDelete.setX(pw.getX()-1);
                    pw.setY(nextCoo.getY());
                    pw.setX(nextCoo.getX());
                    index = findIndexToDelete(allPawn, cooToDelete, p1, p2, 'n');
                }
            }else if(pw.getY() == coo.getY() && pw.getX() == coo.getX() && pw.getColor() == 'n'){
                if(pw.getX() - nextCoo.getX() < 1){
                    plateau[pw.getY()-1][pw.getX()+1] = ' ';
                    cooToDelete.setY(pw.getY()-1);
                    cooToDelete.setX(pw.getX()+1);
                    pw.setY(nextCoo.getY());
                    pw.setX(nextCoo.getX());
                    index = findIndexToDelete(allPawn, cooToDelete, p1, p2, 'b');
                }else if(pw.getX() - nextCoo.getX() > 1){
                    plateau[pw.getY()-1][pw.getX()-1] = ' ';
                    cooToDelete.setY(pw.getY()-1);
                    cooToDelete.setX(pw.getX()-1);
                    pw.setY(nextCoo.getY());
                    pw.setX(nextCoo.getX());
                    index = findIndexToDelete(allPawn, cooToDelete, p1, p2, 'b');
                }
            }
        }
        plateau[coo.getY()][coo.getX()] = ' ';
        plateau[nextCoo.getY()][nextCoo.getX()] = turnTo;
        allPawn.remove(index);
    }

    private static int findIndexToDelete(ArrayList<Pawn> allPawn, Coordinate cooToDelete, Player p1, Player p2, char color) {
        int index = 0;
        System.out.println(cooToDelete.getY() + " " + cooToDelete.getX());
        for (Pawn pw : allPawn) {
            if(pw.getY() == cooToDelete.getY() && pw.getX() == cooToDelete.getX() && pw.getColor() == color){
                if(pw.getColor() == 'b'){
                    p1.setNbOfPawn(p1.getNbOfPawn()-1);
                }else if(pw.getColor() == 'n'){
                    p2.setNbOfPawn(p2.getNbOfPawn()-1);
                }
                break;
            }
            index+=1;
        }
        return index;
    }

    private static boolean canEatPawn(char[][] plateau, Coordinate nextCoo, Coordinate coo, char turnTo) {
        if (turnTo == 'b'){
            if((plateau[nextCoo.getY()][nextCoo.getX()] == ' ' && plateau[coo.getY() + 1][coo.getX() - 1] == 'n')
                || (plateau[nextCoo.getY()][nextCoo.getX()] == ' ' && plateau[coo.getY() + 1][coo.getX() + 1] == 'n')){
                return true;
            }else {
                return false;
            }
        }else if(turnTo == 'n'){
            if((plateau[nextCoo.getY()][nextCoo.getX()] == ' ' && plateau[coo.getY() - 1][coo.getX() - 1] == 'b')
                    || (plateau[nextCoo.getY()][nextCoo.getX()] == ' ' && plateau[coo.getY() - 1][coo.getX() + 1] == 'b')){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}

