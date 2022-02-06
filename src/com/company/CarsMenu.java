package com.company;

import Database.CarsDatabase;
import Database.CustomersDatabase;
import Player.Player;

import java.util.Scanner;

public class CarsMenu {

    public static void displayMenu(Player player, CarsDatabase dealer, CustomersDatabase customerService) {
        String[] options = {
                "1 - Cars to buy",
                "2 - Buy a car",
                "3 - Sell a car",
                "4 - Go back",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option!=4){
            Main.printMenu(options);
            option = scanner.nextInt();
            switch (option){
                case 1: dealer.showCars(); break;
                case 2: buyACar(player,dealer); break;
                case 3: sellACar(player, customerService); break;
                case 4: break;
            }
        }
    }

    private static void buyACar(Player player, CarsDatabase dealer) {
        Scanner scanner = new Scanner(System.in);
        dealer.showCars();
        player.checkAccount();
        int carNumber = 0;
        try {
            System.out.print("Enter number of car to buy: ");
            carNumber = scanner.nextInt();
            player.buyCar(dealer, dealer.getCars().get(carNumber));
        }
        catch (Exception ex){
            System.out.println("Please enter an integer value between 0 and " + dealer.getCars().size());
            scanner.next();
        }
    }

    private static void sellACar(Player player, CustomersDatabase customerService) {
        Scanner scanner = new Scanner(System.in);
        player.showGarage();
        int carNumber = 100;
        int client = 100 ;
        double price = 0.0;

        int availableCars = player.getGarage().size()-1;
        int availableCustomers = customerService.getCustomers().size() - 1;
        while (carNumber > availableCars) {
            try {
                System.out.print("Enter number of car you want to sell: ");
                carNumber = scanner.nextInt();
                if(carNumber > availableCars){
                    throw new Exception();
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 0 and " + availableCars);
            }
        }
        while (client > availableCustomers){
            try {
                System.out.printf("%n");
                System.out.println("Select a client: ");
                customerService.showCustomers();
                client = scanner.nextInt();
                if(client > availableCustomers) {
                    throw new Exception();
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 0 and " + availableCustomers);
            }
        }

        while(price == 0.0) {
            try {
                System.out.printf("%n");
                System.out.println("Enter a price you want to sell it for:");
                price = scanner.nextDouble();
            }catch (Exception ex) {
                System.out.println("Wrong price, enter something more than 0");
            }
        }

        player.sellCar(player.getCar(carNumber), customerService.getCustomers().get(client), customerService, price);

    }
}
