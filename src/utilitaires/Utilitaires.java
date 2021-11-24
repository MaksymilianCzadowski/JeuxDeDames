package utilitaires;

import model.Coordinate;

import java.util.Scanner;

public class Utilitaires {

    public static void printPlateau(char[][] plateau) {
        System.out.print("   ");
        char c = 64;
        for(int i = 1; i <= 12; ++i){

            System.out.format("%c ",c+i);
        }
        System.out.println();
        for(int i = 0; i < plateau.length; ++i){
            if(i < 10){
                System.out.format("%d  ", i);
            }else
                System.out.format("%d ", i);

            for(int j = 0; j < plateau.length; ++j){
                System.out.print(plateau[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void getChoice(Coordinate co) {
        final String separateur = " ";

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        String coordonnee[] = choice.split(separateur);

        co.setY(Integer.parseInt(coordonnee[1]));
        co.setX(letterToIndex(coordonnee[0]));
    }

    private static int letterToIndex(String s) {
        char c = s.charAt(0);
        return c - 65;
    }

}
