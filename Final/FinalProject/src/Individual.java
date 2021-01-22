import java.util.Random;
/***
 * @author Furkan Ozev
 * @since 18-01-2021
 * Final Project - 161044036
 *
 * Individual for COMPOSITE DESIGN PATTERN
 * For add one by one individual.
 * And it have State object.
 * So, It also use STATE DESIGN PATTERN
 */
public class Individual implements IndividualInterface{
    /**
     * S_speed: Speed individual
     * C_collision: Collision time of individuals
     * D_distance: Distance of individual
     * M_mask: Mask affect of individual
     */
    private double S_speed, C_collision, D_distance, M_mask;
    /**
     * rand: Random number generator
     */
    private Random rand = new Random();
    /**
     * WIDTH: Simulation frame width
     */
    private int WIDTH = Simulator.WIDTH;
    /**
     * HEIGHT: Simulation frame height
     */
    private int HEIGHT = Simulator.HEIGHT;
    /**
     * Keep current state.
     * State design pattern
     */
    private States state;
    /**
     * Keep information of individuals as Information object.
     */
    private Information info = new Information();

    /**
     * Individual constructor
     * @param speed double individual speed
     * @param collision double individual collison time
     * @param distance  double individual distance
     * @param mask  double mask if masked 1.0, otherwise 0.2
     * @param infected  boolen if infected is true, otherwise false
     */
    public Individual(double speed, double collision, double distance, double mask, boolean infected){
        info.x = rand.nextInt(WIDTH - 20);
        info.y = rand.nextInt(HEIGHT - 20);
        info.rotate_X = 0;
        info.rotate_Y = 0;
        info.rotate = 0;

        S_speed = speed;
        C_collision = collision;
        D_distance = distance;
        M_mask = mask;

        info.timerDie = 0;
        info.probability = 0;

        info.possible = false;
        if(infected)
            state = new Infected(this);
        else
            state = new Healthy(this);

        info.time = 0;
        info.timerRecover = 0;
        info.timerInfected = 0;
        info.immobile = false;

        state.determineRotate();

    }

    @Override
    /**
     * Move operation of individual
     */
    public void move() {
        state.move();
    }

    /**
     * Get currrent status
     * @return  int for health 0, infected 1, in hospital 2, dead 3
     */
    public int getStatus(){
        return state.getStatus();
    }

    /**
     * Get individual current x coordinate
     * @return  int coordinate x
     */
    public int getX(){
        return state.getX();
    }

    /**
     * Get individual current y coordinate
     * @return  int coordinate y
     */
    public int getY(){
        return state.getY();
    }

    /**
     * Get individual distance
     * @return  int distance
     */
    public int getD() {
        return (int) D_distance;
    }

    /**
     * Get individual collision time
     * @return  int collision time
     */
    public int getC(){
        return (int) C_collision;
    }

    /**
     * Get individual immobile status
     * If it is immobile, so it will return true
     * Otherwise, false
     * @return  boolean immobile status
     */
    public boolean getImmobile(){
        return state.getImmobile();
    }

    /**
     * Set individual immobile status
     * @param status boolean immobile status
     */
    public void setImmobile(boolean status){
        state.setImmobile(status);
    }

    /**
     * Set individual timer
     * @param time  int timer
     */
    public void setTime(int time) {
        state.setTime(time);
    }

    /**
     * Get individual mask affect point
     * If it is masked then return 0.2
     * otherwise 1.0
     * @return  int mask
     */
    public double getM_mask() {
        return M_mask;
    }

    /**
     * Set individual probability that is being infected.
     * @param probability   double probabilty
     */
    public void setProbability(double probability) {
        state.setProbability(probability);
    }

    /**
     * Set individual die timer.
     */
    public void setTimerDie() {
        state.setTimerDie();
    }

    /**
     * Set individual state.
     * @param state States
     */
    public void setState(States state) {
        this.state = state;
    }

    /**
     * Get info object of individual
     * @return  Information info object
     */
    public Information getInfo(){
        return info;
    }

    /**
     * Get individual speed
     * @return  double speed
     */
    public double getS_speed() {
        return S_speed;
    }
}
