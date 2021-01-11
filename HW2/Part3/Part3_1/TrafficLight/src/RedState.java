/**
 * @author Furkan Ozev
 * @since 22-12-2020
 * Homework 2 - 161044036
 *
 * This class is used to indicate red light state.
 */
public class RedState implements State {
    /**
     * Keep TrafficLight object to switch states
     */
    private TrafficLight light;
    /**
     * Keep switch timeout
     */
    private final int timeout = 15;

    /**
     * RedState constructor.
     * Initialize TrafficLight.
     * @param light TrafficLight
     */
    public RedState(TrafficLight light) {
        this.light = light;
    }

    /**
     * Switch Red Light State to Red Light State
     * Print error message: Light is already red.
     */
    @Override
    public void switchRedState() {
        System.out.println("-> Light is already red.");
    }

    /**
     * Switch Red Light State to Yellow Light State
     * Print error message: You can't switch yellow light.
     */
    @Override
    public void switchYellowState() {
        System.out.println("-> You can't switch yellow light.");
    }

    /**
     * Switch Red Light State to Green Light State
     * Check timeout, if it is possible, then switch states.
     * Otherwise, Print error message: Timeout must be (timeout) to switch Green Light.
     */
    @Override
    public void switchGreenState() {
        if(light.getTimeout() == timeout){
            System.out.println("-> Switch to Green Light...");
            light.setState(light.getGreenState());
            light.setTimeout(0);
        }
        else{
            System.out.format("-> Timeout must be %d to switch Green Light\n", timeout);
        }
    }

    /**
     * Return Red Light State Name
     * @return  String  state name
     */
    @Override
    public String toString() {
        return "Red Light State";
    }
}
