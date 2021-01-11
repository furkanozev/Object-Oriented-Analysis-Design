/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Turkey display specifications.
 * It derives from the Display class, so it becomes the display class specific to the Turkey market.
 */
public class TurkeyDisplay extends Display{
    /***
     * Constructor of TurkeyDisplay class.
     * Set marketSpec field in display class. So, it will be exclusive market.
     */
    public TurkeyDisplay()
    {
        setMarketSpec("32 bit");
    }
}