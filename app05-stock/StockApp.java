import java.util.ArrayList;
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * Modified by Mauro Duarte Nunes
 * 21815118
 * 08/11/2020
 */
public class StockApp
{
    public static final String ADD_PRODUCT = "add";
    public static final String REMOVE_PRODUCT = "remove";
    public static final String DELIVER_PRODUCT = "deliver";
    public static final String SELL_PRODUCT = "sell";
    public static final String SEARCH_PRODUCT = "search";
    public static final String LOW_STOCK = "lowstock";
    public static final String RESTOCK_PRODUCTS = "restock";
    public static final String PRINT_ALL = "printall";
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
     * inputting. When user's input is "quit", the program stops.
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
                System.out.println("Shutting down...");
                System.out.println("See you soon!");
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }

    /**
     * Uses the user's input and executes the different methods
     * available based on the input.
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
        else if(choice.equals(DELIVER_PRODUCT))
        {
            deliverProduct();
        }
        else if(choice.equals(SELL_PRODUCT))
        {
            sellProduct();
        }
        else if(choice.equals(SEARCH_PRODUCT))
        {
            searchProduct();
        }
        else if(choice.equals(LOW_STOCK))
        {
            printLowStockProducts();
        }
        else if(choice.equals(RESTOCK_PRODUCTS))
        {
            restockProducts();
        }
        else if(choice.equals(PRINT_ALL))
        {
            printAllProducts();
        }
        else
        {
            System.out.println("\n----------------------------------");
            System.out.println("Error: Please enter a valid choice");
            System.out.println("----------------------------------");
        }
    }

    /**
     * User input for addProduct method.
     */
    private void getAddInput()
    {
        System.out.println("Adding a new product");

        System.out.println("\nPlease enter the product ID");
        String value = reader.getInput();
        id = Integer.parseInt(value);

        System.out.println("Please enter the product name");
        name = reader.getInput();
    }

    /**
     * Add a product to the stock manager.
     */
    private void addProduct()
    {
        getAddInput();
        if(manager.findProduct(id) == null)
        {
            Product product = new Product(id, name);
            manager.addProduct(product);
        }
        else
        {
            System.out.println("\n------------------------------------");
            System.out.println("Error: Product ID " + id + " already in use");
            System.out.println("------------------------------------");
        }
    }

    /**
     * User input for removeProduct method.
     */
    private void getRemoveInput()
    {
        System.out.println("Removing an existing product");

        System.out.println("\nPlease enter the product ID");
        String value = reader.getInput();
        id = Integer.parseInt(value);

        System.out.println("Please enter the product name ");
        name = reader.getInput();
    }

    /**
     * Remove a product from the stock manager.
     */
    private void removeProduct()  
    {
        getRemoveInput();
        product = new Product(id, name);
        manager.removeProduct(id);
    }

    /**
     * User input for deliverProduct method.
     */
    private void getDeliverInput()
    {
        System.out.println("Delivering a product");

        System.out.println("\nPlease enter the product ID");
        String value = reader.getInput();
        id = Integer.parseInt(value);

        System.out.println("Please enter the amount to be delivered ");
        String quantity = reader.getInput();
        amount = Integer.parseInt(quantity);
    }

    /**
     * Deliver a chosen amount of a product.
     */
    private void deliverProduct()  
    {
        getDeliverInput();
        manager.deliverProduct(id, amount);
    }

    /**
     * User input for sellProduct method.
     */
    private void getSellInput()
    {
        System.out.println("\nSelling an item");

        System.out.println("\nPlease enter the item ID");
        String value = reader.getInput();
        id = Integer.parseInt(value);

        System.out.println("Please enter the quantity to sell ");
        String quantity = reader.getInput();
        amount = Integer.parseInt(quantity);
    }

    /**
     * Sell a chosen amount of a product.
     */
    private void sellProduct()
    {
        getSellInput();
        manager.sellProduct(id, amount);
    }

    /**
     * Search for a product based on part of its name.
     */
    private void searchProduct()
    {
        System.out.println("Searching for a product");

        System.out.println("\nPlease enter a keyword");
        String name = reader.getInput();

        manager.searchProduct(name);
    }

    /**
     * Prints a list of the products that are low on stock.
     */
    private void printLowStockProducts()
    {
        System.out.println("\nThe following products are low on stock:");

        int lowStockLevel = product.getLowStockLevel();
        manager.printLowStockProducts(lowStockLevel);
    }

    /**
     * Restock products that are low on stock.
     */
    private void restockProducts()
    {    
        System.out.println("Restocking products low on stock");

        System.out.println("\nPlease enter the restock level");
        String reStock = reader.getInput();
        int restockLevel = Integer.parseInt(reStock);

        int lowStockLevel = product.getLowStockLevel();
        manager.restockProducts(lowStockLevel, restockLevel);
    }

    /**
     * Prints all available products.
     */
    private void printAllProducts()
    {
        manager.printAllProducts();
    }

    /**
     * Print out a menu of operation choices.
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an existing product");
        System.out.println("    Deliver:    Deliver stock to a product");
        System.out.println("    Sell:       Sell a product");
        System.out.println("    Search:     Search for a product based on part of its name");
        System.out.println("    LowStock:   Print a list of low on stock products ");
        System.out.println("    Restock:    Restock low on stock products by a set amount");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();
    }

    /**
     * Print the title of the program and the authors name.
     */         
    private void printHeading()
    {
        System.out.println("\n******************************");
        System.out.println(" Stock Management Application ");
        System.out.println(" App05: by Mauro Duarte Nunes ");
        System.out.println("******************************");
    }
}