/**
 *  @author Furkan Ozev
 *  @since 19-11-2020
 *  Homework 1 - 161044036
 *
 *  Dec is an concrete component, is an suit type.
 */
public class dec extends Suits {

    /**
     * The Dec is selected as the suit type and the description is edited.
     */
    public dec() {
        description = "Dec Armored Suits";
    }

    /**
     * Returns the cost of the Dec suit.
     * @return double cost of Dec suit
     */
    @Override
    public double cost() {
        return 500;
    }

    /**
     * Returns the weight of the Dec suit
     * @return double weight of Dec suit
     */
    @Override
    public double weight() {
        return 25;
    }
}