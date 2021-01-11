/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the markets.
 * It includes create and order phone operations from market.
 */
public abstract class Markets {
    /***
     * It asks for the desired phone model to be created.
     * @param model  Models  Phone Model
     * @return  Phone   desired phone model from desired market.
     */
    protected abstract Phone createPhone(Models model);

    /***
     * It orders the desired phone model.
     * It create phone in desired market, It uses the production functions of factories while performing the creation process.
     * It also adds the basic features of the model to the phone.
     * It prints the production stages to the terminal here.
     * @param type  Models  Phone Model
     * @return  Phone   desired phone model from desired market.
     */
    public Phone orderPhone(Models type){
        System.out.println("-> Phone order has been received.");
        Phone phone = createPhone(type);
        String factory = phone.getPhoneComponentFactoryName();

        phone.createMarket();

        System.out.println("-> Processes:\n");

        phone.CPU_RAMModelSpec();
        CPU_RAM phoneCpu_ram = phone.getPhoneCpu_ram();
        System.out.println("\t* attach " + phoneCpu_ram.getModelSpec() + ", " + phoneCpu_ram.getMarketSpec()  + " CPU in " + factory);

        phone.DisplayModelSpec();
        Display phoneDisplay = phone.getPhoneDisplay();
        System.out.println("\t* attach " + phoneDisplay.getModelSpec() + ", " + phoneDisplay.getMarketSpec()  + " Display in " + factory);

        phone.BatteryModelSpec();
        Battery phoneBattery = phone.getPhoneBattery();
        System.out.println("\t* attach " + phoneBattery.getModelSpec() + ", " + phoneBattery.getMarketSpec()  + " Battery in " + factory);

        phone.StorageModelSpec();
        Storage phoneStorage = phone.getPhoneStorage();
        System.out.println("\t* attach " + phoneStorage.getModelSpec() + ", " + phoneStorage.getMarketSpec()  + " Storage in " + factory);

        phone.CameraModelSpec();
        Camera phoneCamera = phone.getPhoneCamera();
        System.out.println("\t* attach " + phoneCamera.getModelSpec() + ", " + phoneCamera.getMarketSpec()  + " Camera in " + factory);

        phone.CaseModelSpec();
        Case phoneCase = phone.getPhoneCase();
        System.out.println("\t* attach " + phoneCase.getModelSpec() + ", " + phoneCase.getMarketSpec()  + " Case in " + factory);

        return phone;
    }
}
