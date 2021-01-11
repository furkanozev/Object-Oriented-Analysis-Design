/**
 * @author Furkan Ozev
 * @since 30-12-2020
 * Homework 2 - 161044036
 *
 * ITable Interface
 */
public interface ITable {
    /**
     * Get element at given row and column
     * @param row   int row
     * @param column int column
     * @return  Object  element
     */
    public Object getElementAt(int row, int column);

    /**
     * Set element at given row and column
     * @param row   int row
     * @param column int column
     * @param o Object element
     */
    public void setElementAt(int row, int column, Object o);

    /**
     * Get number of rows
     * @return  int row
     */
    public int getNumberOfRows();

    /**
     * Get number of columns
     * @return  int column
     */
    public int getNumberOfColumns();
}
