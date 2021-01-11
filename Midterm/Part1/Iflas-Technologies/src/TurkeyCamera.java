/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Turkey camera specifications.
 * It derives from the Camera class, so it becomes the camera class specific to the Turkey market.
 */
public class TurkeyCamera extends Camera{
    /***
     * Constructor of TurkeyCamera class.
     * Set marketSpec field in Camera class. So, it will be exclusive market.
     */
    public TurkeyCamera()
    {
        setMarketSpec("Opt. zoom x4");
    }
}