/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the EU case specifications.
 * It derives from the Case class, so it becomes the case class specific to the EU market.
 */
public class EUCase extends Case{
    /***
     * Constructor of EUCase class.
     * Set marketSpec field in Case class. So, it will be exclusive market.
     */
    public EUCase()
    {
        setMarketSpec("Waterproof up to 1m");
    }
}