import java.util.ArrayList;
/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * Modified by Mauro Duarte Nunes
 * 21815118
 * 08/11/2020
 */
public class StockManager
{
    private ArrayList<Product> stock;
    private Product product;
    private int id;
    private String name;
    private StockDemo oldStock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
        this.id = id;
        product = new Product(id, name);
        this.name = name;
    }

    /**
     * Add a product to the list.
     */
    public void addProduct(Product product)
    {
        if(product != null)
        {
            if(product.getName().isBlank())
            {
                System.out.println("\n-----------------------------------");
                System.out.println("Error: Product name cannot be blank");
                System.out.println("-----------------------------------");
            }

            else
            {
                System.out.println("Added new product " + product);
                stock.add(product);
            }
        }
    }

    /**
     * Remove a product from the list.
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        if(product != null)
        {
            System.out.println("Removed an existing product " 
                + product);
            stock.remove(product);
        }
        else
        {
            System.out.println("\n--------------------------------");
            System.out.println("Error: Product ID does not exist");
            System.out.println("--------------------------------");
        }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);

        if(product != null && amount > 0)
        {
            System.out.println("Delivered " + amount + " item/s of product " + id + ": " + 
                product.getName());

            product.deliver(amount);
        }
        else if(amount <= 0)
        {
            System.out.println("\n----------------------------------------------");
            System.out.println("Error: Cannot deliver 0 or negative quantities");
            System.out.println("----------------------------------------------");
        }
        else if(product == null)
        {
            System.out.println("\n--------------------------------------------");
            System.out.println("Error: Product ID: " + id + " does not exist");
            System.out.println("--------------------------------------------");
        }    
    }

    /**
     * Sell a certain amount of a product.
     * Show the before and after status of the product.
     */
    public void sellProduct(int id, int amount)
    {
        Product product = findProduct(id);

        if(product != null) 
        {
            if(amount <= 0)
            {
                System.out.println("\n---------------------------------------");
                System.out.println("Error: Cannot sell 0 or negative amount");
                System.out.println("---------------------------------------");
            }
            else if(amount > product.getQuantity()) 
            {
                product.getQuantity();
            }
            else
            {
                System.out.println("\nSold " + amount + 
                    " item/s of product " + product.getID() + ": " +
                    product.getName());

                printProduct(id);

                for(int count = 0; count < amount; count++)
                {
                    product.sellAmount();
                }

                printProduct(id);
            }
        }
    }

    /**
     * Print a product according to part of its name.
     */
    public void searchProduct(String name)
    {   
        for(Product product: stock)
        {
            if(product.getName().toLowerCase().contains(name))
            {
                System.out.println(product.toString());
            }
        }
    }

    /**
     * Print alert for products low on stock.
     */
    public void printLowStockProducts(int lowStockLevel)
    {
        System.out.println();
        for(Product product: stock)
        {
            if(product.getQuantity() <= lowStockLevel)
            {
                System.out.println(product);
            }
        }
    }

    /**
     * Restock products low on stock.
     */
    public void restockProducts(int lowStockLevel, int restockLevel)
    {
        System.out.println("\nThe following products were restocked by " + restockLevel + 
            ":");
        System.out.println();
        for(Product product : stock)
        {
            if(product.getQuantity() <= lowStockLevel)
            {
                System.out.println(product.getID() + 
                    ": " + product.getName() + " [Stock Level: " + 
                    (product.getQuantity() + restockLevel) + "]");
                product.deliver(restockLevel);
            }
        }
    }

    /**
     * Print details of all the products.
     */
    public void printAllProducts()
    {
        System.out.println("====================");
        System.out.println(" Mauro's Stock List");
        System.out.println("====================");
        System.out.println();

        for(Product product : stock)
        {
            System.out.println(product);
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * Return the identified product, or null if there is none
     * with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if(product.getID() == id)
            {
                return product;
            }
        }

        return null;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);

        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
}