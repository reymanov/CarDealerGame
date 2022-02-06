package com.company;

import Database.CarsDatabase;
import Database.CustomersDatabase;
import Player.Player;

import java.util.Scanner;

public class Main {

    public static void printMenu(String[] options){
        System.out.printf("%n");
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static String mainMenu() {
        Scanner scanner = new Scanner(System.in);
        String[] options = {
                "Main menu",
                "1 - Start",
                "2 - Rules",
                "3 - Exit",
        };
        String name;
        int option = 0;

        System.out.println("===============================");
        System.out.println("     Car dealer simulator      ");
        System.out.println("===============================");

        System.out.print("Enter your name : ");
        name = scanner.nextLine();

        while(option != 1) {
            System.out.printf("%n");
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 2 -> rules();
                    case 3 -> endGame();
                }
            }  catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
        return name;
    }

    public static void main(String[] args) {
        String[] options = {
                "1 - Player",
                "2 - Car Market",
                "3 - Mechanic",
                "4 - Customers",
                "5 - Exit",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        String name = mainMenu();

        CarsDatabase carDealer = CarsDatabase.getInstance();
        CustomersDatabase customersService = CustomersDatabase.getInstance();

        carDealer.restockDatabase(5);
        customersService.addCustomers(4);

        Player player = new Player(name, 100000.0);
        while (option!=5){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> PlayerMenu.displayMenu(player);
                    case 2 -> CarsMenu.displayMenu(player, carDealer, customersService);
                    case 3 -> MechanicMenu.displayMenu(player);
                    case 4 -> CustomersMenu.displayMenu(player, customersService);
                    case 5 -> endGame();
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }

    public static void rules() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Rules");
        System.out.println("1 - You play the role of a car dealer, goal is to double your cash in as little moves as possible.");
        System.out.println("2 - One move is: buy a car / sell a car / fix car / post advertisement");
        System.out.println("3 - Other actions like: viewing your account balance, transaction history, customer databases,");
        System.out.println("    vehicles available for purchase does not imply moves consumption.");

        System.out.printf("%n");
        System.out.print("Press enter to go back ...");
        scanner.nextLine();

    }

    public static void endGame() {
        System.out.printf("%n");
        System.out.println("===============================");
        System.out.println("Thank You for playing the game.");
        System.out.println("===============================");
        System.exit(0);
    }
}

