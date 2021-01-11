/**
 * @author Furkan Ozev
 * @since 22-12-2020
 * Homework 2 - 161044036
 *
 * It is a pre-made demo.
 * Includes ready-made examples.
 * It automatically runs these examples.
 */
public class Main {
    /**
     * Main for Ready (Pre-made) Demo
     * @param args String args
     */
    public static void main(String[] args){
        TrafficLight trafficLight = new TrafficLight();

        System.out.println("\n# DEFAULT #");
        System.out.println(trafficLight);

        System.out.println("\n----------------------------------------");

        System.out.println("\n# Timeout: 10, switch red light #");
        trafficLight.setTimeout(10);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 10, switch yellow light #");
        trafficLight.setTimeout(10);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 10, switch green light #");
        trafficLight.setTimeout(10);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 15, switch green light #");
        trafficLight.setTimeout(15);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n----------------------------------------");

        System.out.println("\n# Timeout: 35, switch green light #");
        trafficLight.setTimeout(35);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 35, switch red light #");
        trafficLight.setTimeout(35);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 35, switch yellow light #");
        trafficLight.setTimeout(35);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 60, switch yellow light #");
        trafficLight.setTimeout(60);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n----------------------------------------");

        System.out.println("\n# Timeout: 2, switch yellow light #");
        trafficLight.setTimeout(2);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 2, switch green light #");
        trafficLight.setTimeout(2);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 2, switch red light #");
        trafficLight.setTimeout(2);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 3, switch red light #");
        trafficLight.setTimeout(3);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n----------------------------------------");
    }
}
