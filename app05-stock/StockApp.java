import java.util.ArrayList;
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Mauro Duarte Nunes
 * 21815118
 * 20/11/2020
 */
public class StockApp
{
    // Use to get user input
    private InputReader reader;
    private StockManager manager;
    private StockDemo oldStock;
    private Product product;

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        manager = new StockManager();
        oldStock = new StockDemo(manager);
    }

    /**
     * Starts the program.
     */
    public void run()
    {
        getMenuChoice();
    }

    /**
     * Prints heading and menu choices, and allows the user to start
     * inputting. When user's input is "quit", it finishes the program.
     */
    public void getMenuChoice()
    {
        boolean finished = false;

        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String choice = reader.getInput();
            choice = choice.toLowerCase();

            if(choice.equals("quit"))
            {
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }

    /**
     * This method uses the user's input and executes the different methods
     * available based on said input.
     */
    private void executeMenuChoice(String choice)
    {
        if(choice.equals("add"))
        {
            addProduct();
        }
        else if(choice.equals("remove"))
        {
            removeProduct();
        }
        else if(choice.equals("printall"))
        {
            printAllProducts();
        }
        else if(choice.equals("deliver"))
        {
            deliverProduct();
        }
        else if(choice.equals("search"))
        {
            searchProduct();
        }
        else if(choice.equals("lowstock"))
        {
            printLowStockProducts();
        }
        else if(choice.equals("sell"))
        {
            sellProduct();
        }
    }

    /**
     * Add a product to the stock manager.
     */
    private void addProduct()
    {
        System.out.println("\nAdding a new product\n");

        System.out.println("Please enter the product ID");
        String value = reader.getInput();
        int id = Integer.parseInt(value);

        System.out.println("Please enter the product name ");
        String name = reader.getInput();

        Product product = new Product(id, name);
        System.out.println("Added new product " + product);

        manager.addProduct(product);
    }

    /**
     * Remove a product from the stock manager.
     */
    private void removeProduct()  
    {
        System.out.println("\nRemoving an existing product\n");

        System.out.println("Please enter the product ID");
        String value = reader.getInput();
        int id = Integer.parseInt(value);

        System.out.println("Please enter the product name ");
        String name = reader.getInput();

        Product product = new Product(id, name);
        System.out.println("Removed an existing product " + product);

        manager.removeProduct(product);
    }

    /**
     * Deliver a product's stock to the stock manager.
     */
    private void deliverProduct()  
    {
        System.out.println("\nDelivering a product\n");

        System.out.println("Please enter the product ID");
        String value = reader.getInput();
        int id = Integer.parseInt(value);

        System.out.println("Please enter the product name ");
        String name = reader.getInput();

        System.out.println("Please enter the amount to be delivered ");
        String quantity = reader.getInput();
        int amount = Integer.parseInt(quantity);

        if(amount >= 1)
        {
            Product product = new Product(id, name);
            System.out.println("Delivered " + amount + " item/s of product " + id + ": " + name);

            manager.deliverProduct(id, amount);
        }
        else if(amount < 1)
        {
            System.out.println("\n-------------------------------------");
            System.out.println("Error: Please enter a positive amount");
            System.out.println("-------------------------------------");
        }
    }

    /**
     * Sell a given amount of a product.
     */
    private void sellProduct()
    {
        System.out.println("\nSelling an item");

        System.out.println("\nPlease enter the item ID");
        String value = reader.getInput();
        int id = Integer.parseInt(value);

        System.out.println("Please enter the item name");
        String name = reader.getInput();

        System.out.println("Please enter the quantity to sell ");
        String amount = reader.getInput();
        int quantity = Integer.parseInt(amount);

        Product product = new Product(id, name);
        if(quantity < product.getQuantity())
        {
            System.out.println("Sold " + quantity + " item/s of product " + 
            id + ": " + name);

            System.out.println();
            manager.sellProduct(id, quantity);
        }
        else if(quantity < 0)
        {
            System.out.println("\n-------------------------------------");
            System.out.println("Error: Please enter a positive amount");
            System.out.println("-------------------------------------");
        }
        else if(quantity > product.getQuantity())
        {
            System.out.println("\n--------------------------------------------------------------------");
            System.out.println("Error: Attempt to sell a larger quantity than current stock quantity");
            System.out.println("--------------------------------------------------------------------");
        }
        else if(quantity == 0)
        {
            System.out.println("\n-------------------------------");
            System.out.println("Error: Cannot sell a value of 0");
            System.out.println("-------------------------------");
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * Return the identified product, or null if there is none
     * with a matching ID.
     */
    private void searchProduct()
    {
        System.out.println("\nSearching for a product\n");

        System.out.println("Please enter a keyword");
        String name = reader.getInput();

        manager.searchProduct(name);
    }

    /**
     * Prints a list of the products that are low on stock
     */
    private void printLowStockProducts()
    {
        System.out.println("\nThe following products are low on stock:");
        System.out.println();
        manager.printLowStockProducts();
    }

    /**
     * Prints all products available.
     */
    private void printAllProducts()
    {
        manager.printAllProducts();
    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an existing product");
        System.out.println("    Deliver:    Deliver stock to a product");
        System.out.println("    Sell:       Sell a product");
        System.out.println("    Search:     Search for a product based on part of its name");
        System.out.println("    LowStock:   Print a list of products low on stock");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("\n******************************");
        System.out.println(" Stock Management Application ");
        System.out.println(" App05: by Mauro Duarte Nunes ");
        System.out.println("******************************");
    }
}
