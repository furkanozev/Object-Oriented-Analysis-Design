/**
 *  @author Furkan Ozev
 *  @since 19-11-2020
 *  Homework 1 - 161044036
 *
 *  By extending from the accessories class, the suit and Laser weapon will be combined.
 */
public class Laser extends Accessories {
    /**
     * Suit object
     */
    private Suits suit;

    /**
     * Takes the suit type to be used and stores it as a variable.
     * @param suit  Suits   type of suit
     */
    public Laser(Suits suit) {
        this.suit = suit;
    }

    /**
     * The used accessory is added to the description and returned.
     * Thus, the suit is printed with all accessories used.
     * @return  String  Equipments + Laser
     */
    @Override
    public String getDescription() {
        return suit.getDescription() + ", Laser";
    }

    /**
     * The used accessories' cost is added to the total cost and returned.
     * Thus, the suit and all accessories' total cost is printed.
     * @return  double  cost of Equipments + cost of Laser
     */
    @Override
    public double cost() {
        return 200 + suit.cost();
    }

    /**
     * The used accessories' weight is added to the total weight and returned.
     * Thus, the suit and all accessories' total weight is printed.
     * @return  double  weight of Equipments + weight of Laser
     */
    @Override
    public double weight() {
        return 5.5 + suit.weight();
    }
}