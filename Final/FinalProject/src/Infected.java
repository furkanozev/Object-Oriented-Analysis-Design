/***
 * @author Furkan Ozev
 * @since 18-01-2021
 * Final Project - 161044036
 *
 * Infected State
 * STATE DESING PATTERN
 */
public class Infected extends States {
    /**
     * change: keep state change status
     */
    private boolean change = false;
    /**
     * status: current status
     */
    private int status = 1;

    /**
     * Infected State constructor.
     * Call super class constructor.
     * @param ind   Individual object
     */
    public Infected(Individual ind){
        super(ind);
    }

    /**
     * Move infected individual
     */
    public void move(){
        if(timerDie < 0){
            change = true;
            status = 3;
            Simulator.death += 1;
            Simulator.alive -= 1;
            Simulator.infected -= 1;
        }
        else if(timerInfected >= 25){
            if(Simulator.hospital < Simulator.CAPACITY){
                change = true;
                status = 2;
                timerRecover = 10;
                Simulator.hospital += 1;
            }
        }
        timerDie -= 1;
        timerInfected += 1;

        if(immobile != true){
            normalMove();
        }
        else{
            if(time > 0){
                time -= 1;
            }
            else{
                time = 0;
                immobile = false;
                determineRotate();
                normalMove();
            }
        }
        if(change == true){
            setInfo();
            if(status == 2){
                ind.setState(new InHospital(ind));
            }
            else if(status == 3){
                ind.setState(new Dead(ind));
            }
        }
    }

    /**
     * Get current status
     * current status is infected, so return 0
     * @return int 1
     */
    public int getStatus(){
        return 1;
    }
}