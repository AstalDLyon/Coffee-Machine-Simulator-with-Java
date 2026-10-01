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
    public static int usageCount = 0;
    public static boolean cleaningTime = false;

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
            System.out.println("Write action (buy, fill, take, clean, remaining, exit)");
            userInput = scanner.next().toLowerCase().trim();
            switch (userInput){
                case "buy": // feito, falta testar
                    if(usageCount >= 10){ // problema de inversão que não trava realmente, talvez um uso de ENUM;
                        cleaningTime = true;
                    }
                    if (cleaningTime){
                        System.out.println("I need cleaning!");
                        break;
                    }
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeChoice = scanner.next();
                    if (coffeeChoice.equals("back")) {
                        break;
                    }
                    if (hasEnoughResources(coffeeChoice)){
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
                        usageCount++;
                        System.out.println("I have enough resources, making you a coffee!");
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
                case "take": // feito.
                    emptyMoneyInMachine();
                    break;
                case "remaining": //feito.
                    showData();
                    break;
                case "clean":// feito.
                    cleaningTime = false;
                    usageCount = 0;
                    System.out.println("I have been cleaned!");
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Não reconhecivel");
            }
        }
    }

    /*public static boolean setCleaningTime(){
        cleaningTime = !cleaningTime;
        return  cleaningTime;
    }*/
    public static boolean hasEnoughResources(String choice) {
        int neededWater = 0;
        int neededMilk = 0;
        int neededCoffee = 0;

        switch (choice) {
            case "1": // Espresso
                neededWater = 250;
                neededCoffee = 16;
                break;
            case "2": // Latte
                neededWater = 350;
                neededMilk = 75;
                neededCoffee = 20;
                break;
            case "3": // Cappuccino
                neededWater = 200;
                neededMilk = 100;
                neededCoffee = 12;
                break;
            default:
                return true; // Deixa passar para o switch principal, que vai exibir o erro de opção inválida
        }

        if (machineWater < neededWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (machineMilk < neededMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (machineCoffee < neededCoffee) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }

        return true;
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
}