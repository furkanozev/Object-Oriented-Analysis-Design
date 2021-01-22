import java.awt.*;
import java.util.ArrayList;
/***
 * @author Furkan Ozev
 * @since 18-01-2021
 * Final Project - 161044036
 *
 * MEDIATOR DESING PATTERN
 * check collision, calculate timers, make moves for all individuals.
 */
public class Mediator {
    /**
     * min_D: minimum distance between 2 individuals
     */
    private int min_D;
    /**
     * max_C: maximum collision time between 2 individuals
     */
    private int max_C;

    /**
     * Individuals arraylist.
     */
    private ArrayList<Individual> people = new ArrayList<Individual>();

    /**
     * Set mediator
     * @param people    Arraylist individuals
     */
    public void setMediator(ArrayList<IndividualInterface> people){
        this.people = new ArrayList<Individual>();
        ArrayList<Individual> ind2;

        for(IndividualInterface ind: people){
            if(ind instanceof Individual){
                this.people.add((Individual)ind);
            }
            else{
                ind2 = ((Individuals)ind).getind();
                for(Individual ind3: ind2){
                    this.people.add(ind3);
                }
            }
        }

        Simulator.PEOPLE = this.people.size();
    }

    /**
     * Make move operation all individuals.
     * It also will do some check, calculate, other operations.
     */
    public void move(){
        Individual ind1, ind2;
        int stat1, stat2;

        int size = people.size();
        for(int i = 0; i < size; i++){
            ind1 = people.get(i);
            stat1 = ind1.getStatus();
            if(ind1.getImmobile() == true || stat1 == 2 || stat1 == 4){
                continue;
            }

            for(int j = i+1; j < size; j++){
                ind2 = people.get(j);
                stat2 = ind2.getStatus();
                if(stat2 == 2 || stat2 == 4){
                    continue;
                }
                boolean checkCollision = check(ind1, ind2);
                if(checkCollision){
                    int C1, C2;
                    ind1.setImmobile(true);
                    ind2.setImmobile(true);

                    C1 = ind1.getC();
                    C2 = ind2.getC();
                    max_C = Math.max(C1, C2);

                    ind1.setTime(max_C);
                    ind2.setTime(max_C);

                    if((stat1 == 1 && stat2 == 0) || (stat1 == 0 && stat2 == 1)){
                        double probability;
                        double mask1, mask2;
                        mask1 = ind1.getM_mask();
                        mask2 = ind2.getM_mask();
                        probability = Simulator.spreading_R * (1 + max_C/10.0) * mask1 * mask2 * (1 - min_D/10.0);
                        probability = Math.min(probability, 1);
                        ind1.setProbability(probability);
                        ind2.setProbability(probability);
                    }
                }
            }
        }

        for(int i = 0; i < size; i++)
        {
            Individual temp = people.get(i);
            temp.move();
        }
    }

    /**
     * Paint all individuals on GUI
     * @param page graphics page
     */
    public void paintComponent(Graphics page){
        Individual temp;
        int status;

        for(int i = 0; i < people.size(); i++){
            temp = people.get(i);
            status = temp.getStatus();
            switch(status){
                case 0:
                    page.setColor(Color.green);
                    break;
                case 1:
                    page.setColor(Color.red);
                    break;
            }

            if(status == 0 || status == 1)
                page.fillRect(temp.getX(), temp.getY(), 5, 5);
        }
    }

    /**
     * Check collision between 2 individual.
     * @param ind1  individual1
     * @param ind2  individual2
     * @return  If collision is exist is true, otherwise false.
     */
    private boolean check(Individual ind1, Individual ind2){
        boolean stat1, stat2;
        stat1 = ind1.getImmobile();
        stat2 = ind2.getImmobile();

        if(stat1 == false && stat2 == false) {
            double x1, y1, x2, y2;
            double dist = 0;
            int D1, D2;

            x1 = ind1.getX();
            y1 = ind1.getY();

            x2 = ind2.getX();
            y2 = ind2.getY();

            int dx = (int)(x2 - x1);
            int dy = (int)(y2 - y1);

            dist = (int) Math.sqrt(dx*dx + dy*dy) - 5;
            dist = Math.max(dist, 0);
            D1 = ind1.getD();
            D2 = ind2.getD();

            min_D = Math.min(D1, D2);

            if (dist <= min_D)
                return true;
            else
                return false;
        }
        return false;
    }

}
