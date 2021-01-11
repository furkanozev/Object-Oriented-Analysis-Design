/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the cpu and ram specifications.
 */
public abstract class CPU_RAM {
    /**
     * Keep market specification like (8 cores), (4 cores), (2 cores)
     */
    private String marketSpec;
    /**
     * Keep model specification like (2.8GHz, 8GB), (2.2GHz, 6GB), (2.2GHz, 4GB)
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