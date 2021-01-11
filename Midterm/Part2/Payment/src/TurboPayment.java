/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is old payment interface for credit card payments.
 */
public interface TurboPayment{
    /**
     * It is an old binary library function to pay credit card payment.
     * @param turboCardNo   String  Credit Card No
     * @param turboAmount   float   Amount
     * @param destinationTurboOfCourse  String  Destination
     * @param installmentsButInTurbo    String  Installments
     * @return  int Amount
     */
    public int payInTurbo(String turboCardNo, float turboAmount,
                   String destinationTurboOfCourse, String installmentsButInTurbo);
}