/**
 *  @author Furkan Ozev
 *  @since 19-11-2020
 *  Homework 1 - 161044036
 *
 * It is a pre-made demo.
 * Includes ready-made examples.
 * It automatically runs these examples.
 */
public class ReadyDemo {

    /**
     * Main for Ready (Pre-made) Demo
     * @param args String
     */
    public static void main(String[] args) {
        Suits suit1 = new dec();
        System.out.println("\n" + suit1.getDescription() + " :\n\t==> Total Cost: " + suit1.cost() + "k TL, " + "\n\t==> Total Weight: " + suit1.weight() + "kg\n");

        Suits suit2 = new tor();
        suit2 = new AutoRifle(suit2);
        suit2 = new Flamethrower(suit2);
        suit2 = new RocketLauncher(suit2);
        suit2 = new Laser(suit2);
        suit2 = new Laser(suit2);
        System.out.println("\n" + suit2.getDescription() + " :\n\t==> Total Cost: " + suit2.cost() + "k TL, " + "\n\t==> Total Weight: " + suit2.weight() + "kg\n");

        Suits suit3 = new ora();
        suit3 = new RocketLauncher(suit3);
        suit3 = new RocketLauncher(suit3);
        suit3 = new AutoRifle(suit3);
        suit3 = new Laser(suit3);
        System.out.println("\n" + suit3.getDescription() + " :\n\t==> Total Cost: " + suit3.cost() + "k TL, " + "\n\t==> Total Weight: " + suit3.weight() + "kg\n");

        Suits suit4 = new dec();
        suit4 = new Flamethrower(suit4);
        suit4 = new AutoRifle(suit4);
        suit4 = new AutoRifle(suit4);
        suit4 = new RocketLauncher(suit4);
        System.out.println("\n" + suit4.getDescription() + " :\n\t==> Total Cost: " + suit4.cost() + "k TL, " + "\n\t==> Total Weight: " + suit4.weight() + "kg\n");
    }
}