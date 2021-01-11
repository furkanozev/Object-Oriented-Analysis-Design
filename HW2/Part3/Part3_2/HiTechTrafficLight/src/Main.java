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
        System.out.println("<<< The traffic status is unimportant for the red light state. >>>");

        System.out.println("\n# Timeout: 10, switch red light, traffic status: false #");
        trafficLight.setTimeout(10);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 10, switch yellow light, traffic status: false  #");
        trafficLight.setTimeout(10);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 10, switch green light, traffic status: false  #");
        trafficLight.setTimeout(10);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 15, switch green light, traffic status: false  #");
        trafficLight.setTimeout(15);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n----------------------------------------");
        System.out.println("<<< The traffic status is important for the green light state. >>>");

        System.out.println("\n# Timeout: 35, switch green light, traffic status: false  #");
        trafficLight.setTimeout(35);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 35, switch red light, traffic status: false  #");
        trafficLight.setTimeout(35);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 35, switch yellow light, traffic status: false  #");
        trafficLight.setTimeout(35);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 60, switch yellow light, traffic status: false  #");
        trafficLight.setTimeout(60);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n----------------------------------------");
        System.out.println("<<< The traffic status is unimportant for the yellow light state. >>>");

        System.out.println("\n# Timeout: 2, switch yellow light, traffic status: false  #");
        trafficLight.setTimeout(2);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 2, switch green light, traffic status: false  #");
        trafficLight.setTimeout(2);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 2, switch red light #, traffic status: false  ");
        trafficLight.setTimeout(2);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 3, switch red light #, traffic status: false  ");
        trafficLight.setTimeout(3);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n----------------------------------------");

        System.out.println("\n----------------------------------------");
        trafficLight.getHiTech().changeDetected(true);
        System.out.println("<<< The traffic status is unimportant for the red light state. >>>");

        System.out.println("\n# Timeout: 13, switch red light, traffic status: true #");
        trafficLight.setTimeout(13);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 13, switch yellow light, traffic status: true  #");
        trafficLight.setTimeout(13);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 13, switch green light, traffic status: true  #");
        trafficLight.setTimeout(13);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 15, switch green light, traffic status: true  #");
        trafficLight.setTimeout(15);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n----------------------------------------");
        System.out.println("<<< The traffic status is important for the green light state. >>>");

        System.out.println("\n# Timeout: 60, switch green light, traffic status: true  #");
        trafficLight.setTimeout(60);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 60, switch red light, traffic status: true  #");
        trafficLight.setTimeout(60);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 60, switch yellow light, traffic status: true  #");
        trafficLight.setTimeout(60);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 90, switch yellow light, traffic status: true  #");
        trafficLight.setTimeout(90);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n----------------------------------------");
        System.out.println("<<< The traffic status is unimportant for the yellow light state. >>>");

        System.out.println("\n# Timeout: 1, switch yellow light, traffic status: true  #");
        trafficLight.setTimeout(1);
        trafficLight.switchYellowLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 1, switch green light, traffic status: true  #");
        trafficLight.setTimeout(1);
        trafficLight.switchGreenLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 1, switch red light #, traffic status: true  ");
        trafficLight.setTimeout(1);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n# Timeout: 1, switch red light #, traffic status: true  ");
        trafficLight.setTimeout(1);
        trafficLight.switchRedLight();
        System.out.println(trafficLight);

        System.out.println("\n----------------------------------------");
    }
}
