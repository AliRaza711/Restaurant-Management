package com.company;

public class Node {
    String name;
    double price;
    int popularity;
    Node next;

    // Constructor to initialize a new menu item
    public Node(String name, double price, int popularity) {
        this.name = name;
        this.price = price;
        this.popularity = popularity;
        this.next = null;  // Initially, next is null
    }
}
