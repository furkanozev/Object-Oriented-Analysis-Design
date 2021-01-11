/**
 * @author Furkan Ozev
 * @since 22-12-2020
 * Homework 2 - 161044036
 *
 * This class is used to indicate state.
 */
public interface State {
    /**
     * Switch Red Light State
     */
    public void switchRedState();

    /**
     * Switch Yellow Light State
     */
    public void switchYellowState();

    /**
     * Switch Green Light State
     */
    public void switchGreenState();

    /**
     * Return State Name
     * @return  String  state name
     */
    @Override
    public String toString();
}
