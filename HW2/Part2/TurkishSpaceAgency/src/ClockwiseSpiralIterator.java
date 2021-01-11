import java.util.ArrayList;

/**
 * @author Furkan Ozev
 * @since 21-12-2020
 * Homework 2 - 161044036
 *
 * This class is used to indicate clockwise spiral iterator.
 * It extends SpiralIterator class.
 */
public class ClockwiseSpiralIterator<E> extends SpiralIterator<E> {
    /**
     * Clockwise spiral iterator constructor
     * @param array 2D Generic Array
     */
    public ClockwiseSpiralIterator(E[][] array){
        list = new ArrayList<E>();
        row = array.length;
        column = array[0].length;

        while(x < row && y < column){
            for(int i = y; i < column; ++i){
                list.add(array[x][i]);
            }
            x++;

            for(int i = x; i < row; ++i){
                list.add(array[i][column-1]);
            }
            column--;

            if(x < row){
                for(int i = column-1; i >= y; --i){
                    list.add(array[row-1][i]);
                }
                row--;
            }

            if(y < column){
                for(int i = row-1; i >= x; --i){
                    list.add(array[i][y]);
                }
                y++;
            }
        }

        iterator = list.iterator();
    }
}