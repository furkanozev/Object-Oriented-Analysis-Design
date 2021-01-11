/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Global case specifications.
 * It derives from the Case class, so it becomes the case class specific to the Global market.
 */
public class GlobalCase extends Case{
    /***
     * Constructor of GlobalCase class.
     * Set marketSpec field in Case class. So, it will be exclusive market.
     */
    public GlobalCase()
    {
        setMarketSpec("Waterproof up to 50cm");
    }
}