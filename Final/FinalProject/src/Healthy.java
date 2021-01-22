/***
 * @author Furkan Ozev
 * @since 18-01-2021
 * Final Project - 161044036
 *
 * Healthy State
 * STATE DESING PATTERN
 */
public class Healthy extends States {
    /**
     * change: keep state change status
     */
    private boolean change = false;

    /**
     * Healthy State constructor.
     * Call super class constructor.
     * @param ind   Individual object
     */
    public Healthy(Individual ind){
        super(ind);
    }

    /**
     * Move healthy individual
     */
    public void move(){
        if(immobile != true){
            normalMove();
        }
        else{
            if(time > 0){
                time -= 1;
            }
            else{
                time = 0;
                double random = Math.random();
                if(possible == true && random <= probability){
                    change = true;
                    Simulator.healthy -= 1;
                    Simulator.infected += 1;
                    timerDie = (int) (100 * (1 - Simulator.mortality_Z));
                }
                else{
                    possible = false;
                    probability = 0;
                }
                immobile = false;
                determineRotate();
                normalMove();
            }
        }
        if(change == true){
            setInfo();
            ind.setState(new Infected(ind));
        }
    }

    /**
     * Get current status
     * current status is healthy, so return 0
     * @return int 0
     */
    public int getStatus(){
        return 0;
    }
}