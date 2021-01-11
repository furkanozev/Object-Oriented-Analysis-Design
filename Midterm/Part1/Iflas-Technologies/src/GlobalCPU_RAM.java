/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Global cpu and ram specifications.
 * It derives from the CPU_RAM class, so it becomes the cpu and ram class specific to the Global market.
 */
public class GlobalCPU_RAM extends CPU_RAM{
    /***
     * Constructor of GlobalCPU_RAM class.
     * Set marketSpec field in cpu and ram class. So, it will be exclusive market.
     */
    public GlobalCPU_RAM()
    {
        setMarketSpec("2 cores");
    }
}