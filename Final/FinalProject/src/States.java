import java.util.ArrayList;
import java.util.Random;
/***
 * @author Furkan Ozev
 * @since 18-01-2021
 * Final Project - 161044036
 *
 * States Class
 * STATE DESING PATTERN
 */
public abstract class States {
    /**
     * ind: Keep individual object to some operations
     */
    protected Individual ind;
    /**
     * info: Keep individual informations object
     */
    private Information temp;

    /**
     * x: x coordinate
     * y: y coordinate
     * rotate_X: increase amount for x coordinate
     * rotate_Y: increase amount for y coordinate
     */
    protected double x, y, rotate_X, rotate_Y;
    /**
     * S_speed: Speed individual
     * probability: Possibility of disease transmission
     */
    protected double S_speed, probability;
    /**
     * time: Time spent immobile
     * timerDie: Die timer
     * timerInfected: Time spent ill
     * timerRecover: Time spent in hospital
     */
    protected int time, timerDie, timerInfected, timerRecover;
    /**
     * rotate: Indicates the current rotate
     */
    protected int rotate;
    /**
     * immobile: immobile state
     * possible: possible infection
     */
    protected boolean immobile, possible;
    /**
     * WIDTH: Simulation frame width
     */
    protected int WIDTH = Simulator.WIDTH - 5;
    /**
     * HEIGHT: Simulation frame height
     */
    protected int HEIGHT = Simulator.HEIGHT - 5;
    /**
     * rand: Random number generator
     */
    protected Random rand = new Random();

    /**
     * State constructor.
     * Copy information in info object to temp variables.
     * @param ind   Individual object
     */
    public States(Individual ind){
        this.ind = ind;
        temp = ind.getInfo();
        x = temp.x;
        y = temp.y;
        rotate_X = temp.rotate_X;
        rotate_Y = temp.rotate_Y;
        S_speed = ind.getS_speed();
        rotate = temp.rotate;
        immobile = temp.immobile;
        time = temp.time;
        timerDie = temp.timerDie;
        timerInfected = temp.timerInfected;
        timerRecover = temp.timerRecover;
        possible = temp.possible;
        probability = temp.probability;
    }

    /**
     * Move individual
     */
    public abstract void move();

    /**
     * Only move one point to next point.
     */
    protected void normalMove()
    {
        if(x+rotate_X > 0 && x+rotate_X < WIDTH && y+rotate_Y > 0 && y+rotate_Y < HEIGHT){
            x += rotate_X;
            y += rotate_Y;
        }
        else{
            determineRotate();
            x += rotate_X;
            y += rotate_Y;
        }
    }

    /**
     * Determine next rotate and coordinates.
     */
    public void determineRotate(){

        double root = S_speed / Math.sqrt(2);
        ArrayList<Integer> possible = new ArrayList<Integer>();
        if(y+S_speed < HEIGHT)
            possible.add(0);
        if(x+root < WIDTH && y+root < HEIGHT)
            possible.add(1);
        if(x+S_speed < WIDTH)
            possible.add(2);
        if(x+root < WIDTH && y-root > 0)
            possible.add(3);
        if(y-S_speed > 0)
            possible.add(4);
        if(x-root > 0 && y-root > 0)
            possible.add(5);
        if(x-S_speed > 0)
            possible.add(6);
        if(x-root > 0 && y+root < HEIGHT)
            possible.add(7);

        int random = rand.nextInt(possible.size());
        rotate = (int) possible.get(random);

        switch (rotate) {
            case 0:
                rotate_X = 0;
                rotate_Y = S_speed;
                break;
            case 1:
                rotate_X = root;
                rotate_Y = root;
                break;
            case 2:
                rotate_X = S_speed;
                rotate_Y = 0;
                break;
            case 3:
                rotate_X = root;
                rotate_Y = root * -1;
                break;
            case 4:
                rotate_X = 0;
                rotate_Y = S_speed * -1;
                break;
            case 5:
                rotate_X = root * -1;
                rotate_Y = root * -1;
                break;
            case 6:
                rotate_X = S_speed * -1;
                rotate_Y = 0;
                break;
            case 7:
                rotate_X = root * -1;
                rotate_Y = root;
                break;
        }
    }

    /**
     * Set individual information object with new values.
     */
    protected void setInfo(){
        temp.x = x;
        temp.y = y;
        temp.rotate_X = rotate_X;
        temp.rotate_Y = rotate_Y;
        temp.rotate = rotate;
        temp.immobile = immobile;
        temp.time = time;
        temp.timerDie = timerDie;
        temp.timerInfected = timerInfected;
        temp.timerRecover = timerRecover;
        temp.possible = possible;
        temp.probability = probability;
    }

    /**
     * Get current status
     * @return  int for health 0, infected 1, in hospital 2, dead 3
     */
    public abstract int getStatus();

    /**
     * Get current x coordinate of individual
     * @return  int x coordinate
     */
    public int getX(){
        return (int) x;
    }

    /**
     * Get current y coordinate of individual
     * @return  int y coordinate
     */
    public int getY(){
        return (int) y;
    }

    /**
     * Get individual immobile status
     * If it is immobile, so it will return true
     * Otherwise, false
     * @return  boolean immobile status
     */
    public boolean getImmobile(){
        return immobile;
    }

    /**
     * Set individual immobile status
     * @param status boolean immobile status
     */
    public void setImmobile(boolean status){
        immobile = status;
    }

    /**
     * Set individual timer
     * @param time  int timer
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Set individual probability that is being infected.
     * @param probability   double probabilty
     */
    public void setProbability(double probability) {
        possible = true;
        this.probability = probability;
    }

    /**
     * Set individual die timer.
     */
    public void setTimerDie() {
        timerDie = (int) (100 * (1 - Simulator.mortality_Z));
    }
}
