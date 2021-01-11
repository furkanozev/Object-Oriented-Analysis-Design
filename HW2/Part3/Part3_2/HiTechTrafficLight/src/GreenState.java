import java.util.Observable;
import java.util.Observer;

/**
 * @author Furkan Ozev
 * @since 22-12-2020
 * Homework 2 - 161044036
 *
 * This class is used to indicate green light state.
 */
public class GreenState implements State, Observer {
    /**
     * Keep observable object.
     */
    private Observable o;
    /**
     * Keep TrafficLight object to switch states.
     */
    private TrafficLight light;
    /**
     * Keep switch timeout
     */
    private int timeout_X = 60;

    /**
     * Normal timeout for green state.
     */
    private final int timeout1 = 60;
    /**
     * HiTech timeout for green state.
     */
    private final int timeout2 = 90;

    /**
     * GreenState constructor.
     * Initialize TrafficLight.
     * @param light TrafficLight
     * @param o Observable object hiTech
     */
    public GreenState(TrafficLight light, Observable o) {
        this.light = light;
        this.o = o;
        o.addObserver((Observer) this);
    }

    /**
     * Switch Green Light State to Red Light State
     * Print error message: You can't switch red light.
     */
    @Override
    public void switchRedState() {
        System.out.println("-> You can't switch red light.");
    }

    /**
     * Switch Green Light State to Yellow Light State
     * Check timeout, if it is possible, then switch states.
     * Otherwise, Print error message: Timeout must be (timeout_X) to switch Yellow Light.
     */
    @Override
    public void switchYellowState() {
        if(light.getTimeout() == timeout_X){
            System.out.println("-> Switch to Yellow Light...");
            light.setState(light.getYellowState());
            light.setTimeout(0);
        }
        else{
            System.out.format("-> Timeout must be %d to switch Yellow Light\n", timeout_X);
        }
    }

    /**
     * Check Traffic Status,
     * If traffic status flag is true, then set timeout_X as 90.
     * Otherwise, timeout_X will be 60.
     * @param o Observable  HiTech
     * @param arg   Object argumant
     */
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof HiTech){
            HiTech hiTech = (HiTech) o;
            if(hiTech.getTrafficStatus()){
                timeout_X = timeout2;
            }
            else{
                timeout_X = timeout1;
            }
            System.out.format("-> Change to timeout_X (new timeout_X: %d) ...\n", timeout_X);
        }
    }

    /**
     * Switch Green Light State to Yellow Green State
     * Print error message: Light is already green.
     */
    @Override
    public void switchGreenState() {
        System.out.println("-> Light is already green.");
    }

    /**
     * Return Green Light State Name
     * @return  String  state name
     */
    @Override
    public String toString() {
        return "Green Light State";
    }
}