/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Global battery specifications.
 * It derives from the Battery class, so it becomes the battery class specific to the Global market.
 */
public class GlobalBattery extends Battery{
    /***
     * Constructor of GlobalBattery class.
     * Set marketSpec field in Battery class. So, it will be exclusive market.
     */
    public GlobalBattery()
    {
        setMarketSpec("Lithium-Cobalt");
    }
}