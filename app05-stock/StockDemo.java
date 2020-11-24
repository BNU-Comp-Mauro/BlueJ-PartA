import java.util.Random;

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * Modified by Mauro Duarte Nunes
 * 21815118
 * 08/11/2020
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    
    private Random randomGenerator;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        randomGenerator = new Random();
        
        manager.addProduct(new Product(101, "Tesla Model S"));
        manager.addProduct(new Product(102, "Tesla Model 3"));
        manager.addProduct(new Product(103, "Tesla Model X"));
        manager.addProduct(new Product(104, "Tesla Model Y"));
        manager.addProduct(new Product(105, "Ford Fiesta"));
        manager.addProduct(new Product(106, "Ford Focus"));
        manager.addProduct(new Product(107, "Opel Astra"));
        manager.addProduct(new Product(108, "Skoda Otavia"));
        manager.addProduct(new Product(109, "Citroen C4"));
        manager.addProduct(new Product(110, "Porsche Panamera"));
        manager.addProduct(new Product(111, "BMW i8"));
    }
    
    /**
     * This method runs all the tests necessary to demonstrate that every
     * requirement has been met.
     */
    public void runDemo()
    {
        manager.printAllProducts();
        demoDeliverProducts();
        System.out.println();
        manager.printAllProducts();
        demoSellProducts();
        System.out.println();
        manager.printAllProducts();
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    private void demoDeliverProducts()
    {
        int quantity = 0;
        
        for(int id = 101; id <= 111; id++)
        {
            quantity = randomGenerator.nextInt(8);
            manager.deliverProduct(id, quantity);
        }
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    private void demoSellProducts()
    {
        int quantity = 0;
        
        for(int id = 101; id <= 111; id++)
        {
            quantity = randomGenerator.nextInt(4);
            manager.sellProduct(id, quantity);
        }
    }
}