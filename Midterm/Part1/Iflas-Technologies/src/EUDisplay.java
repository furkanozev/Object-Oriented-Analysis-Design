/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the EU display specifications.
 * It derives from the Display class, so it becomes the display class specific to the EU market.
 */
public class EUDisplay extends Display{
    /***
     * Constructor of EUDisplay class.
     * Set marketSpec field in display class. So, it will be exclusive market.
     */
    public EUDisplay()
    {
        setMarketSpec("24 bit");
    }
}