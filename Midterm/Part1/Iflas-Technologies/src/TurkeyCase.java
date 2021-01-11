/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Turkey case specifications.
 * It derives from the Case class, so it becomes the case class specific to the Turkey market.
 */
public class TurkeyCase extends Case{
    /***
     * Constructor of TurkeyCase class.
     * Set marketSpec field in Case class. So, it will be exclusive market.
     */
    public TurkeyCase()
    {
        setMarketSpec("Waterproof up to 2m");
    }
}