/**
 *  @author Furkan Ozev
 *  @since 19-11-2020
 *  Homework 1 - 161044036
 *
 *  Tor is an concrete component, is an suit type.
 */
public class tor extends Suits {

    /**
     * The Tor is selected as the suit type and the description is edited.
     */
    public tor() {
        description = "Tor Armored Suits";
    }

    /**
     * Returns the cost of the Tor suit.
     * @return double cost of Tor suit
     */
    @Override
    public double cost() {
        return 5000;
    }

    /**
     * Returns the weight of the Tor suit
     * @return double weight of Tor suit
     */
    @Override
    public double weight() {
        return 50;
    }
}