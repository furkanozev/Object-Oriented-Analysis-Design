import java.util.Observable;

/**
 * @author Furkan Ozev
 * @since 22-12-2020
 * Homework 2 - 161044036
 *
 * This class is used to indicate HiTech.
 */
public class HiTech extends Observable {
    /**
     * Keep the current traffic status.
     */
    private boolean trafficStatus;

    /**
     * change Detector, notify observers.
     * @param flag  boolean new traffic status
     */
    public void changeDetected(boolean flag){
        System.out.format("-> Change to Traffic Status (new Traffic Status: %b) ...\n", flag);
        trafficStatus = flag;

        setChanged();
        notifyObservers();
    }

    /**
     * Get current traffic status
     * @return  boolean trafficStatus
     */
    public boolean getTrafficStatus(){
        return trafficStatus;
    }
}
