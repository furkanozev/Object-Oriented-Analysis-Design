/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the EU cpu and ram specifications.
 * It derives from the CPU_RAM class, so it becomes the cpu and ram class specific to the EU market.
 */
public class EUCPU_RAM extends CPU_RAM{
    /***
     * Constructor of EUCPU_RAM class.
     * Set marketSpec field in cpu andram class. So, it will be exclusive market.
     */
    public EUCPU_RAM()
    {
        setMarketSpec("4 cores");
    }
}