package com.company;

import Database.CarDataBase;
import Player.Player;

public class Main {

    public static void main(String[] args) {

        CarDataBase carDealer = CarDataBase.getInstance();
        carDealer.restockDatabase(5);

        Player player = new Player("Jon", 10000.0);

    }
}
