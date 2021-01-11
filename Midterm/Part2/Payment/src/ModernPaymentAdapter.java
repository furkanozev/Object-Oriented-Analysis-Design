/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 * It is a Modern Payment Adapter class.
 * It is the adapter class that adapts TurboPayment to the ModernPayment interface.
 */
public class ModernPaymentAdapter implements TurboPayment{
    /**
     * modernPayment field.
     */
    private ModernPayment modernPayment;

    /**
     * It is the constructor function of the class that will convert from TurboPayment to ModernPayment.
     * @param modernPayment ModernPayment   modernPayment
     */
    public ModernPaymentAdapter(ModernPayment modernPayment){
        this.modernPayment = modernPayment;
    }

    /**
     * Override payInTurbo function.
     * It acts as an adapter by calling the modernPayment's pay () function being TurboPayment.
     * @param turboCardNo   String  Credit Card No
     * @param turboAmount   float   Amount
     * @param destinationTurboOfCourse  String  Destination
     * @param installmentsButInTurbo    String  Installments
     * @return  int Amount
     */
    public int payInTurbo(String turboCardNo, float turboAmount,
                   String destinationTurboOfCourse, String installmentsButInTurbo){
        return modernPayment.pay(turboCardNo, turboAmount, destinationTurboOfCourse, installmentsButInTurbo);
    }
}
