
/**
 * Store the possible coin values to be inserted by the user.
 *
 * Mauro Duarte Nunes
 * 21815118
 * 13/10/2020
 */
public enum Coin
{
    P10 (10),
    P20 (20),
    P100 (100),
    P200 (200);

    private final int value;

    private Coin(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}