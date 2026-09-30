package machine;

import java.util.Scanner;
/*
O programa deve fazer no momento:
 1- Pedir a quantidade de água, leite e café na máquina no momento // feito
 2- Se ter a quantidade para fazer o café, a saída é: "Yes, i can make that amount of coffee"
 3- Se a maquina consegue fazer mais café do que a quantidade pedida ela deve escrever:
 "Yes, I can make that amount of coffee (and even N more than that)" onde N é a quantidade café adicional
 4- Se ela não ter ingredientes ela deve escrever:
 "No, I can make only N cup(s) of coffee"

 */

public class CoffeeMachine {
    public static int machineWater;
    public static int machineMilk;
    public static int machineCoffee;
    public static int disposableCups;
    public static int moneyInMachine;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        machineWater = 400;
        machineMilk = 540;
        machineCoffee = 120;
        disposableCups = 9;
        moneyInMachine = 550;
       //int quantity = getCupsQuantity(scanner);
        //System.out.println(cupCalculations(quantity));
        String userInput ="";
        while(!userInput.equals("exit")){
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            userInput = scanner.next().toLowerCase().trim();
            switch (userInput){
                case "buy": // feito, falta testar
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeChoice = scanner.next();
                    if (coffeeChoice.equals("back")) {
                        break;
                    }

                    if (machineIsFull()){
                        switch (coffeeChoice){
                            case "1":
                                espressoCoffee();
                                break;
                            case "2":
                                latteCoffee();
                                break;
                            case "3":
                                cappuccinoCoffee();
                                break;
                            default:
                                System.out.println("Is not a option");
                                continue;
                        }
                        System.out.println("I have enough resources, making you a coffee!");
                    } else {
                        if (machineWater < 200){
                            System.out.println("Sorry, not enough water!");
                        } else if ( machineMilk < 75){
                            System.out.println("Sorry, not enough milk!");
                        } else if (machineCoffee < 12){
                            System.out.println("Sorry, not enough coffee beans!");
                        } else {
                            System.out.println("Sorry, not enough disposable cups!");
                        }
                }
                    break;
                case "fill": // feito, falta teste
                    System.out.println("Write how many ml of water you want to add:");
                    int water = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int milk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int coffee = scanner.nextInt();
                    System.out.println("Write how many disposable cups you want to add:");
                    int cups = scanner.nextInt();
                    fillTheMachine(water, milk, coffee, cups);
                    break;
                case "take": // feito, falta teste
                    emptyMoneyInMachine();
                    break;
                case "remaining": //feito, falta teste
                    showData();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Não reconhecivel");
            }
        }
    }
    public static boolean machineIsFull(){
        boolean isFull;
        if ((machineWater >= 200) && (machineCoffee >= 12) && (machineMilk >= 75) && (disposableCups >= 1)){
               isFull = true;
        } else {
            isFull = false;
        }
        return isFull;
    }
    public static void showData(){
        System.out.println("The coffee machine has:");
        System.out.println(machineWater + " ml of water");
        System.out.println(machineMilk + " ml of milk");
        System.out.println(machineCoffee + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + moneyInMachine + " of money");
    }
    public static void espressoCoffee(){
        int espressoWater = 250;
        int espressoCoffee = 16;
        int espressoCost = 4;
        moneyInMachine += espressoCost;
        machineWater -= espressoWater;
        machineCoffee -= espressoCoffee;
        disposableCups--;
    }
    public static void latteCoffee(){
        int latteWater = 350;
        int latteMilk = 75;
        int latteCoffee = 20;
        int latteCost = 7;
        moneyInMachine += latteCost;
        machineWater -= latteWater;
        machineMilk -= latteMilk;
        machineCoffee -= latteCoffee;
        disposableCups--;
    }
    public static void cappuccinoCoffee(){
        int cappuccinoWater = 200;
        int cappucinoMilk = 100;
        int cappucinoCoffee = 12;
        int capuccinoCost = 6;
        moneyInMachine += capuccinoCost;
        machineWater -= cappuccinoWater;
        machineMilk -= cappucinoMilk;
        machineCoffee -= cappucinoCoffee;
        disposableCups--;
    }
    public static void emptyMoneyInMachine(){
        moneyInMachine = 0;
    }
    public static void fillTheMachine(int water, int milk, int coffee, int cups){
        machineWater += water;
        machineMilk += milk;
        machineCoffee += coffee;
        disposableCups += cups;
    }
    /*public static String cupCalculations(int quantity){
        int cupsAvailable = 0;
        // molde para cada tipo de café
        //espresso
        int espressoWater = 250;
        int espressoCoffee = 16;
        int espressoCost = 4;

        while ((machineWater >= WATERRECIPE) && (machineMilk >= MILKRECIPE ) && (machineCoffee >= COFFEERECIPE)){
            disposableCups--;
            machineWater -= espressoWater;
            machineCoffee -= espressoCoffee;
        }
        if (quantity > cupsAvailable){ // feito
            return String.format("No, I can make only %d cup(s) of coffee\n",cupsAvailable);

        } else if (quantity == cupsAvailable){
                return "Yes, i can make that amount of coffee";
        } else {
            cupsAvailable -= quantity;
            return String.format("Yes, I can make that amount of coffee (and even %d more than that)", cupsAvailable);
        }
    }*/
}