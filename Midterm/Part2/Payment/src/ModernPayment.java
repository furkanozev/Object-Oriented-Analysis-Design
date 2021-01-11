/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is modern payment interface for credit card payments.
 */
public interface ModernPayment{
    /**
     * It is an modern function to pay credit card payment.
     * @param cardNo    String  Credit Card No
     * @param amount    float   Amount
     * @param destination   String  Destination
     * @param installments  String  Installments
     * @return  int Amount
     */
    public int pay(String cardNo, float amount, String destination, String installments);
}