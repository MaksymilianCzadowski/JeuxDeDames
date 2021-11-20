package utilitaires;

public class Utilitaires {

    public static void printPlateau(char[][] plateau) {
        for(int i = 0; i < plateau.length; ++i){
            for(int j = 0; j < plateau.length; ++j){
                System.out.print(plateau[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
