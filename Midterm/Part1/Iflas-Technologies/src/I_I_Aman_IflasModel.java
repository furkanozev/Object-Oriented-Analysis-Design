/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate I-I-Aman-Iflas phone.
 */
public class I_I_Aman_IflasModel extends Phone{
    /**
     * Constructor of I_I_Aman_IflasModel class.
     * Set componentFactory field in Phone class. So, it will be exclusive model with factory.
     * @param componentFactory  PhoneComponentFactory phone component factory
     */
    public I_I_Aman_IflasModel(PhoneComponentFactory componentFactory)
    {
        this.componentFactory = componentFactory;
    }

    /**
     * The I_I_Aman_Iflas model phone production steps of the phone are carried out in its own factory for the specified market.
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
     * Set display model specification for I_I_Aman_Iflas model phone.
     */
    public void DisplayModelSpec()
    {
        phoneDisplay.setModelSpec("4.5 inches");
    }

    /**
     * Set battery model specification for I_I_Aman_Iflas model phone.
     */
    public void BatteryModelSpec()
    {
        phoneBattery.setModelSpec("16h, 2000mAh");
    }

    /**
     * Set cpu and ram model specification for I_I_Aman_Iflas model phone.
     */
    public void CPU_RAMModelSpec()
    {
        phoneCpu_ram.setModelSpec("2.2GHz, 4GB");
    }

    /**
     * Set storage model specification for I_I_Aman_Iflas model phone.
     */
    public void StorageModelSpec()
    {
        phoneStorage.setModelSpec("MicroSD support, 16GB");
    }

    /**
     * Set camera model specification for I_I_Aman_Iflas model phone.
     */
    public void CameraModelSpec()
    {
        phoneCamera.setModelSpec("8Mp front, 5Mp rear");
    }

    /**
     * Set case model specification for I_I_Aman_Iflas model phone.
     */
    public void CaseModelSpec()
    {
        phoneCase.setModelSpec("143x69x7.3 mm waterproof, plastic");
    }
}