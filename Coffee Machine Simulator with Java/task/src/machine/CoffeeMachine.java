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
   public static final int WATERRECIPE = 200;
    public static final int MILKRECIPE = 50;
    public static final int COFFEERECIPE = 15;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water = getWater(scanner);
        int milk = getMilk(scanner);
        int coffee = getCoffee(scanner);
        int quantity = getCupsQuantity(scanner);
        System.out.println(cupCalculations(water, milk, coffee, quantity));

        scanner.close();

    }
    public static int getCupsQuantity(Scanner scanner){
        System.out.println("Write how many cups of coffee you will need:");
        return scanner.nextInt();
    }
    public static String cupCalculations(int waterMachine, int milkMachine, int coffeeMachine, int quantity){

        // checagem
        int nWater = waterMachine;
        int nMilk =  milkMachine;
        int nCoffee =  coffeeMachine;
        int cupsAvailable = 0;

        while ((nWater >= WATERRECIPE) && (nMilk >= MILKRECIPE ) && (nCoffee >= COFFEERECIPE)){
            cupsAvailable++;
            nWater -= WATERRECIPE;
            nMilk -= MILKRECIPE;
            nCoffee -= COFFEERECIPE;
        }
        if (quantity > cupsAvailable){ // feito
            return String.format("No, I can make only %d cup(s) of coffee\n",cupsAvailable);

        } else if (quantity == cupsAvailable){
                return "Yes, i can make that amount of coffee";
        } else {
            cupsAvailable -= quantity;
            return String.format("Yes, I can make that amount of coffee (and even %d more than that)", cupsAvailable);
        }
    }
    public static int getWater(Scanner scanner){
        System.out.println("Write how many ml of water the coffee machine has:");
        return scanner.nextInt();
    }
    public static int getMilk(Scanner scanner){
        System.out.println("Write how many ml of milk the coffee machine has:");
        return scanner.nextInt();
    }
    public static int getCoffee(Scanner scanner){
        System.out.println("Write how many grams of water the coffee machine has:");
        return scanner.nextInt();
    }
}