import java.util.Scanner;

/**
 *  @author Furkan Ozev
 *  @since 19-11-2020
 *  Homework 1 - 161044036
 *
 *  It is a manual demo.
 *  The user can perform own test manually.
 *  More than one test can be tried.
 *  All combinations can be achieved by trying different types of suits and accessories.
 */
public class ManualDemo {

    /**
     * Main for Manual Demo
     * @param args String
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Suits suit;
        int selection;
        do {
            do {
                suit = null;
                System.out.println("\nSelect from 3 basic types of suits: ");
                System.out.println("\n1. Dec Suit \n2. Ora Suit \n3. Tor Suit \nSelect: ");
                selection = scan.nextInt();

                switch (selection) {
                    case 1:
                        suit = new dec();
                        break;
                    case 2:
                        suit = new ora();
                        break;
                    case 3:
                        suit = new tor();
                        break;
                    default:
                        System.out.println("\nYour selection is invalid, please try again.\n");
                        break;
                }
            } while(selection != 1 && selection != 2 && selection != 3);

            do {
                System.out.println("\nSelect accessories to equip your suit: ");
                System.out.println("\n1. Flamethrower \n2. AutoRifle \n3. RocketLauncher \n4. Laser \n5. To complete the selections \nSelect: ");
                selection = scan.nextInt();

                switch (selection) {
                    case 1:
                        suit = new Flamethrower(suit);
                        break;
                    case 2:
                        suit = new AutoRifle(suit);
                        break;
                    case 3:
                        suit = new RocketLauncher(suit);
                        break;
                    case 4:
                        suit = new Laser(suit);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("\nYour selection is invalid, please try again.\n");
                        break;
                }
            } while(selection != 5);

            System.out.println("\n" + suit.getDescription() + " :\n\t==> Total Cost: " + suit.cost() + "k TL, " + "\n\t==> Total Weight: " + suit.weight() + "kg\n");

            System.out.println("\nPress -1 to exit or any key to continue: \n");
            selection = scan.nextInt();
        } while(selection != -1);
    }
}