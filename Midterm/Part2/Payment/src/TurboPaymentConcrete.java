/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 * It is a Turbo Payment Concrete class.
 * A concrete class created to create the object of the TurboPayment class for test.
 */
public class TurboPaymentConcrete implements TurboPayment {
    /**
     * It is an old library function to pay credit card payment.
     * Print informations of turbo payment
     * @param turboCardNo   String  Credit Card No
     * @param turboAmount   float   Amount
     * @param destinationTurboOfCourse  String  Destination
     * @param installmentsButInTurbo    String  Installments
     * @return  int Amount
     */
    public int payInTurbo(String turboCardNo, float turboAmount,
                          String destinationTurboOfCourse, String installmentsButInTurbo){
        System.out.println("### Paying with Turbo Payment ###"
        + "\n\t-> Card No: " + turboCardNo
        + "\n\t-> Amount: " + turboAmount
        + "\n\t-> Destination: " + destinationTurboOfCourse
        + "\n\t-> Installments: " + installmentsButInTurbo
        + "\n### Paying is done! ###\n");

        return (int)turboAmount;
    }
}
