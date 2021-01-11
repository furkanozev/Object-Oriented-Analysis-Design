/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the phone component factory.
 * It includes fundamental production functions in factories.
 */
public abstract class PhoneComponentFactory {
    /***
     * It keeps the factory name
     */
    protected String factoryName;

    /***
     * Get the factory name
     * @return  String  factoryName
     */
    public String getFactoryName() {
        return factoryName;
    }

    /***
     * It is for attach cpu and ram to the board process.
     * @return  CPU_RAM cpu and ram object
     */
    public abstract CPU_RAM attachCPU_RAM();

    /***
     * It is for attach display process.
     * @return  Display display object
     */
    public abstract Display attachDisplay();

    /***
     * It is for attach battery process.
     * @return  Battery battery object
     */
    public abstract Battery attachBattery();

    /***
     * It is for attach storage process.
     * @return  Storage storage object
     */
    public abstract Storage attachStorage();

    /***
     * It is for attach camera process.
     * @return  Camera camera object
     */
    public abstract Camera attachCamera();

    /***
     * It is for enclose the phone case process.
     * @return  Case case object
     */
    public abstract Case encloseCase();
}