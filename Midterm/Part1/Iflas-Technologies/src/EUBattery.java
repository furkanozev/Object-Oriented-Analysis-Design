/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the EU battery specifications.
 * It derives from the Battery class, so it becomes the battery class specific to the EU market.
 */
public class EUBattery extends Battery{
    /***
     * Constructor of EUBattery class.
     * Set marketSpec field in Battery class. So, it will be exclusive market.
     */
    public EUBattery()
    {
        setMarketSpec("Lithium-Ion");
    }
}