/***
 * @author Furkan Ozev
 * @since 06-12-2020
 * Midterm Project - 161044036
 *
 * It is the class used to indicate complex numbers.
 */
public class ComplexNumber {
    /**
     * real value of complex number
     */
    public double real;
    /**
     * imaginary value of complex number
     */
    public double imaginary;

    /**
     * Constructor of ComplexNumber class
     * @param real  double  real value
     * @param imaginary double  imaginary value
     */
    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
}