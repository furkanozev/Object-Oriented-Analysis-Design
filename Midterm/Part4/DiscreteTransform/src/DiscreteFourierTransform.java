import java.util.ArrayList;
import java.util.Scanner;

/***
 * @author Furkan Ozev
 * @since 06-12-2020
 * Midterm Project - 161044036
 *
 * It is the class used to indicate Discrete Fourier Transforms.
 * It derives from DiscreteTransform class.
 */
public class DiscreteFourierTransform extends DiscreteTransform {
    /**
     * Imaginary value for fourier transfrom
     */
    private int imaginary = 0;
    /**
     * Keeps output complex numbers in ComplexNumber array list.
     */
    private ArrayList<ComplexNumber> outputComplex = new ArrayList<ComplexNumber>();
    /**
     * Keep transformation start time
     */
    Long start;

    /**
     * Discrete Fourier Transform Constructor Method
     * It takes input and output files
     * @param input String  input file
     * @param output    String  output file
     */
    public DiscreteFourierTransform(String input, String output){
        inputPath = input;
        outputPath = output;
        start = System.currentTimeMillis();
    }

    /**
     * Convert output number on string to write output file.
     * @return  String  output result
     */
    protected String outputToWriteFile(){
        String output = "";
        for(int i = 0; i < N; i++){
            String print = String.format("%10.3f\t%10.3fi\n", outputComplex.get(i).real, outputComplex.get(i).imaginary);
            output += print;
            System.out.println(print);
        }
        return output;
    }

    /**
     *  A method specified for writing discrete cosine transformation algorithm.
     */
    protected void transfromNumbers(){
        double realSum;
        double imagSum;
        double number;
        double angle;

        for(int k = 0; k < N; k++){
            realSum = 0;
            imagSum = 0;

            for(int n = 0; n < N; n++){
                number = inputNumbers.get(n);
                angle = (2 * Math.PI * k * n / N);
                realSum += (number * Math.cos(angle)) + (imaginary * Math.sin(angle));
                imagSum += (imaginary * Math.cos(angle)) - (number * Math.sin(angle));
            }
            outputComplex.add(new ComplexNumber(realSum, imagSum));
        }
    }

    /**
     * Additional algorithms for transformation on Discrete Fourier Transform Method.
     */
    protected void hook(){
        RequestTime();
    }

    /**
     * It is an additional process.
     * Sometimes the user wants additionally the time of execution printed on screen
     */
    protected void RequestTime(){
        Long total = System.currentTimeMillis() - start;
        System.out.println("Do you want to know time of execution? (For yes press 'y' , or press any key)");

        Scanner sc = new Scanner(System.in);
        char key = sc.next().charAt(0);

        if(key == 'y' || key == 'Y'){
            System.out.println("\nTime of execution of Discrete Fourier Transform: " + total + "ms \n");
        }
    }
}
