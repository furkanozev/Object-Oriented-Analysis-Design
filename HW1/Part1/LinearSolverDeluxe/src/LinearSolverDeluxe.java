/**
 *  @author Furkan Ozev
 *  @since 20-11-2020
 *  Homework 1 - 161044036
 *
 *  It is an abstract class for solving linear equation system.
 */
public abstract class LinearSolverDeluxe {
    /***
     * Solution method for solving equation.
     */
    protected LinearSolverMethods method;
    /***
     * It contains the coefficients in the equations.
     */
    protected double[][] leftMatrix;
    /***
     * It contains the results of the equations.
     */
    protected double[] rightMatrix;

    /***
     * Default constructor
     */
    public LinearSolverDeluxe() {
        method = null;
    }

    /***
     * Constructor that takes the method as a parameter.
     * @param method    LinearSolverMethods     solving method of linear equation
     */
    public LinearSolverDeluxe(LinearSolverMethods method) {
        this.method = method;
    }

    /***
     * Set coefficients matrix (left matrix) with new one.
     * @param matrix    double[][]  new left matrix
     * @return  boolean if success true, else false
     */
    public boolean setLeftMatrix(double[][] matrix) {
        if(matrix == null)
            return false;
        else{
            leftMatrix = matrix;
            return true;
        }
    }

    /***
     * Set equations' results matrix (right matrix) with new one.
     * @param matrix    double[][]  new right matrix
     * @return  boolean if success true, else false
     */
    public boolean setRightMatrix(double[] matrix) {
        if(matrix == null)
            return false;
        else{
            rightMatrix = matrix;
            return true;
        }
    }

    /***
     * Set solve method with new one.
     * @param method    LinearSolverMethods Solution method of linear equations
     */
    public void setSolverMethod(LinearSolverMethods method)
    {
        this.method = method;
    }

    /***
     * General linear equation solving method
     * @return  double[]    if exists it result of linear equation system, else null
     */
    public abstract double[] SolveLinearEquation();
}
