
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
     * 
     */
    public void run()
    {
        getMenuChoice();
    }

    /**
     * 
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
     * 
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
        
        manager.removeProduct(id);
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
        System.out.println("    Remove:     Remove an old product");
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
