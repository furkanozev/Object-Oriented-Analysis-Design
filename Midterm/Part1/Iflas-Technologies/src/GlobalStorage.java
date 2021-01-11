/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Global storage specifications.
 * It derives from the Storage class, so it becomes the storage class specific to the Global market.
 */
public class GlobalStorage extends Storage{
    /***
     * Constructor of GlobalStorage class.
     * Set marketSpec field in storage class. So, it will be exclusive market.
     */
    public GlobalStorage()
    {
        setMarketSpec("Max 32 GB");
    }
}