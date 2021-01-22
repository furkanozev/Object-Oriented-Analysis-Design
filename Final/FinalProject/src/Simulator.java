import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/***
 * @author Furkan Ozev
 * @since 18-01-2021
 * Final Project - 161044036
 *
 * Epidemic Simulator GUI
 */
public class Simulator extends JPanel {
    /**
     * PEOPLE: static variable, indicate current people amount
     * CAPACITY: static variable, indicate hospital capacity
     */
    static int PEOPLE = 0, CAPACITY = 0;
    /**
     * WIDTH: static variable, Simulation frame width
     * HEIGHT: static variable, Simulation frame height
     */
    static final int WIDTH = 1000, HEIGHT = 600;
    /**
     * spreading_R: static variable, Spreading Factor R
     * mortality_Z: static variable, Mortality Rate Z
     */
    static double spreading_R, mortality_Z;
    /**
     * firstStart: indicate first start simulation
     */
    private int firstStart = 0;
    /**
     * indicate total individual
     */
    private int total = 0;

    /**
     * indicate current time of simulation
     */
    private int time = 0;
    /**
     * indicate pause status of simulation
     */
    private boolean pause = true;
    /**
     * Mediator object for simulation
     */
    private Mediator mediator = new Mediator();

    /**
     * Keep individuals as bulk or one
     */
    static ArrayList<IndividualInterface> people = new ArrayList<IndividualInterface>();
    /**
     * Static variables
     * hospital: Current total amount of infected individuals in hospital
     * health: Current total amount of health individuals
     * infected: Current total amount of infected individuals
     * totalRecovered: Current total amount of recovered individuals
     * alive: Current total amount of alive individuals
     * death: Current total amount of dead individuals
     */
    static int hospital = 0, healthy = 0, infected = 0, totalRecovered = 0, alive = 0, death = 0;

    /**
     * Controlers jpanel
     */
    private JPanel controls;
    /**
     * Play, Pause, Stop, Add buttons.
     */
    private JButton pauseButton, stopButton, playButton, addButton;
    /**
     * Some parameters sliders.
     */
    private JSlider speedSlider, collisionSlider, distanceSlider, peopleSlider, spreadingSlider, mortalitySlider;
    /**
     * Mask status.
     */
    private JCheckBox maskBox;
    /**
     * Some parameter labels.
     */
    private JLabel speedLabel, collisionLabel, distanceLabel, peopleLabel, controllerLabel, totalLabel, individualLabel, spreadingLabel, mortalityLabel;
    /**
     * Some current value labels.
     */
    private JLabel healthyLabel, infectedLabel, deadLabel, totalRecoveredLabel, timeLabel, hospitalLabel, aliveLabel, trash;

    /**
     * for MULTITHREADED GUI
     * I used Timer class.
     * Timer class provides a method call that is used by a thread to schedule a task, such as running a block of code after some regular instant of time.
     * Each task may be scheduled to run once or for a repeated number of executions.
     * Each timer object is associated with a background thread that is responsible for the execution of all the tasks of a timer object.
     */
    private Timer timer;

    /**
     * Simulator object - GUI
     * Create buttons, labels, sliders
     */
    public Simulator(){
        sliderListener sliderListener = new sliderListener();
        controlListener controlListener = new controlListener();

        controls = new JPanel();
        BoxLayout layout = new BoxLayout(controls, BoxLayout.Y_AXIS);
        controls.setLayout(layout);

        spreadingSlider = new JSlider(JSlider.HORIZONTAL, 5, 10, 5);
        spreadingSlider.setMinorTickSpacing(1);
        spreadingSlider.setMajorTickSpacing(1);
        spreadingSlider.setPaintTicks(true);
        spreadingSlider.setPaintLabels(true);
        spreadingSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        spreadingSlider.addChangeListener(sliderListener);
        spreadingSlider.setEnabled(true);

        spreadingLabel = new JLabel("Spreading Factor (R): 0." + spreadingSlider.getValue());
        spreadingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        mortalitySlider = new JSlider(JSlider.HORIZONTAL, 1, 9, 1);
        mortalitySlider.setMinorTickSpacing(1);
        mortalitySlider.setMajorTickSpacing(1);
        mortalitySlider.setPaintTicks(true);
        mortalitySlider.setPaintLabels(true);
        mortalitySlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        mortalitySlider.addChangeListener(sliderListener);
        mortalitySlider.setEnabled(true);

        mortalityLabel = new JLabel("Mortality Rate(Z): 0." + mortalitySlider.getValue());
        mortalityLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        speedSlider = new JSlider(JSlider.HORIZONTAL, 1, 500, 1);
        speedSlider.setMinorTickSpacing(50);
        speedSlider.setMajorTickSpacing(499);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        speedSlider.addChangeListener(sliderListener);
        speedSlider.setEnabled(true);

        speedLabel = new JLabel("Speed (S): " + speedSlider.getValue());
        speedLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        collisionSlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);
        collisionSlider.setMinorTickSpacing(1);
        collisionSlider.setMajorTickSpacing(1);
        collisionSlider.setPaintTicks(true);
        collisionSlider.setPaintLabels(true);
        collisionSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        collisionSlider.addChangeListener(sliderListener);
        collisionSlider.setEnabled(true);

        collisionLabel = new JLabel("Collision (C): " + collisionSlider.getValue());
        collisionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        distanceSlider = new JSlider(JSlider.HORIZONTAL, 0, 9, 0);
        distanceSlider.setMinorTickSpacing(1);
        distanceSlider.setMajorTickSpacing(1);
        distanceSlider.setPaintTicks(true);
        distanceSlider.setPaintLabels(true);
        distanceSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        distanceSlider.addChangeListener(sliderListener);
        distanceSlider.setEnabled(true);

        distanceLabel = new JLabel("Distance (D): " + distanceSlider.getValue());
        distanceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        maskBox = new JCheckBox("Mask (M)");
        maskBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        maskBox.setEnabled(true);

        peopleSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 1);
        peopleSlider.setMinorTickSpacing(50);
        peopleSlider.setMajorTickSpacing(250);
        peopleSlider.setPaintTicks(true);
        peopleSlider.setPaintLabels(true);
        peopleSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        peopleSlider.addChangeListener(sliderListener);
        peopleSlider.setEnabled(true);

        peopleLabel = new JLabel("People Amount: " + peopleSlider.getValue());
        peopleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        controllerLabel = new JLabel("    Controller:");
        controllerLabel.setFont(new Font("Consolas", Font.BOLD, 20));

        individualLabel = new JLabel("   Add Individuals:");
        individualLabel.setFont(new Font("Consolas", Font.BOLD, 15));

        totalLabel = new JLabel("Total Individual Amount (P): 0");
        totalLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        timeLabel = new JLabel("TIMER: 0");
        timeLabel.setFont(new Font("Consolas", Font.BOLD, 20));

        healthyLabel = new JLabel("Healthy Amount: 0");
        healthyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        infectedLabel = new JLabel("Infected Amount: 0");
        infectedLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        hospitalLabel = new JLabel("In Hospital: 0");
        hospitalLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        aliveLabel = new JLabel("Total Alive: 0");
        aliveLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        trash = new JLabel("---------------------------------------");
        trash.setAlignmentX(Component.LEFT_ALIGNMENT);

        deadLabel = new JLabel("Death Amount: 0");
        deadLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        totalRecoveredLabel = new JLabel("Total Recovered Amount: 0");
        totalRecoveredLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        playButton = new JButton("Play");
        playButton.setContentAreaFilled(false);
        playButton.setOpaque(true);
        playButton.addActionListener(controlListener);
        playButton.setEnabled(false);

        pauseButton = new JButton("Pause");
        pauseButton.setContentAreaFilled(false);
        pauseButton.setOpaque(true);
        pauseButton.addActionListener(controlListener);
        pauseButton.setEnabled(false);

        stopButton = new JButton("Stop");
        stopButton.setContentAreaFilled(false);
        stopButton.setOpaque(true);
        stopButton.addActionListener(controlListener);
        stopButton.setEnabled(false);

        addButton = new JButton("Add");
        addButton.setContentAreaFilled(false);
        addButton.setOpaque(true);
        addButton.addActionListener(controlListener);

        controls.add(timeLabel);
        controls.add(healthyLabel);
        controls.add(infectedLabel);
        controls.add(hospitalLabel);
        controls.add(totalRecoveredLabel);
        controls.add(trash);
        controls.add(aliveLabel);
        controls.add(deadLabel);

        controls.add(controllerLabel);
        controls.add(spreadingLabel);
        controls.add(spreadingSlider);
        controls.add(mortalityLabel);
        controls.add(mortalitySlider);
        controls.add(playButton);
        controls.add(pauseButton);
        controls.add(stopButton);
        controls.add(individualLabel);
        controls.add(speedLabel);
        controls.add(speedSlider);
        controls.add(collisionLabel);
        controls.add(collisionSlider);
        controls.add(distanceLabel);
        controls.add(distanceSlider);
        controls.add(maskBox);
        controls.add(peopleLabel);
        controls.add(peopleSlider);
        controls.add(addButton);
        controls.add(totalLabel);

        BoxLayout layout2 = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(layout2);
        add(Box.createRigidArea(new Dimension(WIDTH, 0)));

        add(controls);

        setPreferredSize(new Dimension(WIDTH + 250, HEIGHT + 77));

        setBackground(Color.lightGray);
    }

    /**
     * Paint shapes
     * @param page  Graphics object
     */
    public void paintComponent(Graphics page){
        super.paintComponent(page);

        page.setColor(Color.WHITE);
        page.fillRect(0, 0, WIDTH, HEIGHT);

        mediator.paintComponent(page);
    }

    /**
     * Reinitialize GUI
     * Clear all shapes in gui and initialize variable with default value.
     */
    public void reinitialize(){
        PEOPLE = 0;
        CAPACITY = 0;
        firstStart = 0;
        total = 0;
        hospital = 0;
        time = 0;
        healthy = 0;
        infected = 0;
        totalRecovered = 0;
        alive = 0;
        death = 0;
        people = new ArrayList<IndividualInterface>();
    }

    /**
     * Epidemic Listener
     * Each second, Timer run this listener.
     * It will update GUI for each second.
     */
    private class epidemicListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            mediator.move();
            if(pause == true){
                time = 0;
            }
            else {
                time += 1;
            }

            healthyLabel.setText("Healthy Amount: " + healthy);
            infectedLabel.setText("Infected Amount: " + infected);
            hospitalLabel.setText("In Hospital: " + hospital);
            aliveLabel.setText("Total Alive: " + alive);
            deadLabel.setText("Death Amount: " + death);
            totalRecoveredLabel.setText("Total Recovered Amount: " + totalRecovered);
            timeLabel.setText("TIMER: " + time);

            repaint();

            if(pause == true){
                timer.stop();
            }
        }
    }

    /**
     * Slider listener for GUI
     * Update Sliders' Labels.
     */
    private class sliderListener implements ChangeListener{
        public void stateChanged(ChangeEvent e) {
            int count;

            if(e.getSource() == speedSlider) {
                count = speedSlider.getValue();
                speedLabel.setText("Speed (S): " + count);
            }
            else if(e.getSource() == collisionSlider) {
                count = collisionSlider.getValue();
                collisionLabel.setText("Collision (C): " + count);
            }
            else if(e.getSource() == distanceSlider) {
                count = distanceSlider.getValue();
                distanceLabel.setText("Distance (D): " + count);
            }
            else if(e.getSource() == peopleSlider) {
                count = peopleSlider.getValue();
                peopleLabel.setText("People Amount: " + count);
            }
            else if(e.getSource() == spreadingSlider){
                count = spreadingSlider.getValue();
                spreadingLabel.setText("Spreading Factor (R): 0." + count);
            }
            else if(e.getSource() == mortalitySlider){
                count = mortalitySlider.getValue();
                mortalityLabel.setText("Mortality Rate(Z): 0." + count);
            }
        }
    }

    /**
     * Control listener for GUI
     * Play, Pause, Stop and Add button.
     * It will do necessary operation for buttons.
     */
    private class controlListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == playButton){
                pause = false;
                playButton.setEnabled(false);
                addButton.setEnabled(false);
                speedSlider.setEnabled(false);
                collisionSlider.setEnabled(false);
                distanceSlider.setEnabled(false);
                peopleSlider.setEnabled(false);
                maskBox.setEnabled(false);
                pauseButton.setEnabled(true);
                spreadingSlider.setEnabled(false);
                mortalitySlider.setEnabled(false);

                if(firstStart == 0){
                    mediator.setMediator(people);
                    CAPACITY = PEOPLE/100;

                    spreading_R = spreadingSlider.getValue() / 10.0;
                    mortality_Z = mortalitySlider.getValue() / 10.0;
                    firstStart = 1;
                    stopButton.setEnabled(true);
                    alive = PEOPLE;
                    if(PEOPLE > 0){
                        healthy = PEOPLE - 1;
                        infected = 1;
                    }
                    totalRecovered = 0;
                    if(PEOPLE > 0)
                        people.get(0).setTimerDie();

                    timer = new Timer(1000, new epidemicListener());
                    timer.start();
                }
                else{
                    timer.restart();
                }
            }
            else if(e.getSource() == pauseButton){
                pauseButton.setEnabled(false);
                playButton.setEnabled(true);
                pause = true;
                timer.stop();
            }
            else if(e.getSource() == stopButton){
                reinitialize();
                mediator.setMediator(people);
                firstStart = 0;
                stopButton.setEnabled(false);
                playButton.setEnabled(false);
                pauseButton.setEnabled(false);
                addButton.setEnabled(true);
                speedSlider.setEnabled(true);
                collisionSlider.setEnabled(true);
                distanceSlider.setEnabled(true);
                peopleSlider.setEnabled(true);
                maskBox.setEnabled(true);
                spreadingSlider.setEnabled(true);
                mortalitySlider.setEnabled(true);
                total = 0;
                totalLabel.setText("Total People Amount (P): " + total);
                if(pause == true){
                    timer.restart();
                }
                pause = true;
            }
            else if(e.getSource() == addButton){
                playButton.setEnabled(true);
                total += peopleSlider.getValue();
                totalLabel.setText("Total People Amount (P): " + total);

                int amount = peopleSlider.getValue();
                double speed = speedSlider.getValue();
                double collision = collisionSlider.getValue();
                double distance = distanceSlider.getValue();
                double mask;
                boolean stateMask = maskBox.isSelected();
                if(stateMask)
                    mask = 0.2;
                else
                    mask = 1.0;

                IndividualInterface newInd;
                if(people.size() == 0 && amount > 0) {
                    newInd = new Individual(speed, collision, distance, mask, true);
                    people.add(newInd);
                    amount -= 1;
                }
                if(amount > 0) {
                    newInd = new Individuals(amount, speed, collision, distance, mask, false);
                    people.add(newInd);
                }

            }
        }
    }
}
