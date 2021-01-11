/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the Turkey phone component factory.
 * It includes fundamental production functions in factories.
 * However, phones in the Turkey have different specifications, so they implement these functions differently.
 */
public class TurkeyComponentFactory extends PhoneComponentFactory {
    /***
     * Constructor of TurkeyComponentFactory class.
     * Set factory name as Turkey Component Factory
     */
    public TurkeyComponentFactory()
    {
        factoryName = "Turkey Component Factory";
    }

    /***
     * It is for attach cpu and ram to the board process.
     * Create TurkeyCPU_RAM object.
     * @return  CPU_RAM cpu and ram object
     */
    public CPU_RAM attachCPU_RAM()
    {
        return new TurkeyCPU_RAM();
    }

    /***
     * It is for attach display process.
     * Create TurkeyDisplay object.
     * @return  Display display object
     */
    public Display attachDisplay()
    {
        return new TurkeyDisplay();
    }

    /***
     * It is for attach battery process.
     * Create TurkeyBattery object.
     * @return  Battery battery object
     */
    public Battery attachBattery()
    {
        return new TurkeyBattery();
    }

    /***
     * It is for attach storage process.
     * Create TurkeyStorage object.
     * @return  Storage storage object
     */
    public Storage attachStorage()
    {
        return new TurkeyStorage();
    }

    /***
     * It is for attach camera process.
     * Create TurkeyCamera object.
     * @return  Camera camera object
     */
    public Camera attachCamera()
    {
        return new TurkeyCamera();
    }

    /***
     * It is for enclose the phone case process.
     * Create TurkeyCase object.
     * @return  Case case object
     */
    public Case encloseCase()
    {
        return new TurkeyCase();
    }
}
