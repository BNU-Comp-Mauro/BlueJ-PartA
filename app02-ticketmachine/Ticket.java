
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
    private String date;
    private int price;
    
    /**
     * Set values for the fields.
     */
    public Ticket(String destination, int price)
    {
        this.price = price;
        this.destination = destination;
    }

}
