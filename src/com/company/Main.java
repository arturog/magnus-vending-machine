package com.company;
import java.util.Arrays;
import java.util.Scanner;  // Import the Scanner class

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);  // Create a Scanner object
        var applicationState = new ApplicationState();
        var clientCommands = new ClientCommands(applicationState);

        System.out.println("Welcome to our Vending Machine.  Enter exit to quit.");

        while (true) {
            System.out.println("Enter your command.  Press ? for help");

            String textYouTyped = scanner.nextLine();  // Read user input
            if (textYouTyped.equals("exit")) {
                break; // exit program
            }

            String[] commandParts = textYouTyped.split(" ");
            if (commandParts.length == 0) {
                continue; // no command
            }

            String command = commandParts[0];
            String[] commandArguments = Arrays.copyOfRange(commandParts, 1, commandParts.length);

            switch (command) {
                case "?":
                    System.out.println("Valid commands are:");
                    System.out.println("  pick <code> - picks a product into your basket");
                    System.out.println("  unpick <code> - unpicks a product from your basket");
                    System.out.println("  basket - shows your basket");
                    System.out.println("  stock - shows current stock");
                    System.out.println("  checkout - checks out your basket");
                    System.out.println("  clear - clears your basket");
                    System.out.println("  pricelist - Shows products and prices");
                    break;
                case "pick":
                    clientCommands.pick(commandArguments);
                    break;
                case "unpick":
                    clientCommands.unpick(commandArguments);
                case "pricelist":
                    clientCommands.priceList();
                    break;
                case "stock":
                    clientCommands.stock();
                    break;
                default:
                    System.out.println("Unknown command - " + command);
            }
        }

        System.out.println("Thank you for using our vending machine.  Goodbye.");
    }
}
