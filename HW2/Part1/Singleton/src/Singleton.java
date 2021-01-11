/**
 * @author Furkan Ozev
 * @since 22-12-2020
 * Homework 2 - 161044036
 *
 * This class is used to indicate Singleton
 * It implements Cloneable interface
 */
public class Singleton extends Object implements Cloneable{
    /**
     * Singleton field
     */
    private volatile static Singleton uniqueInstance;

    /**
     * Singleton Constructor
     */
    private Singleton() { }

    /**
     * get Singleton instance
     * @return  Singleton   uniqueInstance
     */
    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    /**
     * Clone the this object
     * @return  Object  cloned object
     * @throws CloneNotSupportedException   exception
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}