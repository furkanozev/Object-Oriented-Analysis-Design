/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the case specifications.
 */
public abstract class Case {
    /**
     * Keep market specification like (Waterproof up to 2m), (Waterproof up to 1m), (Waterproof up to 50cm)
     */
    private String marketSpec;
    /**
     * Keep model specification like (151x73x7.7 mm dustproof, waterproof, aluminum), (149x73x7.7 mm waterproof, aluminum), (143x69x7.3 mm waterproof, plastic)
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