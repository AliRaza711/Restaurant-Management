    package com.company;
    import java.util.Scanner;
    
    public class Main {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            RM restaurant = new RM(); // Create an instance of the RestaurantManagementSystem
            Validation validate = new Validation();
            restaurant.addMenuItem("Biryani",600,6);
            restaurant.addMenuItem("Nihari",400,2);
            restaurant.addMenuItem("Karahi",900,10);
    
    
            while (true) {
                System.out.println("\n--- Welcome to the Restaurant Management System ---");
                System.out.println("1. Admin Login");
                System.out.println("2. Customer Login");
                System.out.println("3. Exit");
                System.out.print("Please select an option (1-3): ");
    
                String choice = scanner.nextLine();
                while (!validate.isValidInteger(choice)) {
                    System.out.println("Enter a valid Number. Please enter a number between 1 and 3.");
                    System.out.print("Please select an option: ");
                    choice = scanner.nextLine();
                }
    
                switch (Integer.parseInt(choice)) {
                    case 1: // Admin Login
                        while (true) {
                            System.out.print("Please Enter Password: ");
                            String adminPassByUser = scanner.nextLine();
                            if (adminPassByUser.equals(validate.getPass())) {
                                System.out.println("Correct Password");
    
                                System.out.println("\n--- Admin Menu ---");
                                while (true) {
                                    System.out.println("1. Add Menu Item");
                                    System.out.println("2. Delete Menu Item");
                                    System.out.println("3. Update Menu Item");
                                    System.out.println("4. View Menu");
                                    System.out.println("5. Logout");
                                    System.out.print("Please select an option (1-5): ");
    
                                    String adminChoice = scanner.nextLine();
                                    while (!validate.isValidInteger(adminChoice) || !validate.isInRange(adminChoice, 1, 5)) {
                                        System.out.println("Enter a valid Number. Please enter a number between 1 and 5.");
                                        System.out.print("Please select an option: ");
                                        adminChoice = scanner.nextLine();
                                    }
    
                                    // Regular expression to check if the name is not a number and consists of letters only
    
    
                                    // Inside the switch case
                                    switch (Integer.parseInt(adminChoice)) {
                                        case 1: // Add Menu Item
                                            String name;
                                            System.out.print("Enter item name: ");
                                            name = scanner.nextLine();
    
                                            // Validate the name to ensure it is not a number
                                            while (!validate.isValidName(name)) {
                                                System.out.println("Enter a valid Name. Name should contain only letters and spaces.");
                                                System.out.print("Please enter again: ");
                                                name = scanner.nextLine();
                                            }
    
                                            double price;
                                            System.out.print("Enter item price: ");
                                            price = validate.getValidDoubleInput(scanner);
    
                                            int popularity;
                                            System.out.print("Enter item popularity (1-10): ");
                                            popularity = validate.getValidIntegerInput(scanner, 1, 10);
    
                                            restaurant.addMenuItem(name, price, popularity);
                                            break;
    
                                        case 2: // Delete Menu Item
                                            System.out.print("Enter item name to delete: ");
                                            String itemNameToDelete = scanner.nextLine();
                                            restaurant.deleteMenuItem(itemNameToDelete);
                                            break;
    
                                        case 3: // Update Menu Item
                                            System.out.print("Enter item name to update: ");
                                            String itemNameToUpdate = scanner.nextLine();
    
                                            // Check if the item exists before asking for price and popularity
                                            boolean itemExists = restaurant.updateMenuItem(itemNameToUpdate);  // This will check for the item
    
                                            if (itemExists) {
                                                // If item is found, prompt for updated price and popularity
                                                double updatedPrice;
                                                System.out.print("Enter updated price: ");
                                                updatedPrice = validate.getValidDoubleInput(scanner);  // Assuming you have a method to validate the input
    
                                                int updatedPopularity;
                                                System.out.print("Enter updated popularity: ");
                                                updatedPopularity = validate.getValidIntegerInput(scanner, 1, 10);  // Assuming you have a method to validate the input
    
                                                // Now update the item with the new price and popularity
                                                restaurant.updateMenuItem(itemNameToUpdate, updatedPrice, updatedPopularity);
                                            }
                                            break;
    
                                        case 4: // View Menu
                                            restaurant.displayMenu();
                                            break;
    
                                        case 5: // Logout
                                            System.out.println("Logging out...");
                                            break;
    
                                        default:
                                            System.out.println("Enter a valid Number. Please enter a number between 1 and 5.");
                                            System.out.print("Please select an option: ");
                                    }
    
    
                                    if (Integer.parseInt(adminChoice) == 5) {
                                        break; // Exit from admin menu
                                    }
                                }
                                break;
                            } else {
                                System.out.println("Incorrect Password");
                            }
                        }
                        break;
    
                    case 2: // Customer Login
                        while (true) {
                            System.out.println("\n--- Customer Menu ---");
                            System.out.println("1. View Menu");
                            System.out.println("2. Search Menu Item");
                            System.out.println("3. Filter Menu by Price");
                            System.out.println("4. Sort Menu by Price");
                            System.out.println("5. Sort Menu by Popularity");
                            System.out.println("6. Place Order");
                            System.out.println("7. Logout");
                            System.out.print("Please select an option: (1-7):");
    
                            String customerChoice = scanner.nextLine();
                            while (!validate.isValidInteger(customerChoice) || !validate.isInRange(customerChoice, 1, 7)) {
                                System.out.println("Enter a valid Number. Please enter a number between 1 and 7.");
                                System.out.print("Please select an option: ");
                                customerChoice = scanner.nextLine();
                            }
    
                            switch (Integer.parseInt(customerChoice)) {
                                case 1: // View Menu
                                    System.out.println();
                                    restaurant.displayMenu();
                                    break;
    
                                case 2: // Search Menu Item
                                    System.out.print("Enter item name to search: ");
                                    String searchTerm = scanner.nextLine();
                                    restaurant.searchMenuItem(searchTerm);
                                    break;
    
                                case 3: // Filter Menu by Price
                                    System.out.print("Enter minimum price: ");
                                    double minPrice = validate.getValidDoubleInput(scanner);
                                    System.out.print("Enter maximum price: ");
                                    double maxPrice = validate.getValidDoubleInput(scanner);
                                    restaurant.filterMenuByPrice(minPrice, maxPrice);
                                    break;
    
                                case 4: // Sort Menu by Price
                                    System.out.println("Sort by: 1. Ascending, 2. Descending");
                                    System.out.print("Choose sorting order: ");
                                    String sortByPriceChoice = scanner.nextLine();
                                    while (!validate.isValidInteger(sortByPriceChoice) || !validate.isInRange(sortByPriceChoice, 1, 2)) {
                                        System.out.println("Invalid choice. Please enter 1 or 2.");
                                        System.out.print("Choose sorting order: ");
                                        sortByPriceChoice = scanner.nextLine();
                                    }
                                    restaurant.sortByPrice(Integer.parseInt(sortByPriceChoice) == 1);
                                    break;
    
                                case 5: // Sort Menu by Popularity
                                    System.out.println("Sort by popularity: 1. Ascending, 2. Descending");
                                    System.out.print("Choose sorting order: ");
                                    String sortByPopularityChoice = scanner.nextLine();
                                    while (!validate.isValidInteger(sortByPopularityChoice) || !validate.isInRange(sortByPopularityChoice, 1, 2)) {
                                        System.out.println("Invalid choice. Please enter 1 or 2.");
                                        System.out.print("Choose sorting order: ");
                                        sortByPopularityChoice = scanner.nextLine();
                                    }
                                    restaurant.sortByPopularity(Integer.parseInt(sortByPopularityChoice) == 1);
                                    break;
    
                                case 6: // Place Order
                                    restaurant.placeOrder();
                                    break;
    
                                case 7: // Logout
                                    System.out.println("Logging out...");
                                    break;
    
                                default:
                                    System.out.println("Enter a valid Number. Please enter a number between 1 and 7.");
                                    System.out.print("Please select an option: ");;
                            }
    
                            if (Integer.parseInt(customerChoice) == 7) {
                                break; // Exit from customer menu
                            }
                        }
                        break;
    
                    case 3: // Exit the application
                        System.out.println("Exiting the system. Goodbye!");
                        return; // Exit the program
    
                    default:
                        System.out.println("Enter a valid Number. Please enter a number between 1 and 3.");
                }
            }
        }
    
    
    }
