package com.company;
import java.util.Scanner;

public class RM {

    private Node head = null; // The head of the linked list
    private int size = 0;     // Keep track of the number of menu items



    // Function to add a new menu item
    public void addMenuItem(String name, double price, int popularity) {
        Node newNode = new Node(name, price, popularity);

       if(head==null){
           head = newNode;
       }else{
           Node current = head;
           while(current.next!=null){
               current = current.next;
           }
           current.next=newNode;
       }
        size++;
        System.out.println("Menu item added successfully.");
    }

    // Function to delete a menu item by name
    public boolean deleteMenuItem(String name) {
        Node current = head;  // Start from the head of the linked list

        // Traverse the linked list to find if the item exists
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                // If item is found, proceed to delete it
                if (current == head) { // If the item to delete is the first node
                    head = head.next; // Remove the first node
                } else {
                    Node prev = head;
                    while (prev.next != current) {
                        prev = prev.next; // Find the previous node
                    }
                    prev.next = current.next; // Skip the current node to delete it
                }
                size--; // Decrease the size of the list
                System.out.println("Menu item removed successfully.");
                return true; // Item was deleted, return true
            }
            current = current.next;  // Move to the next node in the list
        }

        // If item is not found
        System.out.println("Menu item not found.");
        return false;  // Item not found, return false
    }


    // Function to check if the menu item exists
    public boolean updateMenuItem(String name) {
        Node current = head;  // Start from the head of the linked list
        while (current != null) {
            // Compare the name in a case-insensitive manner
            if (current.name.equalsIgnoreCase(name)) {
                // If item is found, return true
                System.out.println("Menu item found. You can now update the price and popularity.");
                return true;
            }
            current = current.next;  // Move to the next node in the list
        }
        // If item is not found
        System.out.println("Menu item not found.");
        return false;  // Item not found, return false
    }

    // Function to update a menu item’s price and popularity
    public void updateMenuItem(String name, double newPrice, int newPopularity) {
            // Proceed with the update without checking if the item exists, assuming it was already validated in the first function
            Node current = head;
            if (current.name.equalsIgnoreCase(name)) {
                current.price = newPrice;
                current.popularity = newPopularity;
                System.out.println("Menu item updated successfully.");
            }
    }

    // Modified searchMenuItem to return a boolean
    public boolean searchMenuItem(String name) {
        Node current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                System.out.println("Found item: Name: " + current.name + ", Price: $" + current.price + ", Popularity: " + current.popularity);
                return true; // Item found
            }
            current = current.next;
        }
        System.out.println("No items found matching the search.");
        return false; // Item not found
    }



    // Function to display all menu items
    public void displayMenu() {
        if (head == null) {
            System.out.println("No items in the menu.");
        } else {
            Node current = head;
            while (current != null) {
                System.out.println("Name: " + current.name + ", Price: $" + current.price + ", Popularity: " + current.popularity);
                current = current.next;
            }
        }
    }

    // Function to search for menu items by name

    // Function to filter menu items by price range
    public void filterMenuByPrice(double minPrice, double maxPrice) {
        boolean found = false;
        Node current = head;
        while (current != null) {
            if (current.price >= minPrice && current.price <= maxPrice) {
                System.out.println("Name: " + current.name + ", Price: $" + current.price + ", Popularity: " + current.popularity);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No items found in the specified price range.");
        }
    }

    // Function to sort menu items by price (ascending or descending)
    public void sortByPrice(boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("No items to sort.");
            return;
        }

        // Bubble sort on linked list by price
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current != null && current.next != null) {
                if ((ascending && current.price > current.next.price) || (!ascending && current.price < current.next.price)) {
                    // Swap the values of the current and next nodes
                    String tempName = current.name;
                    double tempPrice = current.price;
                    int tempPopularity = current.popularity;

                    current.name = current.next.name;
                    current.price = current.next.price;
                    current.popularity = current.next.popularity;

                    current.next.name = tempName;
                    current.next.price = tempPrice;
                    current.next.popularity = tempPopularity;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Menu sorted by price.");
        displayMenu();
    }

    // Function to sort menu items by popularity (ascending or descending)
    public void sortByPopularity(boolean ascending) {
        if (head == null || head.next == null) {
            System.out.println("No items to sort.");
            return;
        }

        // Bubble sort on linked list by popularity
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current != null && current.next != null) {
                if ((ascending && current.popularity > current.next.popularity) || (!ascending && current.popularity < current.next.popularity)) {
                    // Swap the values of the current and next nodes
                    String tempName = current.name;
                    double tempPrice = current.price;
                    int tempPopularity = current.popularity;

                    current.name = current.next.name;
                    current.price = current.next.price;
                    current.popularity = current.next.popularity;

                    current.next.name = tempName;
                    current.next.price = tempPrice;
                    current.next.popularity = tempPopularity;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Menu sorted by popularity.");
        displayMenu();
    }

    // Function for customers to place an order
    public void placeOrder() {
        if (head == null) {
            System.out.println("No items in the menu.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        double total = 0;
        System.out.println("\n--- Place Your Order ---");
        Node current = head;
        while (current != null) {
            System.out.println("Name: " + current.name + ", Price: $" + current.price +", Popularity: " + current.popularity);
            current = current.next;
        }

        System.out.print("Enter the number of items you want to order: ");
        int orderCount = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < orderCount; i++) {
            System.out.print("Enter the name of the item you want to order: ");
            String itemName = scanner.nextLine();
            Node orderItem = head;
            boolean found = false;

            while (orderItem != null) {
                if (orderItem.name.equalsIgnoreCase(itemName)) {
                    total += orderItem.price;
                    found = true;
                    System.out.println("Added " + orderItem.name + " to your order.");
                    break;
                }
                orderItem = orderItem.next;
            }

            if (!found) {
                System.out.println("Item not found. Please select a valid item.");
                i--; // Decrease counter to allow re-ordering
            }
        }

        System.out.println("Thanks for Ordering\nYour Total Bill: $" + total);
    }
}
