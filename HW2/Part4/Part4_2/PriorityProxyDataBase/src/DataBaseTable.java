/**
 * @author Furkan Ozev
 * @since 30-12-2020
 * Homework 2 - 161044036
 *
 * DataBaseTable implements ITable interface
 */
public class DataBaseTable implements ITable{
    /**
     * Number of rows
     */
    private int row = 10;
    /**
     * Number of columns
     */
    private int column = 10;
    /**
     * Database table
     */
    private Integer[][] table = new Integer[row][column];

    /**
     * Get element at given row and column
     * @param row   int row
     * @param column int column
     * @return Object  element
     */
    public Object getElementAt(int row, int column){
        return table[row][column];
    }

    /**
     * Set element at given row and column
     * @param row   int row
     * @param column int column
     * @param o Object element
     */
    public void setElementAt(int row, int column, Object o){
        table[row][column] = (Integer)o;
    }

    /**
     * Get number of rows
     * @return  int row
     */
    public int getNumberOfRows(){
        return row;
    }

    /**
     * Get number of columns
     * @return  int column
     */
    public int getNumberOfColumns(){
        return column;
    }
}
