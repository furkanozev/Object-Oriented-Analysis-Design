/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the display specifications.
 */
public abstract class Display {
    /**
     * Keep market specification like (32 bit), (24 bit), (24 bit)
     */
    private String marketSpec;
    /**
     * Keep model specification like (5.5 inches), (5.3 inches), (4.5 inches)
     */
    private String modelSpec;

    /***
     * Get market specification
     * @return  String market specification
     */
    public String getMarketSpec(){
        return marketSpec;
    }

    /**
     * Set market specification
     * @param spec  String  market specification
     */
    public void setMarketSpec(String spec){
        marketSpec = spec;
    }

    /***
     * Get model specification
     * @return  String model specification
     */
    public String getModelSpec(){
        return modelSpec;
    }

    /**
     * Set model specification
     * @param spec  String  model specification
     */
    public void setModelSpec(String spec){
        modelSpec = spec;
    }
}