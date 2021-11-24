package utilitaires;

import model.Coordinate;

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

    public static void transformToCoordinate(int ch, char[][] plateau, Coordinate co) {
        int temp = 0;
        for(int i = 0; i < plateau.length; ++i){
            for(int j = 0; j < plateau.length; ++j){
                if(plateau[i][j] == 'b' || plateau[i][j] == 'w'){
                    ++temp;
                    if(temp == ch){
                        co.setY(i);
                        co.setX(j);
                        break;
                    }
                }
            }
        }
    }
}
