/**
 * @author Furkan Ozev
 * @since 22-12-2020
 * Homework 2 - 161044036
 *
 * Singleton Client
 */
public class SingletonClient {
    /**
     * Main method
     * @param args String args
     */
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("Singleton Object Hash Code: " + singleton.hashCode());

        try{
            Singleton cloneSingleton = (Singleton) singleton.clone();
            System.out.println("Clone Object Hash Code: " + cloneSingleton.hashCode());
        } catch (CloneNotSupportedException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}