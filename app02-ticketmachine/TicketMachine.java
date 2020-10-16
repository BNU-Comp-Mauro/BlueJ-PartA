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
    private Ticket selectedTicket;

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
    public void insert10Pence()
    {
        balance = balance + 10;
        System.out.println("Amount entered: 10 pence");
        System.out.println("Balance available: " + balance + " pence");
        System.out.println();
    }

    /**
     * Add 20p coins to the balance.
     */
    public void insert20Pence()
    {
        balance = balance + 20;
        System.out.println("Amount entered: 20 pence");
        System.out.println("Balance available: " + balance + " pence");
        System.out.println();
    }

    /**
     * Add £1 coins to the balance.
     */
    public void insert100Pence()
    {
        balance = balance + 100;
        System.out.println("Amount entered: 100 pence");
        System.out.println("Balance available: " + balance + " pence");
        System.out.println();
    }

    /**
     * Add £2 coins to the balance.
     */
    public void insert200Pence()
    {
        balance = balance + 200;
        System.out.println("Amount entered: 200 pence");
        System.out.println("Balance available: " + balance + " pence");
        System.out.println();
    }

    public void selectTicket(String destination)
    {
        destination = destination.toLowerCase();
        if(destination.startsWith("ayl"))
        {
            selectedTicket = aylesburyTicket;
            printTicket();
        }
        else if(destination.startsWith("ame"))
        {
            selectedTicket = amershamTicket;
            printTicket();
        }
        else if(destination.startsWith("hig"))
        {
            selectedTicket = highWycombeTicket;
            printTicket();
        }
        else
        {
            System.out.println("You must enter one of these destinations:");
            System.out.println();
            printAllTickets();
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    private void printTicket()
    {
        if(balance >= selectedTicket.getPrice())
        {
            // Simulate the printing of a ticket.
            printHeading();

            selectedTicket.print();

            // Update the total collected with the price.
            total = total + selectedTicket.getPrice();
            // Reduce the balance by the price.
            balance = balance - selectedTicket.getPrice();
        }
        else 
        {
            System.out.println("You must insert at least " +
                (selectedTicket.getPrice() - balance) + " more cents.");
            System.out.println();
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
        aylesburyTicket.print();
        amershamTicket.print();
        highWycombeTicket.print();
        System.out.println();
    }

    /**
     * This method prints the ticket heading;
     */
    private void printHeading()
    {
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# by Mauro");
        System.out.println("##################");
    }
}
