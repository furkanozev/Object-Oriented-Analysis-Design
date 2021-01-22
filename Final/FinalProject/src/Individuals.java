import java.util.ArrayList;
import java.util.Random;
/***
 * @author Furkan Ozev
 * @since 18-01-2021
 * Final Project - 161044036
 *
 * Individual for COMPOSITE DESIGN PATTERN
 * For add individuals as bulk.
 */
public class Individuals implements IndividualInterface {
    /**
     * Individuals in arraylist.
     */
    private ArrayList<Individual> individuals = new ArrayList<Individual>();

    /**
     * Individuals Constructor.
     * @param amount individuals amount (bulk size)
     * @param speed double individual speed
     * @param collision double individual collison time
     * @param distance  double individual distance
     * @param mask  double mask if masked 1.0, otherwise 0.2
     * @param infected  boolen if infected is true, otherwise false
     */
    public Individuals(int amount, double speed, double collision, double distance, double mask, boolean infected){
        for(int i = 0; i < amount; i++){
            individuals.add(new Individual(speed, collision, distance, mask, infected));
        }
    }

    /**
     * Make move operation for individuals
     */
    public void move(){
        for (Individual ind : individuals)
        {
            ind.move();
        }
    }

    /**
     * Get individuals
     * @return  Arraylist individuals
     */
    public ArrayList<Individual> getind(){
        return individuals;
    }

    /**
     * Set die timer for individual
     */
    public void setTimerDie() {
        for(Individual ind: individuals){
            ind.setTimerDie();
        }
    }
}
