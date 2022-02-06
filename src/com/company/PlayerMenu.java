package com.company;

import Player.Player;

import java.util.Scanner;

public class PlayerMenu {

    public static void displayMenu(Player player) {
        String[] options = {
                "1- My Garage",
                "2- Account balance",
                "3- Display transactions",
                "4- Go back",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option!=4){
            Main.printMenu(options);
            option = scanner.nextInt();
            switch (option){
                case 1: player.showGarage(); break;
                case 2: player.checkAccount(); break;
                case 3: player.showTransactions();break;
                case 4: break;
            }
        }
    }
}
