import javax.swing.*;
import java.awt.*;
/***
 * @author Furkan Ozev
 * @since 18-01-2021
 * Final Project - 161044036
 *
 * Epidemic Simulator Main
 */
public class Main {
    /**
     * Jframe static object
     */
    static JFrame frame;

    /**
     * Epidemic simulator main.
     * Run GUI
     * @param args String
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JFrame("Epidemic Simulator");

                frame.getContentPane().add(new Simulator());
                frame.pack();
                frame.setVisible(true);
                frame.setMinimumSize(new Dimension(Simulator.WIDTH + 250, Simulator.HEIGHT + 77));
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });


    }
}
