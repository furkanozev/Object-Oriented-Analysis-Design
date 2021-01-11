import java.util.ArrayList;

/**
 * @author Furkan Ozev
 * @since 21-12-2020
 * Homework 2 - 161044036
 *
 * This class is used to indicate anti-clockwise spiral iterator.
 * It extends SpiralIterator class.
 */
public class AntiClockwiseSpiralIterator<E> extends SpiralIterator<E> {
    /**
     * Anti-Clockwise spiral iterator constructor
     * @param array 2D Generic Array
     */
    public AntiClockwiseSpiralIterator(E[][] array){
        list = new ArrayList<E>();
        row = array.length;
        column = array[0].length;

        int total = row * column;
        int counter = 0;

        while(x < row && y < column){
            if(counter == total)
                break;

            for(int i = x; i < row; ++i){
                list.add(array[i][y]);
                counter++;
            }
            y++;

            if(counter == total)
                break;

            for(int i = y; i < column; ++i){
                list.add(array[row-1][i]);
                counter++;
            }
            row--;

            if(counter == total)
                break;

            if(x < row){
                for(int i = row-1; i >= x; --i){
                    list.add(array[i][column-1]);
                    counter++;
                }
                column--;
            }

            if(counter == total)
                break;

            if(y < column){
                for(int i = column-1; i >= y; --i){
                    list.add(array[x][i]);
                    counter++;
                }
                x++;
            }
        }

        iterator = list.iterator();
    }
}