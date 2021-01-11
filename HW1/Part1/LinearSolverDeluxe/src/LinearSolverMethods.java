/**
 *  @author Furkan Ozev
 *  @since 20-11-2020
 *  Homework 1 - 161044036
 *
 *  It is an interface class for solution methods that is used in linear systems.
 */
public interface LinearSolverMethods {
    /***
     * It takes equations, then solve and return solution.
     * @param leftMatrix    double[][] It contains the coefficients in the equations.
     * @param rightMatrix   double[] It contains the results of the equations.
     * @return  double[]    Solution array or null if it has no solution.
     */
    public abstract double[] SolveEquation(double[][] leftMatrix, double[] rightMatrix);
}
