/**
 *  @author Furkan Ozev
 *  @since 20-11-2020
 *  Homework 1 - 161044036
 *
 *  It is an concrete class for solving linear equation system.
 */
public class LinearEqSolver extends LinearSolverDeluxe {

    /***
     * Default constructor
     */
    public LinearEqSolver()
    {
        method = null;
    }

    /***
     * Constructor that takes the method as a parameter.
     * @param method    LinearSolverMethods     solving method of linear equation
     */
    public LinearEqSolver(LinearSolverMethods method)
    {
        super(method);
    }

    /***
     * General linear equation solving method
     * @return  double[]    if exists it result of linear equation system, else null
     */
    @Override
    public double[] SolveLinearEquation(){
        if(method != null)
            return method.SolveEquation(leftMatrix, rightMatrix);
        else
            return null;
    }
}
