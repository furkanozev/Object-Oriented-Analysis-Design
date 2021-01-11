/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the storage specifications.
 */
public abstract class Storage {
    /**
     * Keep market specification like (Max 128 GB), (Max 64 GB), (Max 32 GB)
     */
    private String marketSpec;
    /**
     * Keep model specification like (MicroSD support, 64GB), (MicroSD support, 32GB), (MicroSD support, 16GB)
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