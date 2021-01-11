/**
 *  @author Furkan Ozev
 *  @since 19-11-2020
 *  Homework 1 - 161044036
 *
 *  Ora is an concrete component, is an suit type.
 */
public class ora extends Suits {

    /**
     * The Ora is selected as the suit type and the description is edited.
     */
    public ora() {
        description = "Ora Armored Suits";
    }

    /**
     * Returns the cost of the Ora suit.
     * @return double cost of Ora suit
     */
    @Override
    public double cost() {
        return 1500;
    }

    /**
     * Returns the weight of the Ora suit.
     * @return double weight of Ora suit
     */
    @Override
    public double weight() {
        return 30;
    }
}