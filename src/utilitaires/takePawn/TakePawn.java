package utilitaires.takePawn;

import model.Pawn;

import java.util.ArrayList;

public class TakePawn {

    public static boolean HaveToTakePawn(char[][] plateau, char turnTo, ArrayList<Pawn> allPawn) {
        if(turnTo == 'b'){
            for (Pawn pw : allPawn) {
                if(pw.getColor() == 'b'){
                    if((plateau[pw.getY() + 1][pw.getX() - 1] == 'n' && plateau[pw.getY() + 2][pw.getX() - 1] == ' ')
                            || (plateau[pw.getY() + 1][pw.getX() + 1] == 'n' && plateau[pw.getY() + 2][pw.getX() + 1] == ' ')){
                        System.out.println(pw.getColor() + " en x = " + pw.getX() + " y = " + pw.getY() + " peut manger");
                        return true;
                    }
                }
            }
        }else if(turnTo == 'n'){
            for (Pawn pw: allPawn) {
                if(pw.getColor() == 'n'){
                    if((plateau[pw.getY() - 1][pw.getX() - 1] == 'b' && plateau[pw.getY() - 2][pw.getX() - 1] == ' ')
                            || (plateau[pw.getY() - 1][pw.getX() + 1] == 'b' && plateau[pw.getY() - 2][pw.getX() + 1] == ' ')){
                        System.out.println(pw.getColor() + " en x = " + pw.getX() + " y = " + pw.getY() + " peut manger ");
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static void TakePawn(char[][] plateau, char turnTo, ArrayList<Pawn> allPawn) {
    }
}







/*
        for (int i = 0; i < plateau.length; ++i){
            for (int j = 0; j < plateau.length; ++j){
                if(plateau[i][j] == turnTo && turnTo == 'b'){
                    if((plateau[i+1][j+1] == 'n' && plateau[i+2][j+2] == ' ')
                            || (plateau[i+1][j-1] == 'n' && plateau[i+2][j-2] == ' ')){
                        return true;
                    }


                }else if(plateau[i][j] == turnTo && turnTo == 'n'){
                    if((plateau[i-1][j+1] == 'b' && plateau[i-2][j+2] == ' ')
                            || (plateau[i-1][j-1] == 'n' && plateau[i-2][j-2] == ' ')){
                        return true;
                    }
                }
            }
        }
 */
