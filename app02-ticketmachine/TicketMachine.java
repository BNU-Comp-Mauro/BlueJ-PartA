/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Mauro Duarte Nunes
 * 21815118
 * 13/10/2020
 */
public class TicketMachine
{
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    private Ticket aylesburyTicket;
    private Ticket amershamTicket;
    private Ticket highWycombeTicket;
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        balance = 0;
        total = 0;

        aylesburyTicket = new Ticket("Aylesbury", 220);
        amershamTicket = new Ticket("Amersham", 300);
        highWycombeTicket = new Ticket("High Wycombe", 330);
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * This simulates a tap and pay way of paying.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                amount);
        }
    }

    /**
     * Add 10p coins to the balance.
     */
    public int insert10()
    {
        int amountEntered;
        amountEntered = 10;
        balance = balance + 10;
        return amountEntered;
    }

    /**
     * Add 20p coins to the balance.
     */
    public int insert20()
    {
        int amountEntered;
        amountEntered = 20;
        balance = balance + 20;
        return amountEntered;
    }

    /**
     * Add £1 coins to the balance.
     */
    public int insert100()
    {
        int amountEntered;
        amountEntered = 100;
        balance = balance + 100;
        return amountEntered;
    }

    /**
     * Add £2 coins to the balance.
     */
    public int insert200()
    {
        int amountEntered;
        amountEntered = 200;
        balance = balance + 200;
        return amountEntered;
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        int price = 500; // CHANGE THIS LATER PLEASE
        if(balance >= price)
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                (price - balance) + " more cents.");

        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    /**
     * This method will print out all available tickets.
     */
    public void printAllTickets()
    {
        printHeading();

        System.out.println();
        System.out.println("Available tickets:");
        System.out.println();
        aylesburyTicket.print();
        System.out.println();
        amershamTicket.print();
        System.out.println();
        highWycombeTicket.print();
        System.out.println();
    }

    /**
     * This method prints the ticket heading;
     */
    public void printHeading()
    {
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# by Mauro");
        System.out.println("##################");
        System.out.println();
    }
}
