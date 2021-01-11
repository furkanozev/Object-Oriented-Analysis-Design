/**
 * @author Furkan Ozev
 * @since 30-12-2020
 * Homework 2 - 161044036
 *
 * Proxy Database Table
 * The proxy design pattern in order to equip the DataBaseTable class’ objects with
 * synchronization capability. no reader thread calls getElementAt while a writer thread
 * is executing setElementAt.
 */
public class ProxyDataBaseTable implements ITable {
    /**
     * Database object
     */
    private DataBaseTable table;
    /**
     * locks for synchronization rows
     */
    private Integer[] locks;

    /**
     * Constructor ProxyDataBaseTable
     * Take DataBaseTable object
     * @param table DataBaseTable   table
     */
    public ProxyDataBaseTable(DataBaseTable table){
        this.table = table;
        locks = new Integer[table.getNumberOfRows()];
        int row = table.getNumberOfRows();
        for(int i = 0; i < row; i++)
        {
            locks[i] = (Integer)i;
        }
    }

    /**
     * Get element at given row and column
     * For synchronized, lock row and call database object method with row and column
     * @param row   int row
     * @param column int column
     * @return  Object  element
     */
    public Object getElementAt(int row, int column){
        synchronized (locks[row]){
            return table.getElementAt(row, column);
        }
    }

    /**
     * Set element at given row and column
     * For synchronized, lock row and call database object method with row and column
     * @param row   int row
     * @param column int column
     * @param o Object element
     */
    public void setElementAt(int row, int column, Object o){
        synchronized (locks[row]){
            table.setElementAt(row, column, o);
        }
    }

    /**
     * Call database object method
     * Get number of rows
     * @return  int row
     */
    public int getNumberOfRows(){
        return table.getNumberOfRows();
    }

    /**
     * Call database object method
     * Get number of columns
     * @return  int column
     */
    public int getNumberOfColumns(){
        return table.getNumberOfColumns();
    }
}
