/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Turkey storage specifications.
 * It derives from the Storage class, so it becomes the storage class specific to the Turkey market.
 */
public class TurkeyStorage extends Storage{
    /***
     * Constructor of TurkeyStorage class.
     * Set marketSpec field in storage class. So, it will be exclusive market.
     */
    public TurkeyStorage()
    {
        setMarketSpec("Max 128 GB");
    }
}