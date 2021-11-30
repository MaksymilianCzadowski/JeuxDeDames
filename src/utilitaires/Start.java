package utilitaires;

import model.Player;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Start {
    public static void menu(Player p1, Player p2) {
        boolean menuOn = true;
        do {
            System.out.println("Le jeud de dames se lance !" +
                    "\n [1] Player vs Player" +
                    "\n [2] Player vs un bot incroyable" +
                    "\n [3] Règles du jeux" +
                    "\n [4] Quitter le jeux");

            int choice = 0;

            try {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Erreur de saisie");
            }

            switch (choice){
                case 1:
                    getPlayerName(p1);
                    getPlayerName(p2);
                    menuOn = false;
                    break;
                case 2:
                    getPlayerName(p1);
                    p2.setName("Bot");
                    menuOn = false;
                    break;
                case 3:
                    System.out.println("https://www.regledujeu.fr/regle-jeu-de-dames/");
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    break;
            }

        }while (menuOn);

        createFile(p1, p2);

    }

    private static void createFile(Player p1, Player p2) {
        try {
            String fileName = p1.getName() + "_VS_" + p2.getName() + ".txt";
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
                // changer de nom si il existe déjà
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void getPlayerName(Player p) {
        System.out.print("Nom du joueur : ");
        Scanner scanner = new Scanner(System.in);
        try {
            p.setName(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Erreur pendant l'entrée du nom");
        }
    }


}
