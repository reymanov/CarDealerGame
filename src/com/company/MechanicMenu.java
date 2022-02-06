package com.company;

import Mechanic.Mechanic;
import Player.Player;

import java.util.Scanner;

public class MechanicMenu {
    public static void displayMenu(Player player) {
        String[] options = {
                "1- Repair whole car",
                "2- Repair only one part",
                "3- Display history of repairs",
                "4- Go back",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option!=4){
            Main.printMenu(options);
            option = scanner.nextInt();
            switch (option){
                case 1: repairWholeCar(player); break;
                case 2: repairOnePart(player); break;
                case 3: showRepairHistory(player); break;
                case 4: break;
            }
        }
    }

    private static Mechanic pickMechanic(int number) {
        Mechanic mechanic = null;
        if(number == 1) {
            mechanic = new Mechanic("Janusz",1.0,1.5);
        }else if (number == 2){
            mechanic = new Mechanic("Marian",0.9,1.2);
        }else if (number == 3) {
            mechanic = new Mechanic("Adrian",0.8,1.0);
        }

        return mechanic;
    }

    private static void repairWholeCar(Player player) {
        String[] options = {
                "1 - Janusz: 100% warranty | expensive",
                "2 - Marian: 90% warranty  | reasonable",
                "3 - Adrian: 80% warranty  | cheapest",
        };
        Scanner scanner = new Scanner(System.in);
        Mechanic mechanic = null;
        int carNumber = 100;
        int option = 0;
        int availableCars = player.getGarage().size()-1;

        while (option > 3 || option < 1){
            try {
                System.out.printf("%n");
                System.out.println("Pick Your mechanic");
                Main.printMenu(options);
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> mechanic = pickMechanic(1);
                    case 2 -> mechanic = pickMechanic(2);
                    case 3 -> mechanic = pickMechanic(3);
                }
                if(option > 3 || option < 1) {
                    throw new Exception("Error");
                }
            }catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and 3");
            }
        }

        while(carNumber > availableCars) {
            try{
                player.showGarage();
                System.out.printf("%n");
                System.out.println("Pick car to repair");
                carNumber = scanner.nextInt();
                if(carNumber > availableCars){
                    throw new Exception();
                }
            }catch (Exception ex){
                System.out.println("Please enter an integer value between 0 and " + availableCars);
            }
        }
        if(mechanic != null) {
            mechanic.repairEverything(player.getCar(carNumber), player);
        }
    }

    private static void repairOnePart(Player player) {
        String[] options = {
                "1 - Janusz: 100% warranty | expensive",
                "2 - Marian: 90% warranty  | reasonable",
                "3 - Adrian: 80% warranty  | cheapest",
        };
        Scanner scanner = new Scanner(System.in);
        Mechanic mechanic = null;
        int carNumber = 100;
        int partNumber = 100;
        int option = 0;

        int availableCars = player.getGarage().size()-1;

        while (option > 3 || option < 1){
            try {
                System.out.printf("%n");
                System.out.println("Pick Your mechanic");
                Main.printMenu(options);
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> mechanic = pickMechanic(1);
                    case 2 -> mechanic = pickMechanic(2);
                    case 3 -> mechanic = pickMechanic(3);
                }
                if(option > 3 || option < 1) {
                    throw new Exception("Error");
                }
            }catch (Exception ex) {
                System.out.println("Please enter an integer value between 1 and 3");
            }
        }

        while(carNumber > availableCars) {
            try{
                player.showGarage();
                System.out.printf("%n");
                System.out.println("Pick car to repair");
                carNumber = scanner.nextInt();
                if(carNumber > availableCars){
                    throw new Exception();
                }
            }catch (Exception ex){
                System.out.println("Please enter an integer value between 0 and " + availableCars);
            }
        }

        while(partNumber > 4 || partNumber < 0) {
            try{
                player.getCar(carNumber).showParts();
                System.out.printf("%n");
                System.out.println("Pick part to repair");
                partNumber = scanner.nextInt();
                if(partNumber > 4 || partNumber < 0){
                    throw new Exception();
                }
            }catch (Exception ex){
                System.out.println("Please enter an integer value between 0 and 4");
            }
        }
        if(mechanic != null) {
            mechanic.repairPart(player.getCar(carNumber), player.getCar(carNumber).parts.get(partNumber), player );
        }

    }

    private static void showRepairHistory(Player player) {
        Scanner scanner = new Scanner(System.in);
        int carNumber = 100;

            int availableCars = player.getGarage().size() - 1;

            while (carNumber > availableCars) {
                try {
                    player.showGarage();
                    System.out.printf("%n");
                    System.out.println("Select car to display repair history");
                    carNumber = scanner.nextInt();
                    if (carNumber > availableCars) {
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    System.out.println("Please enter an integer value between 0 and " + availableCars);
                }
            }

            player.getCar(carNumber).showRepairHistory();
        }

}
