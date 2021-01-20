import java.util.Date;
/**
 * Write a description of class Ticket here.
 *
 * Mauro Duarte Nunes
 * 21815118
 * 14/10/2020
 */
public class Ticket
{
    private String destination;
    private Date dateTime;
    private int price;

    /**
     * Set values for the fields.
     */
    public Ticket(String destination, int price)
    {
        this.price = price;
        this.destination = destination;
        dateTime = new Date();
    }

    public int getPrice()
    {
        return price;
    }
    
    /**
     * Set the text for the print method for the 3 different destinations.
     */
    public void print()
    {
        System.out.println();
        System.out.print("Ticket to " + destination);
        System.out.print(": " + price + " pence.");
        System.out.println(" Issued @ " + dateTime);
        System.out.println();
    }
}