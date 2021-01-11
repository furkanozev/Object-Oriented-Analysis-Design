import java.util.Random;

/**
 * @author Furkan Ozev
 * @since 30-12-2020
 * Homework 2 - 161044036
 *
 * Thread Class
 */
public class Task implements Runnable{
    /**
     * Thread name
     */
    private String threadName;
    /**
     * ProxyDataBaseTable to lock rows
     */
    private PriorityProxyDataBaseTable proxyTable;
    /**
     * For synchronize output messages
     */
    private Integer[] locks;

    /**
     * Constructor Thread class
     * @param str   String  thread name
     * @param proxyTable    ProxyDataBaseTable  Data base table
     * @param locks Integer array   output locks
     */
    public Task(String str, PriorityProxyDataBaseTable proxyTable, Integer[] locks){
        threadName = str;
        this.proxyTable = proxyTable;
        this.locks = locks;
    }

    /**
     * Threads run function
     * Call some set and get methods.
     */
    public void run(){
        Integer random;
        Random rand = new Random();

        synchronized (locks[0]) {
            random = rand.nextInt(100);
            System.out.println("Thread Name: " + threadName + " setElementAt(row: 3, column: 4, element: " + random + ")");
            proxyTable.setElementAt(3, 4, random);
        }

        synchronized (locks[1]) {
            random = rand.nextInt(100);
            System.out.println("Thread Name: " + threadName + " setElementAt(row: 7, column: 2, element: " + random + ")");
            proxyTable.setElementAt(7, 2, random);
        }

        synchronized (System.out) {
            System.out.println("Thread Name: " + threadName + " getElementAt(row: 3, column: 4) Return value: " + proxyTable.getElementAt(3, 4));
        }

        synchronized (locks[2]) {
            random = rand.nextInt(100);
            System.out.println("Thread Name: " + threadName + " setElementAt(row: 1, column: 9, element: " + random + ")");
            proxyTable.setElementAt(1, 9, random);
        }

        synchronized (locks[3]) {
            random = rand.nextInt(100);
            System.out.println("Thread Name: " + threadName + " setElementAt(row: 6, column: 5, element: " + random + ")");
            proxyTable.setElementAt(6, 5, random);
        }

        synchronized (System.out) {
            System.out.println("Thread Name: " + threadName + " getElementAt(row: 1, column: 9) Return value: " + proxyTable.getElementAt(1, 9));
        }

        synchronized (System.out) {
            System.out.println("Thread Name: " + threadName + " getElementAt(row: 7, column: 2) Return value: " + proxyTable.getElementAt(7, 2));
        }

        synchronized (locks[4]) {
            random = rand.nextInt(100);
            System.out.println("Thread Name: " + threadName + " setElementAt(row: 3, column: 8, element: " + random + ")");
            proxyTable.setElementAt(3, 8, random);
        }

        synchronized (System.out) {
            System.out.println("Thread Name: " + threadName + " getElementAt(row: 6, column: 5) Return value: " + proxyTable.getElementAt(6, 5));
        }

        synchronized (System.out) {
            System.out.println("Thread Name: " + threadName + " getElementAt(row: 3, column: 8) Return value: " + proxyTable.getElementAt(3, 8));
        }

        synchronized (locks[5]) {
            random = rand.nextInt(100);
            System.out.println("Thread Name: " + threadName + " setElementAt(row: 5, column: 6, element: " + random + ")");
            proxyTable.setElementAt(5, 6, random);
        }

        synchronized (System.out) {
            System.out.println("Thread Name: " + threadName + " getElementAt(row: 5, column: 6) Return value: " + proxyTable.getElementAt(5, 6));
        }
    }
}
