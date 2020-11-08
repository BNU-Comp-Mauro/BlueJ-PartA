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
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);
        
        if(product!=null)
            product.deliver(amount);
        else
            System.out.println("Invalid Product ID: " + id);
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
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
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        return 0;
    }

    /**
     * Print details of all the products.
     */
    public void printAllProducts()
    {
        System.out.println("Mauro's Stock List");
        System.out.println("===================");
        System.out.println();

        for(Product product : stock)
        {
            System.out.println(product);
        }
 
        System.out.println();
    }

    /**
     * Print alert for items low on stock.
     */
    private Product printLowStockProducts(int quantity, int id, String name)
    {
        if(quantity > 0 && quantity <=2)
        {
            System.out.println("The following item is low on stock:");
            System.out.println(id + ", " + name + ", quantity:" + quantity);
        }
        return null;
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id, int quantity)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            printProduct(id);
            for(int count = 0; count <= quantity; count++)
            {
                product.sellOne();
            }
            product.sellOne();
            printProduct(id);
        }
    }
}

