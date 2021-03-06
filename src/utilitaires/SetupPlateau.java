package utilitaires;

import model.Pawn;

import java.util.ArrayList;

public class SetupPlateau {
    public static void fillPlateau(char[][] plateau) {
        for (int i = 0; i < plateau.length; ++i) {
            for (int j = 0; j < plateau.length; ++j) {
                plateau[i][j] = ' ';
                plateau[0][j] = '-';
                plateau[i][0] = '|';
                plateau[plateau.length - 1][j] = '-';
                plateau[i][plateau.length - 1] = '|';
                plateau[0][0] = '+';
                plateau[plateau.length - 1][plateau.length - 1] = '+';
                plateau[plateau.length - 1][0] = '+';
                plateau[0][plateau.length - 1] = '+';
            }
        }
    }

    public static void addPionToPlateau(ArrayList<Pawn> allPawn, char[][] plateau) {
        for (Pawn p : allPawn) {
            plateau[p.getY()][p.getX()] = p.getColor();
        }
    }
}
