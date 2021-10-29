package com.company;

public class ClientCommands {
    ApplicationState applicationState;

    ClientCommands(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    public void stock() {
        System.out.println(this.applicationState.stock);
    }

    public void priceList() {
        System.out.println(this.applicationState.priceList);
    }

    public void pick(String[] args) {
        if (args.length != 1) {
            System.out.println("Bad command, try again");
            return;
        }
        String productCode = args[0];

        var currentStockQty = this.applicationState.stock.getOrDefault(productCode, 0);
        if (currentStockQty <= 0) {
            System.out.println("Stock is zero, sorry");
            return;
        }

        var currentBasketQty = this.applicationState.basket.getOrDefault(productCode, 0);

        this.applicationState.basket.put(productCode, currentBasketQty + 1);
        this.applicationState.stock.put(productCode, currentStockQty - 1);
        System.out.println("pick - Added " + productCode + " to your basket below");
        System.out.println("Basket: " + this.applicationState.basket);
        System.out.println("Stock: " + this.applicationState.stock);
    }

    public void unpick(String[] args) {
        if (args.length != 1) {
            System.out.println("Bad command, try again");
            return;
        }

        String productCode = args[0];

        var currentBasketQty = this.applicationState.stock.getOrDefault(productCode, 0);
        if (currentBasketQty <= 0) {
            System.out.println("Stock is zero, sorry");
            return;
        }

        var currentStockQty = this.applicationState.basket.getOrDefault(productCode, 0);

        this.applicationState.basket.put(productCode, currentBasketQty - 1);
        this.applicationState.stock.put(productCode, currentStockQty + 1);
        System.out.println("pick - Removed " + productCode + " to your basket below");
        System.out.println("Basket: " + this.applicationState.basket);
        System.out.println("Stock: " + this.applicationState.stock);
    }
}
