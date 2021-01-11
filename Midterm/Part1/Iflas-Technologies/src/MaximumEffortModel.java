/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate MaximumEffortModel phone.
 */
public class MaximumEffortModel extends Phone{

    /***
     * Constructor of MaximumEffortModel class.
     * Set componentFactory field in Phone class. So, it will be exclusive model with factory.
     * @param componentFactory  PhoneComponentFactory phone component factory
     */
    public MaximumEffortModel(PhoneComponentFactory componentFactory)
    {
        this.componentFactory = componentFactory;
    }

    /**
     * The MaximumEffort model phone production steps of the phone are carried out in its own factory for the specified market.
     */
    public void createMarket()
    {
        phoneCpu_ram = componentFactory.attachCPU_RAM();
        phoneDisplay = componentFactory.attachDisplay();
        phoneBattery = componentFactory.attachBattery();
        phoneStorage = componentFactory.attachStorage();
        phoneCamera = componentFactory.attachCamera();
        phoneCase = componentFactory.encloseCase();
    }

    /**
     * Set display model specification for MaximumEffort model phone.
     */
    public void DisplayModelSpec()
    {
        phoneDisplay.setModelSpec("5.5 inches");
    }

    /**
     * Set battery model specification for MaximumEffort model phone.
     */
    public void BatteryModelSpec()
    {
        phoneBattery.setModelSpec("27h, 3600mAh");
    }

    /**
     * Set cpu and ram model specification for MaximumEffort model phone.
     */
    public void CPU_RAMModelSpec()
    {
        phoneCpu_ram.setModelSpec("2.8GHz, 8GB");
    }

    /**
     * Set storage model specification for MaximumEffort model phone.
     */
    public void StorageModelSpec()
    {
        phoneStorage.setModelSpec("MicroSD support, 64GB");
    }

    /**
     * Set camera model specification for MaximumEffort model phone.
     */
    public void CameraModelSpec()
    {
        phoneCamera.setModelSpec("12Mp front, 8Mp rear");
    }

    /**
     * Set case model specification for MaximumEffort model phone.
     */
    public void CaseModelSpec()
    {
        phoneCase.setModelSpec("151x73x7.7 mm dustproof, waterproof, aluminum");
    }
}