/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 * It is a Modern Payment Concrete class.
 * A concrete class created to create the object of the ModernPayment class for test.
 */
public class ModernPaymentConcrete implements ModernPayment{
    /**
     * It is an modern function to pay credit card payment.
     * Print informations of modern payment
     * @param cardNo    String  Credit Card No
     * @param amount    float   Amount
     * @param destination   String  Destination
     * @param installments  String  Installments
     * @return  int Amount
     */
    public int pay(String cardNo, float amount, String destination, String installments){
        System.out.println("### Paying with Modern Payment ###"
        + "\n\t-> Card No: " + cardNo
        + "\n\t-> Amount: " + amount
        + "\n\t-> Destination: " + destination
        + "\n\t-> Installments: " + installments
        + "\n### Paying is done! ###\n");

        return (int)amount;
    }
}
