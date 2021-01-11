/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the EU camera specifications.
 * It derives from the Camera class, so it becomes the camera class specific to the EU market.
 */
public class EUCamera extends Camera{
    /***
     * Constructor of EUCamera class.
     * Set marketSpec field in Camera class. So, it will be exclusive market.
     */
    public EUCamera()
    {
        setMarketSpec("Opt. zoom x3");
    }
}