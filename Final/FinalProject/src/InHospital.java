/***
 * @author Furkan Ozev
 * @since 18-01-2021
 * Final Project - 161044036
 *
 * InHospital State
 * STATE DESING PATTERN
 */
public class InHospital extends States {
    /**
     * change: keep state change status
     */
    private boolean change = false;

    /**
     * InHospital State constructor.
     * Call super class constructor.
     * @param ind   Individual object
     */
    public InHospital(Individual ind){
        super(ind);
    }

    /**
     * Check InHospital individual
     * If time is up, it can move and it will be healthy.
     */
    public void move(){
        if(timerRecover > 0){
            timerRecover -= 1;
        }
        else{
            timerRecover = 0;
            timerInfected = 0;
            time = 0;
            immobile = false;
            change = true;
            Simulator.infected -= 1;
            Simulator.healthy += 1;
            Simulator.hospital -= 1;
            Simulator.totalRecovered += 1;
            x = rand.nextInt(WIDTH - 20);
            y = rand.nextInt(HEIGHT - 20);
            determineRotate();
            normalMove();
        }
        if(change == true){
            setInfo();
            ind.setState(new Healthy(ind));
        }
    }

    /**
     * Get current status
     * current status is inhospital, so return 2
     * @return int 2
     */
    public int getStatus(){
        return 2;
    }
}