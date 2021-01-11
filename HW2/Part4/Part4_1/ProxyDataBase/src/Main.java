import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Furkan Ozev
 * @since 30-12-2020
 * Homework 2 - 161044036
 *
 * It is a pre-made demo.
 * Creates threads and calls some get and set methods.
 */
public class Main {
    /**
     * Main for Ready (Pre-made) Demo
     * @param args String args
     */
    public static void main(String[] args){

        System.out.println("\t----------------- MAIN THREAD POOL -----------------\n");
        DataBaseTable toLock = new DataBaseTable();
        ProxyDataBaseTable proxyTable = new ProxyDataBaseTable(toLock);
        Integer[] locks = new Integer[6];

        for(int i = 0; i < 6; i++)
        {
            locks[i] = (Integer)i;
        }

        Runnable thread1 = new Task("thread 1", proxyTable, locks);
        Runnable thread2 = new Task("thread 2", proxyTable, locks);
        Runnable thread3 = new Task("thread 3", proxyTable, locks);
        Runnable thread4 = new Task("thread 4", proxyTable, locks);

        ExecutorService pool = Executors.newFixedThreadPool(4);

        pool.execute(thread1);
        pool.execute(thread2);
        pool.execute(thread3);
        pool.execute(thread4);

        pool.shutdown();
    }
}
