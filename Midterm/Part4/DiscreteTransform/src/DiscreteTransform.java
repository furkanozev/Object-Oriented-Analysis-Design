import java.io.*;
import java.util.*;
/***
 * @author Furkan Ozev
 * @since 06-12-2020
 * Midterm Project - 161044036
 *
 * It is the class used to indicate Discrete Transforms.
 * DFT and DFC derive from this class.
 */
public abstract class DiscreteTransform {
    /**
     * Input path of input file
     */
    protected String inputPath;
    /**
     * Output path of output file
     */
    protected String outputPath;
    /**
     * Number count
     */
    protected int N = 0;

    /**
     * Keeps input numbers in double array list.
     */
    protected ArrayList<Double> inputNumbers = new ArrayList<Double>();

    /**
     * Performs the transform operation.
     * It is a common algorithm for all Discrete Transform methods.
     * @throws IOException  File exception
     */
    public final void transform() throws IOException {
        readFile(inputPath);
        transfromNumbers();
        writeFile(outputPath);
        hook();
    }

    /**
     * Read numbers from file
     * @param inputPath String  input file
     * @throws IOException  File exception
     */
    protected void readFile(String inputPath) throws IOException {
        try{
            File fin = new File(inputPath);
            Scanner scan = new Scanner(fin);

            while(scan.hasNext()){
                N += 1;
                Double temp = Double.parseDouble(scan.next());
                inputNumbers.add(temp);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Write output numbers on output file
     * @param outputPath    String  output file
     * @throws IOException  File exception
     */
    protected void writeFile(String outputPath) throws IOException {
        FileWriter fout;
        BufferedWriter writer = null;

        try{
            fout = new FileWriter(outputPath);
            writer = new BufferedWriter(fout);
            writer.write(outputToWriteFile());
        } catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                writer.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Convert output number on string to write output file.
     * @return  String  output result
     */
    protected abstract String outputToWriteFile();

    /**
     *  An abstract method specified for writing specific transformation algorithms.
     */
    protected abstract void transfromNumbers();

    /**
     * Additional algorithms for transformation on Discrete Transform Methods.
     */
    protected void hook() { }
}
