/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the EU phone component factory.
 * It includes fundamental production functions in factories.
 * However, phones in the EU have different specifications, so they implement these functions differently.
 */
public class EUComponentFactory extends PhoneComponentFactory {
    /***
     * Constructor of EUComponentFactory class.
     * Set factory name as EU Component Factory
     */
    public EUComponentFactory()
    {
        factoryName = "EU Component Factory";
    }

    /***
     * It is for attach cpu and ram to the board process.
     * Create EUCPU_RAM object.
     * @return  CPU_RAM cpu and ram object
     */
    public CPU_RAM attachCPU_RAM()
    {
        return new EUCPU_RAM();
    }

    /***
     * It is for attach display process.
     * Create EUDisplay object.
     * @return  Display display object
     */
    public Display attachDisplay()
    {
        return new EUDisplay();
    }

    /***
     * It is for attach battery process.
     * Create EUBattery object.
     * @return  Battery battery object
     */
    public Battery attachBattery()
    {
        return new EUBattery();
    }

    /***
     * It is for attach storage process.
     * Create EUStorage object.
     * @return  Storage storage object
     */
    public Storage attachStorage()
    {
        return new EUStorage();
    }

    /***
     * It is for attach camera process.
     * Create EUCamera object.
     * @return  Camera camera object
     */
    public Camera attachCamera()
    {
        return new EUCamera();
    }

    /***
     * It is for enclose the phone case process.
     * Create EUCase object.
     * @return  Case case object
     */
    public Case encloseCase()
    {
        return new EUCase();
    }
}
