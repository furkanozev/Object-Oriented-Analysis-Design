/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate phone.
 */
public abstract class Phone {
    /**
     * Keep the factory of phone
     */
    protected PhoneComponentFactory componentFactory;

    /**
     * To keep phone model with specifications
     */
    protected String name;

    /**
     * phone Display object
     */
    protected Display phoneDisplay;
    /**
     * phone Battery object
     */
    protected Battery phoneBattery;
    /**
     * phone Cpu and Ram object
     */
    protected CPU_RAM phoneCpu_ram;
    /**
     * phone Storage object
     */
    protected Storage phoneStorage;
    /**
     * phone Camera object
     */
    protected Camera phoneCamera;
    /**
     * phone Case object
     */
    protected Case phoneCase;

    /**
     * Create Market for creation phone
     */
    public abstract void createMarket();

    /**
     * Set display model specification for phone.
     */
    public abstract void DisplayModelSpec();

    /**
     * Set battery model specification for phone.
     */
    public abstract void BatteryModelSpec();

    /**
     * Set cpu and ram model specification for phone.
     */
    public abstract void CPU_RAMModelSpec();

    /**
     * Set storage model specification for phone.
     */
    public abstract void StorageModelSpec();

    /**
     * Set camera model specification for phone.
     */
    public abstract void CameraModelSpec();

    /**
     * Set case model specification for phone.
     */
    public abstract void CaseModelSpec();

    /**
     * Set phone name
     * @param name  String  phone name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of phone name with model and market.
     * @return  String  phone model and market
     */
    public String getName() {
        return name;
    }

    /**
     * Get phone component factory name
     * @return  String  factory name
     */
    public String getPhoneComponentFactoryName(){
        return componentFactory.getFactoryName();
    }

    /**
     * Get phone display object
     * @return  Display phoneDisplay
     */
    public Display getPhoneDisplay(){
        return phoneDisplay;
    }

    /**
     * Get phone battery object
     * @return  Battery phoneBattery
     */
    public Battery getPhoneBattery(){
        return phoneBattery;
    }

    /**
     * Get phone cpu and ram object
     * @return  CPU_RAM phoneCpu_ram
     */
    public CPU_RAM getPhoneCpu_ram(){
        return phoneCpu_ram;
    }

    /**
     * Get phone storage object
     * @return  Storage phoneStorage
     */
    public Storage getPhoneStorage(){
        return phoneStorage;
    }

    /**
     * Get phone camera object
     * @return  Camera  phoneCamera
     */
    public Camera getPhoneCamera(){
        return phoneCamera;
    }

    /**
     * Get phone case object
     * @return  Case    phoneCase
     */
    public Case getPhoneCase(){
        return phoneCase;
    }

    /**
     * Print phone model with specifications
     * @return  String  phone specifications
     */
    public String toString()
    {
        StringBuffer result = new StringBuffer();
        result.append("---- " + name + " ----\n");

        if(phoneDisplay != null)
        {
            result.append("DISPLAY: " + phoneDisplay.getModelSpec() + ", " + phoneDisplay.getMarketSpec() + "\n");
        }

        if(phoneBattery != null)
        {
            result.append("BATTERY: " + phoneBattery.getModelSpec() + ", " + phoneBattery.getMarketSpec() + "\n");
        }

        if(phoneCpu_ram != null)
        {
            result.append("CPU&RAM: " + phoneCpu_ram.getModelSpec() + ", " + phoneCpu_ram.getMarketSpec() + "\n");
        }

        if(phoneStorage != null)
        {
            result.append("STORAGE: " + phoneStorage.getModelSpec() + ", " + phoneStorage.getMarketSpec() + "\n");
        }

        if(phoneCamera != null)
        {
            result.append("CAMERA: " + phoneCamera.getModelSpec() + ", " + phoneCamera.getMarketSpec() + "\n");
        }

        if(phoneCase != null)
        {
            result.append("CASE: " + phoneCase.getModelSpec() + ", " + phoneCase.getMarketSpec() + "\n");
        }

        return result.toString();
    }
}
