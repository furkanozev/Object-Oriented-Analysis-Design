/**
 * @author Furkan Ozev
 * @since 22-12-2020
 * Homework 2 - 161044036
 *
 * This class is used to indicate Traffic Light.
 */
public class TrafficLight {
    /**
     * HiTech object, to check traffic status.
     */
    private HiTech hiTech;
    /**
     * Keep red light state
     */
    private State redState;
    /**
     * Keep yellow light state
     */
    private State yellowState;
    /**
     * Keep green light state
     */
    private State greenState;

    /**
     * Keep current light state
     */
    private State currentState;
    /**
     * Keep current timeout
     */
    private int timeout = 0;

    /**
     * TrafficLight constructor.
     * Initialize light states and HiTech object.
     * Default light state will be red.
     */
    public TrafficLight(){
        hiTech = new HiTech();
        redState = new RedState(this, hiTech);
        yellowState = new YellowState(this, hiTech);
        greenState = new GreenState(this, hiTech);

        currentState = redState;
    }

    /**
     * To switch states, take new state and initialize it.
     * @param newState  State   new state
     */
    public void setState(State newState){
        currentState = newState;
    }

    /**
     * To get current state.
     * @return  State   currentState
     */
    public State getState(){
        return currentState;
    }

    /**
     * Switch red light state.
     * Call current state's switchRedState() method.
     */
    public void switchRedLight(){
        currentState.switchRedState();
    }

    /**
     * Switch yellow light state.
     * Call current state's switchYellowState() method.
     */
    public void switchYellowLight(){
        currentState.switchYellowState();
    }

    /**
     * Switch green light state.
     * Call current state's switchGreenState() method.
     */
    public void switchGreenLight(){
        currentState.switchGreenState();
    }

    /**
     * Get redState field.
     * @return  State   redState
     */
    public State getRedState(){
        return redState;
    }

    /**
     * Get yellowState field.
     * @return  State   yellowState
     */
    public State getYellowState(){
        return yellowState;
    }

    /**
     * Get greenState field.
     * @return  State   greenState
     */
    public State getGreenState(){
        return greenState;
    }

    /**
     * Set timeout, take an new timeout, and set it.
     * @param newTimeout    int new timeout
     */
    public void setTimeout(int newTimeout){
        timeout = newTimeout;
    }

    /**
     * Get timeout
     * @return  int timeout
     */
    public int getTimeout(){
        return timeout;
    }

    /**
     * Get HiTech object
     * @return  HiTech  hiTech
     */
    public HiTech getHiTech(){
        return hiTech;
    }

    /**
     * Current timeout and current light state will converted string.
     * @return  String  timeout and current state
     */
    @Override
    public String toString() {
        return "--- Time: " + timeout + ", Current State: " + currentState + ", Traffic Status: " + hiTech.getTrafficStatus() + " ---";
    }
}
