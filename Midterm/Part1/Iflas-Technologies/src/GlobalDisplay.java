/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Global display specifications.
 * It derives from the Display class, so it becomes the display class specific to the Global market.
 */
public class GlobalDisplay extends Display{
    /***
     * Constructor of GlobalDisplay class.
     * Set marketSpec field in display class. So, it will be exclusive market.
     */
    public GlobalDisplay()
    {
        setMarketSpec("24 bit");
    }
}