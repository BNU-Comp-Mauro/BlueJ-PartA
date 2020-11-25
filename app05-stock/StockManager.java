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

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     */
    public void addProduct(Product product)
    {
        stock.add(product);
    }

    /**
     * Remove a product from the stock list based on its ID.
     */
    public void removeProduct(Product product)
    {
        for(int i = 0; i < stock.size(); i++)
        {
            if(stock.get(i).getName().equalsIgnoreCase(product.getName()))
            {
                stock.remove(i);
            }
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
                System.out.println("\n-----------------------------------------------------------");
                System.out.println("Error: Attempt to sell a larger quantity than current stock");
                System.out.println("-----------------------------------------------------------");
            }
            else
            {
                System.out.println("\nSold " + amount + 
                    " item/s of product " + product.getID() + ": " + product.getName());

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
     * Print a product according to parts of its name.
     */
    public void searchProduct(String name)
    {   
        for(Product product: stock)
        {
            if(product.getName().toLowerCase().contains(name))
            {
                System.out.println(product.toString());
            }
            //System.out.println("There are no products containing the 
            //keyword" + "'" + name + "'");
        }
    }

    /**
     * Print alert for items low on stock.
     */
    public void printLowStockProducts()
    {
        for(Product product: stock)
        {
            if(product.getQuantity() <= 1)
            {
                System.out.println(product);
            }
        }
    }

    /**
     * Print alert for items low on stock.
     */
    public void restockProducts(int lowStockLevel, int restockLevel)
    {
        for(Product product : stock)
        {
            if(product.getQuantity() < lowStockLevel)
            {
                product.deliver(restockLevel);
                System.out.println(product.getName() + " Low Stock");
                System.out.println("Has been restocked to " + restockLevel);
            }
        }
    }
}