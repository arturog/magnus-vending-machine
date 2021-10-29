package com.company;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ApplicationState {
    HashMap<String, Integer> stock;
    HashMap<String, Integer> cash;
    HashMap<String, Integer> priceList;
    HashMap<String, Integer> basket;

    public ApplicationState() {
        this.stock = new HashMap<String, Integer>();
        this.cash = new HashMap<String, Integer>();
        this.priceList = new HashMap<String, Integer>();
        this.basket = new HashMap<String, Integer>();

        this.priceList.put("tea", 35);
        this.priceList.put("coffee", 12);
        this.priceList.put("bread", 7);

        this.stock.put("tea", 27);
        this.stock.put("coffee", 32);
        this.stock.put("bread", 12);

        this.cash.put("N100", 10);
        this.cash.put("N50", 20);
        this.cash.put("N20", 20);
        this.cash.put("N1", 45);
        this.cash.put("N0.5", 20);

        System.out.println("Application state initialised.");
    }
}
