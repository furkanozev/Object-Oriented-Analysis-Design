/***
 * @author Furkan Ozev
 * @since 18-01-2021
 * Final Project - 161044036
 *
 * Information Class
 * It keep individual variables.
 * It will used in state objects.
 */
public class Information extends Main {
    /**
     * x: x coordinate
     * y: y coordinate
     * rotate_X: increase amount for x coordinate
     * rotate_Y: increase amount for y coordinate
     */
    public double x, y, rotate_X, rotate_Y;
    /**
     * probability: Possibility of disease transmission
     */
    public double probability;
    /**
     * rotate: Indicates the current rotate
     */
    public int rotate;
    /**
     * time: Time spent immobile
     * timerDie: Die timer
     * timerInfected: Time spent ill
     * timerRecover: Time spent in hospital
     */
    public int time, timerDie, timerInfected, timerRecover;
    /**
     * immobile: immobile state
     * possible: possible infection
     */
    public boolean immobile, possible;
}
