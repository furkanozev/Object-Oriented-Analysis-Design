/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Turkey cpu and ram specifications.
 * It derives from the CPU_RAM class, so it becomes the cpu and ram class specific to the Turkey market.
 */
public class TurkeyCPU_RAM extends CPU_RAM{
    /***
     * Constructor of TurkeyCPU_RAM class.
     * Set marketSpec field in cpu and ram class. So, it will be exclusive market.
     */
    public TurkeyCPU_RAM()
    {
        setMarketSpec("8 cores");
    }
}