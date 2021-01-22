/***
 * @author Furkan Ozev
 * @since 18-01-2021
 * Final Project - 161044036
 *
 * Dead State
 * STATE DESING PATTERN
 */
public class Dead extends States {
    /**
     * Dead State constructor.
     * Call super class constructor.
     * @param ind   Individual object
     */
    public Dead(Individual ind){
        super(ind);
    }

    /**
     * Dead individual can not move.
     * It will do nothing.
     */
    public void move(){

    }

    /**
     * Get current status
     * current status is dead, so return 3
     * @return int 3
     */
    public int getStatus(){
        return 3;
    }
}
