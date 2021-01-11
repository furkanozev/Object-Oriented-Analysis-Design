import java.util.ArrayList;

/***
 * @author Furkan Ozev
 * @since 06-12-2020
 * Midterm Project - 161044036
 *
 * It is the class used to indicate Discrete Cosine Transforms.
 * It derives from DiscreteTransform class.
 */
public class DiscreteCosineTransform extends DiscreteTransform {
    /**
     * Keeps output numbers in double array list.
     */
    protected ArrayList<Double> outputNumber = new ArrayList<Double>();

    /**
     * Discrete Cosine Transform Constructor Method
     * It takes input and output files
     * @param input String  input file
     * @param output    String  output file
     */
    public DiscreteCosineTransform(String input, String output){
        inputPath = input;
        outputPath = output;
    }

    /**
     * Convert output number on string to write output file.
     * @return  String  output result
     */
    protected String outputToWriteFile(){
        String output = "";
        for(int i = 0; i < N; i++){
            String print = String.format("%10.3f\n",outputNumber.get(i));
            output += print;
            System.out.println(print);
        }
        return output;
    }

    /**
     *  A method specified for writing discrete cosine transformation algorithm.
     */
    protected void transfromNumbers(){
        double sum;
        double number;
        double angle;

        for(int k = 0; k < N; k++){
            sum = 0;

            for(int n = 0; n < N; n++){
                number = inputNumbers.get(n);
                angle = (Math.PI * (n + 0.5) * k / N);
                sum += number * Math.cos(angle);
            }
            outputNumber.add(sum);
        }
    }
}
