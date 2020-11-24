
/**
 * Model some details of a product sold by a company.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * Modified by Mauro Duarte Nunes
 * 21815118
 * 08/11/2020
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * Get the product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * Get the product's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the quantity in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
     * Return the id, name and quantity in stock.
     */
    public String toString()
    {
        return id + ": " +  name + " [Stock Level: " + quantity + "]";
    }

    /**
     * Deliver given amount of this product.
     */
    public void deliver(int amount)
    {
        if(amount > 0) 
        {
            quantity += amount;
        }
        else 
        {
            System.out.println("Attempt to restock " + name +
                               " with a non-positive amount: " + amount);
        }
    }

    /**
     * Sell one of these products.
     * An error is reported if there appears to be no stock.
     */
    public void sellAmount()
    {
        if(quantity > 0) 
        {
            quantity --;
        }
        else 
        {
            System.out.println();
            System.out.println(
                "Attempt to sell an out of stock item: " + name);
            System.out.println();
        }
    }
}