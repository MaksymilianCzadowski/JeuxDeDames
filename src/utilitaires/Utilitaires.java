package utilitaires;

import data.Data;
import model.Coordinate;
import model.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
            if(i < 10){
                System.out.format("%d  ", i);
            }else
                System.out.format("%d ", i);
            System.out.println();
        }
        System.out.print("   ");
        for(int i = 1; i <= 12; ++i){

            System.out.format("%c ",c+i);
        }
        System.out.println();
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

    public static void writeInFile(Coordinate coo, Coordinate nextCoo, String signe, Player p, Data data) {

        String text = p.getName() + " move " + (char)(coo.getX()+65) + " " + coo.getY() +
                " " + signe + " " + (char)(nextCoo.getX()+65) + " " + nextCoo.getY();

        try
        {
            FileWriter fw = new FileWriter(data.getFileName(),true);
            fw.write(text + "\n");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }

    }

    public static ArrayList<String> readFile(String fileName) throws IOException{
        ArrayList<String> allText = new ArrayList<String>();

        Scanner scanner = new Scanner(new File(fileName));
        while(scanner.hasNextLine()) {
            allText.add(scanner.nextLine());
        }
        return allText;
    }

}
