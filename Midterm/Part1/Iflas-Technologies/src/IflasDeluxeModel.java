/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate IflasDeluxeModel phone.
 */
public class IflasDeluxeModel extends Phone{

    /***
     * Constructor of IflasDeluxeModel class.
     * Set componentFactory field in Phone class. So, it will be exclusive model with factory.
     * @param componentFactory  PhoneComponentFactory phone component factory
     */
    public IflasDeluxeModel(PhoneComponentFactory componentFactory)
    {
        this.componentFactory = componentFactory;
    }

    /**
     * The IflasDeluxe model phone production steps of the phone are carried out in its own factory for the specified market.
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
     * Set display model specification for IflasDeluxe model phone.
     */
    public void DisplayModelSpec()
    {
        phoneDisplay.setModelSpec("5.3 inches");
    }

    /**
     * Set battery model specification for IflasDeluxe model phone.
     */
    public void BatteryModelSpec()
    {
        phoneBattery.setModelSpec("20h, 2800mAh");
    }

    /**
     * Set cpu and ram model specification for IflasDeluxe model phone.
     */
    public void CPU_RAMModelSpec()
    {
        phoneCpu_ram.setModelSpec("2.2GHz, 6GB");
    }

    /**
     * Set storage model specification for IflasDeluxe model phone.
     */
    public void StorageModelSpec()
    {
        phoneStorage.setModelSpec("MicroSD support, 32GB");
    }

    /**
     * Set camera model specification for IflasDeluxe model phone.
     */
    public void CameraModelSpec()
    {
        phoneCamera.setModelSpec("12Mp front, 5Mp rear");
    }

    /**
     * Set case model specification for IflasDeluxe model phone.
     */
    public void CaseModelSpec()
    {
        phoneCase.setModelSpec("149x73x7.7 mm waterproof, aluminum");
    }
}