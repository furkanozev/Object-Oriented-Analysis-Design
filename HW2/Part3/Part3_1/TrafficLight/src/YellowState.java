/**
 * @author Furkan Ozev
 * @since 22-12-2020
 * Homework 2 - 161044036
 *
 * This class is used to indicate yellow light state.
 */
public class YellowState implements State {
    /**
     * Keep TrafficLight object to switch states
     */
    private TrafficLight light;
    /**
     * Keep switch timeout
     */
    private final int timeout = 3;

    /**
     * YellowState constructor.
     * Initialize TrafficLight.
     * @param light TrafficLight
     */
    public YellowState(TrafficLight light) {
        this.light = light;
    }

    /**
     * Switch Yellow Light State to Red Light State
     * Check timeout, if it is possible, then switch states.
     * Otherwise, Print error message: Timeout must be (timeout) to switch Red Light.
     */
    @Override
    public void switchRedState() {
        if(light.getTimeout() == timeout){
            System.out.println("-> Switch to Red Light...");
            light.setState(light.getRedState());
            light.setTimeout(0);
        }
        else{
            System.out.format("-> Timeout must be %d to switch Red Light\n", timeout);
        }
    }

    /**
     * Switch Yellow Light State to Yellow Light State
     * Print error message: Light is already yellow.
     */
    @Override
    public void switchYellowState() {
        System.out.println("-> Light is already yellow.");
    }

    /**
     * Switch Yellow Light State to Green Light State
     * Print error message: You can't switch green light.
     */
    @Override
    public void switchGreenState() {
        System.out.println("-> You can't switch green light.");
    }

    /**
     * Return Yellow Light State Name
     * @return  String  state name
     */
    @Override
    public String toString() {
        return "Yellow Light State";
    }
}