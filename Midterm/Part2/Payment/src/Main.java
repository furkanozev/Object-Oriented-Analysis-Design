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

        String cardNo, destination, installments;
        float amount;

        System.out.println("\n--------------------------------------\n");

        cardNo = "4829-4828-3492";
        amount  = (float) 2500.79;
        destination = "Credit Card 1";
        installments = "9";

        System.out.println("### Turbo Payment Object ###");
        System.out.println("\t-> Real Type: TurboPaymentConcrete \t-> Declared Type: TurboPayment\n");
        TurboPayment turboPayment = new TurboPaymentConcrete();
        turboPayment.payInTurbo(cardNo, amount, destination, installments);
        System.out.println();

        System.out.println("--------------------------------------\n");

        cardNo = "5713-3390-4512";
        amount  = (float) 1037.80;
        destination = "Credit Card 2";
        installments = "4";

        System.out.println("### Modern Payment Object ###");
        System.out.println("\t-> Real Type: ModernPaymentConcrete \t-> Declared Type: ModernPaymentConcrete\n");
        ModernPayment modernPayment = new ModernPaymentConcrete();
        modernPayment.pay(cardNo, amount, destination, installments);
        System.out.println();

        System.out.println("--------------------------------------\n");

        cardNo = "6783-9901-3867";
        amount  = (float) 637.06;
        destination = "Credit Card 3";
        installments = "2";

        System.out.println("### Adaptor Object for paying Modern In Turbo ###");
        System.out.println("\t-> Real Type: ModernPaymentConcrete \t-> Declared Type: TurboPayment\n");
        TurboPayment payment = new ModernPaymentAdapter(modernPayment);
        payment.payInTurbo(cardNo, amount, destination, installments);

        System.out.println("--------------------------------------\n");
    }
}
