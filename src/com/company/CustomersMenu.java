package com.company;

import Database.CustomersDatabase;
import Player.Player;

import java.util.Scanner;

public class CustomersMenu {
    public static void displayMenu(Player player, CustomersDatabase customersDatabase) {
        String[] options = {
                "1- Display clients",
                "2- Advertise in newspaper - $2000",
                "3- Advertise online - $1000",
                "4- Go back",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option!=4){

            Main.printMenu(options);
            option = scanner.nextInt();
            switch (option){
                case 1: customersDatabase.showCustomers(); break;
                case 2: player.advertiseInNewspaper(customersDatabase); break;
                case 3: player.advertiseOnline(customersDatabase);break;
                case 4: break;
            }
        }
    }
}
