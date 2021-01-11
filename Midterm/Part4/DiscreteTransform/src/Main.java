/***
 * @author Furkan Ozev
 * @since 06-12-2020
 * Midterm Project - 161044036
 *
 * It is a pre-made demo.
 * Includes ready-made examples.
 * It automatically runs these examples.
 */
public class Main {
    /**
     * Main for Ready (Pre-made) Demo
     * @param args String   input file
     */
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("\n --- Please enter the input file as command line argument. ---");
        }
        else {
            try {
                System.out.println("\n### Discrete Fourier Transform ###");
                DiscreteTransform DFT = new DiscreteFourierTransform(args[0], "./Output_DFT.txt");
                DFT.transform();

                System.out.println("\n-----------------------------------------------------------");

                System.out.println("\n### Discrete Cosine Transform ###");
                DiscreteTransform DCT = new DiscreteCosineTransform(args[0], "./Output_DCT.txt");
                DCT.transform();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
