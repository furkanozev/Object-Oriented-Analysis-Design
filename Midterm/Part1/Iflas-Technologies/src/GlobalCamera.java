/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Global camera specifications.
 * It derives from the Camera class, so it becomes the camera class specific to the Global market.
 */
public class GlobalCamera extends Camera{
    /***
     * Constructor of GlobalCamera class.
     * Set marketSpec field in Camera class. So, it will be exclusive market.
     */
    public GlobalCamera()
    {
        setMarketSpec("Opt. zoom x2");
    }
}