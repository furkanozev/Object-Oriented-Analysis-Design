/**
 *  @author Furkan Ozev
 *  @since 19-11-2020
 *  Homework 1 - 161044036
 *
 *  Suits, acts as our abstract component class.
 */
public abstract class Suits {
    /**
     * Description of Suit.
     * Default: Unknown Suit
     */
    protected String description = "Unknown Suit";

    /**
     * It will return component of suit
     * @return  String  type of component
     */
    public String getDescription() {
        return description;
    }

    /**
     * It will return cost of component
     * @return  double  cost of component
     */
    public abstract double cost();

    /**
     * It will return weight of component
     * @return  double  weight of component
     */
    public abstract double weight();
}