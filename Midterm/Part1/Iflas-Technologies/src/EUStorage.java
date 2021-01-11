/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the EU storage specifications.
 * It derives from the Storage class, so it becomes the storage class specific to the EU market.
 */
public class EUStorage extends Storage{
    /***
     * Constructor of EUStorage class.
     * Set marketSpec field in storage class. So, it will be exclusive market.
     */
    public EUStorage()
    {
        setMarketSpec("Max 64 GB");
    }
}