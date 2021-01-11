/**
 *  @author Furkan Ozev
 *  @since 20-11-2020
 *  Homework 1 - 161044036
 *
 *  It is an enum class for keep types of solution methods.
 */
public enum Methods {
    /***
     * Methods type enum : MATRIX_INVERSION
     */
    MATRIX_INVERSION,
    /***
     * Methods type enum : GAUSSIAN_ELIMINATION
     */
    GAUSSIAN_ELIMINATION;

    /***
     * It return size of enums.
     * @return  int size of types.
     */
    public static int getSize()
    {
        return Methods.values().length;
    }
}