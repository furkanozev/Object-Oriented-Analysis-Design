/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the EU market.
 * It includes create and order phone operations from market.
 * However, phones in the EU have different specifications, so they implement these functions differently.
 */
public class EUMarket extends Markets{
    /***
     * Constructor of EUMarket class.
     * Print the creation message on terminal
     */
    public EUMarket()
    {
        System.out.println("### EU Market is created. ###\n");
    }

    /***
     * It asks for the desired phone model to be created.
     * The phone is manufactured in EU factories in accordance with EU Market standards.
     * @param model  Models  Phone Model
     * @return  Phone   desired phone model from desired market.
     */
    protected Phone createPhone(Models model)
    {
        Phone phone = null;
        PhoneComponentFactory componentFactory = new EUComponentFactory();

        switch(model){
            case MaximumEffort:
                phone = new MaximumEffortModel(componentFactory);
                phone.setName("EU - MaximumEffort Model");
                break;
            case IflasDeluxe:
                phone = new IflasDeluxeModel(componentFactory);
                phone.setName("EU - IflasDeluxe Model");
                break;
            case I_I_Aman_Iflas:
                phone = new I_I_Aman_IflasModel(componentFactory);
                phone.setName("EU - I-I-Aman-Iflas Model");
                break;
        }
        System.out.println("-> Phone model is: " + phone.getName());

        return phone;
    }
}