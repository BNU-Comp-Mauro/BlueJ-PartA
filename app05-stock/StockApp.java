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
    public static final String ADD_PRODUCT = "add";
    public static final String REMOVE_PRODUCT = "remove";
    public static final String PRINT_ALL = "printall";
    public static final String DELIVER_PRODUCT = "deliver";
    public static final String SEARCH_PRODUCT = "search";
    public static final String LOW_STOCK = "lowstock";
    public static final String SELL_PRODUCT = "sell";
    public static final String RESTOCK_ALL_PRODUCTS = "restockall";
    public static final String QUIT_PROGRAM = "quit";
    
    // Use to get user input
    private InputReader reader;
    private StockManager manager;
    private StockDemo oldStock;
    private Product product;
    private int id;
    private int amount;
    private String name;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        manager = new StockManager();
        oldStock = new StockDemo(manager);
        product = new Product(id, name);
        this.id = id;
        this.amount = amount;
        this.name = name;
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

            if(choice.equals(QUIT_PROGRAM))
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
        if(choice.equals(ADD_PRODUCT))
        {
            addProduct();
        }
        else if(choice.equals(REMOVE_PRODUCT))
        {
            removeProduct();
        }
        else if(choice.equals(PRINT_ALL))
        {
            printAllProducts();
        }
        else if(choice.equals(DELIVER_PRODUCT))
        {
            deliverProduct();
        }
        else if(choice.equals(SEARCH_PRODUCT))
        {
            searchProduct();
        }
        else if(choice.equals(LOW_STOCK))
        {
            printLowStockProducts();
        }
        else if(choice.equals(SELL_PRODUCT))
        {
            sellProduct();
        }
        else if(choice.equals(RESTOCK_ALL_PRODUCTS))
        {
            restockAllProducts();
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
        id = Integer.parseInt(value);

        System.out.println("Please enter the product name ");
        name = reader.getInput();

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
        id = Integer.parseInt(value);

        System.out.println("Please enter the product name ");
        name = reader.getInput();

        Product product = new Product(id, name);
        System.out.println("Removed an existing product " + product);

        manager.removeProduct(product);
    }

    private void getDeliverInput()
    {
        System.out.println("\nDelivering a product\n");

        System.out.println("Please enter the product ID");
        String value = reader.getInput();
        id = Integer.parseInt(value);

        System.out.println("Please enter the product name ");
        name = reader.getInput();

        System.out.println("Please enter the amount to be delivered ");
        String quantity = reader.getInput();
        amount = Integer.parseInt(quantity);
    }
    
    /**
     * Deliver a product's stock to the stock manager.
     */
    private void deliverProduct()  
    {
        getDeliverInput();
        manager.deliverProduct(id, amount);
    }

    /**
     * Sell a given amount of a product.
     */
    private void sellProduct()
    {
        System.out.println("\nSelling an item");

        System.out.println("\nPlease enter the item ID");
        String value = reader.getInput();
        id = Integer.parseInt(value);

        System.out.println("Please enter the item name");
        name = reader.getInput();

        System.out.println("Please enter the quantity to sell ");
        String quantity = reader.getInput();
        int amount = Integer.parseInt(quantity);

        manager.sellProduct(id, amount);
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
     * Prints a list of the products that are low on stock
     */
    private void restockAllProducts()
    {    
        System.out.println("\nPlease enter the low stock level");
        String value = reader.getInput();
        int lowStock = Integer.parseInt(value);
        
        System.out.println("\nPlease enter the restock level");
        String reStock = reader.getInput();
        int restock = Integer.parseInt(reStock);
        
        manager.restockProducts(lowStock, restock);
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
