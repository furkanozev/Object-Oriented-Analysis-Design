/**
 * @author Furkan Ozev
 * @since 21-12-2020
 * Homework 2 - 161044036
 *
 * It is a pre-made demo.
 * Includes ready-made examples.
 * It automatically runs these examples.
 */
public class Main {
    /**
     * Main for Ready (Pre-made) Demo
     * @param args String args
     */
    public static void main(String[] args){
        int row = 4;
        int column = 4;
        Integer[][] array = new Integer[row][column];

        System.out.println("\n------- DATA -------");
        int count = 1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                array[i][j] = count++;
                System.out.format("%d\t", array[i][j]);
            }
            System.out.println();
        }

        System.out.println("\n------- Clockwise Iterator -------");
        SpiralIterator clockwiseIterator = new ClockwiseSpiralIterator<Integer>(array);
        while(clockwiseIterator.hasNext()){
            System.out.format("%d ", clockwiseIterator.next());
        }

        System.out.println("\n\n------- Anti-Clockwise Iterator -------");
        SpiralIterator anticlockwiseIterator = new AntiClockwiseSpiralIterator(array);
        while(anticlockwiseIterator.hasNext()){
            System.out.format("%d ", anticlockwiseIterator.next());
        }

        System.out.println();
    }
}