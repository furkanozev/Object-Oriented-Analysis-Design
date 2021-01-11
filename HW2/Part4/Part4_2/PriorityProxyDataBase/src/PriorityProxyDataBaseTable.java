/**
 * @author Furkan Ozev
 * @since 30-12-2020
 * Homework 2 - 161044036
 *
 * Proxy Database Table
 * Prioritizes writers of DataBaseTable more than readers in terms of table row access.
 */
public class PriorityProxyDataBaseTable implements ITable {
    /**
     * Database object
     */
    private DataBaseTable table;
    /**
     * For synchronization in writers prioritizes
     */
    private int activeWriters = 0, waitingWriters = 0, readers = 0;

    /**
     * Constructor ProxyDataBaseTable
     * Take DataBaseTable object
     * @param table DataBaseTable   table
     */
    public PriorityProxyDataBaseTable(DataBaseTable table){
        this.table = table;
    }

    /**
     * Get element at given row and column
     * For synchronized, call lockRead()
     * and call database object method with row and column
     * then call unlockRead()
     * @param row   int row
     * @param column int column
     * @return  Object  element
     */
    public Object getElementAt(int row, int column){
        lockRead();
        Object e = table.getElementAt(row, column);
        unlockRead();
        return e;
    }

    /**
     * Set element at given row and column
     * For synchronized, call lockRead()
     * and call database object method with row and column
     * then call unlockRead()
     * @param row   int row
     * @param column int column
     * @param o Object element
     */
    public void setElementAt(int row, int column, Object o){
        lockWrite();
        table.setElementAt(row, column, o);
        unlockWrite();
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

    /**
     * Lock read function for writers prioritizes
     */
    private synchronized void lockRead(){
        while(activeWriters > 0 || waitingWriters > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readers++;
    }

    /**
     * Unlock read function for writers prioritizes
     */
    private synchronized void unlockRead(){
        readers--;
        notifyAll();;
    }

    /**
     * Lock write function for writers prioritizes
     */
    private synchronized void lockWrite(){
        waitingWriters++;
        while(readers > 0 || activeWriters > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        waitingWriters--;
        activeWriters++;
    }

    /**
     * Unlock write function for writers prioritizes
     */
    private synchronized void unlockWrite(){
        activeWriters--;
        notifyAll();;
    }
}
