/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * It is a pre-made demo.
 * Includes ready-made examples.
 * It automatically runs these examples.
 */
public class Main {

    /**
     * Main for Ready (Pre-made) Demo
     * @param args String
     */
    public static void main(String[] args){

        System.out.println("\n----- TURKEY MARKET TESTS -----");
        Markets turkeyMarket = new TurkeyMarket();

        Phone phone = turkeyMarket.orderPhone(Models.MaximumEffort);
        System.out.println("\nAfter processes, Result:\n" + phone);
        System.out.println("---------------------------------------------------");

        phone = turkeyMarket.orderPhone(Models.IflasDeluxe);
        System.out.println("\nAfter processes, Result:\n" + phone);
        System.out.println("---------------------------------------------------");

        phone = turkeyMarket.orderPhone(Models.I_I_Aman_Iflas);
        System.out.println("\nAfter processes, Result:\n" + phone);
        System.out.println("---------------------------------------------------");

        System.out.println("\n----- EU MARKET TESTS -----");
        Markets euMarket = new EUMarket();

        phone = euMarket.orderPhone(Models.MaximumEffort);
        System.out.println("\nAfter processes, Result:\n" + phone);
        System.out.println("---------------------------------------------------");

        phone = euMarket.orderPhone(Models.IflasDeluxe);
        System.out.println("\nAfter processes, Result:\n" + phone);
        System.out.println("---------------------------------------------------");

        phone = euMarket.orderPhone(Models.I_I_Aman_Iflas);
        System.out.println("\nAfter processes, Result:\n" + phone);
        System.out.println("---------------------------------------------------");

        System.out.println("\n----- GLOBAL MARKET TESTS -----");
        Markets globalMarket = new GlobalMarket();

        phone = globalMarket.orderPhone(Models.MaximumEffort);
        System.out.println("\nAfter processes, Result:\n" + phone);
        System.out.println("---------------------------------------------------");

        phone = globalMarket.orderPhone(Models.IflasDeluxe);
        System.out.println("\nAfter processes, Result:\n" + phone);
        System.out.println("---------------------------------------------------");

        phone = globalMarket.orderPhone(Models.I_I_Aman_Iflas);
        System.out.println("\nAfter processes, Result:\n" + phone);
        System.out.println("---------------------------------------------------");
    }
}