/**
 * This class is responsible for running the program.
 *
 * Modified by Mauro Duarte Nunes
 * 21815118
 * 08/11/2020
 */
public class Program
{
    private static StockApp app;
    
    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main()
    {
        app = new StockApp();
        app.run();
    }
}