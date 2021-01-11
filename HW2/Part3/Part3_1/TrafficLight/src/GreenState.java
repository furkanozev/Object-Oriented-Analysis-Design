/**
 * @author Furkan Ozev
 * @since 22-12-2020
 * Homework 2 - 161044036
 *
 * This class is used to indicate green light state.
 */
public class GreenState implements State {
    /**
     * Keep TrafficLight object to switch states
     */
    private TrafficLight light;
    /**
     * Keep switch timeout
     */
    private final int timeout_X = 60;

    /**
     * GreenState constructor.
     * Initialize TrafficLight.
     * @param light TrafficLight
     */
    public GreenState(TrafficLight light) {
        this.light = light;
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