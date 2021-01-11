/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Global phone component factory.
 * It includes fundamental production functions in factories.
 * However, phones in the Global have different specifications, so they implement these functions differently.
 */
public class GlobalComponentFactory extends PhoneComponentFactory {
    /***
     * Constructor of GlobalComponentFactory class.
     * Set factory name as Global Component Factory
     */
    public GlobalComponentFactory()
    {
        factoryName = "Global Component Factory";
    }

    /***
     * It is for attach cpu and ram to the board process.
     * Create GlobalCPU_RAM object.
     * @return  CPU_RAM cpu and ram object
     */
    public CPU_RAM attachCPU_RAM()
    {
        return new GlobalCPU_RAM();
    }

    /***
     * It is for attach display process.
     * Create GlobalDisplay object.
     * @return  Display display object
     */
    public Display attachDisplay()
    {
        return new GlobalDisplay();
    }

    /***
     * It is for attach battery process.
     * Create GlobalBattery object.
     * @return  Battery battery object
     */
    public Battery attachBattery()
    {
        return new GlobalBattery();
    }

    /***
     * It is for attach storage process.
     * Create GlobalStorage object.
     * @return  Storage storage object
     */
    public Storage attachStorage()
    {
        return new GlobalStorage();
    }

    /***
     * It is for attach camera process.
     * Create GlobalCamera object.
     * @return  Camera camera object
     */
    public Camera attachCamera()
    {
        return new GlobalCamera();
    }

    /***
     * It is for enclose the phone case process.
     * Create GlobalCase object.
     * @return  Case case object
     */
    public Case encloseCase()
    {
        return new GlobalCase();
    }
}