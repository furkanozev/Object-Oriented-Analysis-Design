/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the camera specifications.
 */
public abstract class Camera {
    /**
     * Keep market specification like (Opt. zoom x4), (Opt. zoom x3), (Opt. zoom x2)
     */
    private String marketSpec;
    /**
     * Keep model specification like (12Mp front, 8Mp rear), (12Mp front, 5Mp rear), (8Mp front, 5Mp rear)
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