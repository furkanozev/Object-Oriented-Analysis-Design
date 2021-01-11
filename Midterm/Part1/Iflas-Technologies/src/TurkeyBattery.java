/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Turkey battery specifications.
 * It derives from the Battery class, so it becomes the battery class specific to the Turkey market.
 */
public class TurkeyBattery extends Battery{
    /***
     * Constructor of TurkeyBattery class.
     * Set marketSpec field in Battery class. So, it will be exclusive market.
     */
    public TurkeyBattery()
    {
        setMarketSpec("Lithium-Boron");
    }
}