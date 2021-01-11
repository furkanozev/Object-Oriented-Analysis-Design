import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *  @author Furkan Ozev
 *  @since 20-11-2020
 *  Homework 1 - 161044036
 *
 *  Graphical User Interface
 */
public class GUI extends JFrame{
    /***
     *  To keep length of row
     */
    private int row = 0;
    /***
     *  To keep length of column
     */
    private int col = 0;
    /***
     *  To Equation solver object
     */
    private LinearEqSolver Solver = null;
    /***
     *  To keep gui JPanel
     */
    private JPanel mainPanel;
    /***
     *  To keep gui JPanel
     */
    private JPanel panel2;
    /***
     *  To keep label
     */
    private JLabel b;
    /***
     *  To keep left matrix
     *  double[][] It contains the coefficients in the equations.
     */
    private double[][] leftMatrix;
    /***
     * To keep right matrix
     * double[] It contains the results of the equations.
     */
    private double[] rightMatrix;
    /***
     *  To keep text fields of left matrix
     */
    private TextField[][] TFields1;
    /***
     *  To keep text fields of right matrix
     */
    private TextField[] TFields2;
    /***
     *  To keep text field of row
     */
    private JTextField rowTextField;
    /***
     *  To keep text field of column
     */
    private JTextField colTextField;

    /***
     * To run Linear Solver Deluxe GUI
     * @param args  String[] args
     */
    public static void main(String[] args) {
        GUI gui = new GUI();
    }

    /***
     * Constructor of GUI
     * To create main panel
     */
    public GUI(){
        super();

        this.setTitle("Linear Solver Deluxe");
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.lightGray);
        this.add(mainPanel);
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(Jpanel1());

        panel2 = new JPanel();
        panel2 = Jpanel2();

        mainPanel.add(panel2);
        setContentPane(mainPanel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /***
     * First panel to get input like row, column
     * And includes some button like create matrix, solve
     * @return  JPanel  first panel
     */
    private JPanel Jpanel1(){
        JPanel retPanel = new JPanel(new FlowLayout());
        retPanel.setPreferredSize(new Dimension(450, 80));
        retPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        retPanel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
        Border border = new LineBorder(Color.GREEN, 4, true);
        retPanel.setBorder(border);
        retPanel.setBackground(Color.WHITE);

        JLabel rowTag = new JLabel("Row: ");
        rowTextField = new JTextField();
        rowTextField.setPreferredSize(new Dimension(50,24 ));

        JLabel colTag = new JLabel("Column: ");
        colTextField = new JTextField();
        colTextField.setPreferredSize(new Dimension(50,24 ));

        JLabel metTag = new JLabel("Method: ");
        Methods[] metIntegers = Methods.values();
        JComboBox methodCombo = new JComboBox<>();

        for(int i = 0; i < Methods.getSize(); i++)
            methodCombo.addItem(metIntegers[i]);

        methodCombo.addActionListener((ae) -> {
            try {
                methodType((Methods) methodCombo.getSelectedItem());
            } catch (Exception ex) {
                GUI.printRes("Warning", ex.getMessage());
            }
        });

        JButton solverMatrix = new JButton("Solve Equation");
        solverMatrix.setVisible(true);

        solverMatrix.addActionListener((ActionEvent ae) -> {
            try {
                methodType((Methods) methodCombo.getSelectedItem());
                leftMatrix = new double[row][col];
                int k = col;

                for(int i = 0; i < row; i++){
                    for(int j = 0; j < col; j++)
                        leftMatrix[i][j] = Double.parseDouble(TFields1[i][j].getText());
                }

                rightMatrix = new double[col];

                for(int i = 0; i < col; i++)
                    rightMatrix[i] = Double.parseDouble(TFields2[i].getText());

                Solver.setLeftMatrix(leftMatrix);
                Solver.setRightMatrix(rightMatrix);
                double[] result = Solver.SolveLinearEquation();

                GUI.printRes("Result", result);
            } catch (Exception ex) {
                GUI.printRes("Warning", ex.getMessage());
            }
        });

        JButton createMatrix = new JButton("Create Matrix");

        createMatrix.addActionListener((ActionEvent ae) -> {
            try {
                row = (int) Integer.parseInt(rowTextField.getText());
                col = (int) Integer.parseInt(colTextField.getText());
                if(row <= 0)
                    throw new Exception("row must be positive");
                else if(col <= 0)
                    throw new Exception("column must be positive");
            } catch (Exception ex) {
                GUI.printRes("Warning", "Please enter positive integer number for row and column.\n" + ex.getMessage());
                row = 0;
                col = 0;
            }

            mainPanel.remove(panel2);
            panel2 = Jpanel2();
            mainPanel.add(panel2);
            b.setVisible(true);
            setContentPane(mainPanel);
        });

        JButton clearMatrix = new JButton("Clear Matrix");

        clearMatrix.addActionListener((ae) -> {
            mainPanel.remove(panel2);
            panel2 = Jpanel2();
            mainPanel.add(panel2);
            b.setVisible(false);
            setContentPane(mainPanel);
            Solver = null;
        });

        retPanel.add(rowTag);
        retPanel.add(rowTextField);
        retPanel.add(colTag);
        retPanel.add(colTextField);
        retPanel.add(createMatrix);
        retPanel.add(clearMatrix);
        retPanel.add(metTag);
        retPanel.add(methodCombo);
        retPanel.add(solverMatrix);

        return retPanel;
    }

    /***
     * second panel to get left and right matrices
     * @return  JPanel  second panel
     */
    private JPanel Jpanel2(){
        JPanel retPanel = new JPanel(new BorderLayout());
        retPanel.setPreferredSize(new Dimension(640, 320));

        JPanel leftMatrixPane = new JPanel();
        JPanel rightMatrixPane = new JPanel();

        leftMatrixPane.setLayout(null);
        rightMatrixPane.setLayout(null);

        leftMatrixPane.setPreferredSize(new Dimension(col * 50, row * 35));
        rightMatrixPane.setPreferredSize(new Dimension(row, col * 35));
        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS ;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS ;

        JScrollPane scroll1 = new JScrollPane(leftMatrixPane,v,h);
        scroll1.setBorder(new LineBorder(Color.yellow,4));

        JScrollPane scroll2 = new JScrollPane(rightMatrixPane,v,h);
        scroll2.setBorder(new LineBorder(Color.red,4));

        scroll1.setPreferredSize(new Dimension(520, 320));
        scroll2.setPreferredSize(new Dimension(120, 320));
        createMatrices(leftMatrixPane, rightMatrixPane);

        retPanel.add(scroll1, BorderLayout.WEST);
        retPanel.add(scroll2, BorderLayout.EAST);
        return retPanel;
    }

    /***
     * Determine solving metgod
     * @param choosed   Methods enum for methods
     * @throws Exception    To keep any exception.
     */
    private void methodType(Methods choosed) throws Exception{
        if(row == col){
            switch(choosed){
                case GAUSSIAN_ELIMINATION:
                    if(Solver == null)
                        Solver = new LinearEqSolver(new GaussianElim());
                    else
                        Solver.setSolverMethod(new GaussianElim());
                    break;
                case MATRIX_INVERSION:
                    if(Solver == null)
                        Solver = new LinearEqSolver(new MInversion());
                    else
                        Solver.setSolverMethod(new MInversion());
                    break;
            }
        }
        else
            throw new Exception("It must be square matrix.\n (Row == Column)");
    }

    /***
     * Create left and right matrices' fields.
     * Show on gui.
     * @param leftMatrixP   JPanel  left matrix panel
     * @param rightMatrixP  JPanel  right matrix panel
     */
    private void createMatrices(JPanel leftMatrixP, JPanel rightMatrixP){
        JLabel[][] matrixLabel = new JLabel[row][col];
        TFields1 = new TextField[row][col];
        TFields2 = new TextField[row];

        for(int i = 0; i < col; i++){
            matrixLabel[0][i] = new JLabel("A"+i);
            matrixLabel[0][i].setBounds(48*i+45, 0, 30, 25);
            leftMatrixP.add(matrixLabel[0][i]);
        }
        for(int i = 0; i < row; i++){
            matrixLabel[i][0] = new JLabel("A"+i);
            matrixLabel[i][0].setBounds(5, 33*i+30, 30, 25);
            leftMatrixP.add(matrixLabel[i][0]);

            for(int j = 0; j < col; j++){
                TFields1[i][j] = new TextField("" + 0);
                TFields1[i][j].setBounds(48*j+45, 33*i+30, 30, 25);
                leftMatrixP.add(TFields1[i][j]);
            }
        }

        b = new JLabel("B");
        b.setVisible(false);
        b.setBounds(35, 0, 25, 25);
        rightMatrixP.add(b);
        JLabel rightMatrixLabel[] = new JLabel[row];

        for(int i = 0; i < row; i++ ){
            rightMatrixLabel[i] = new JLabel("B"+i);
            rightMatrixLabel[i].setBounds(5, 33*i+30, 30, 25);
            rightMatrixP.add(rightMatrixLabel[i]);
            TFields2[i] = new TextField("" + 0);
            TFields2[i].setBounds(35, 33*i+30, 30, 25);
            rightMatrixP.add(TFields2[i]);
        }
    }

    /***
     * Print result on gui.
     * @param title String  result window title
     * @param message   String  print result message
     */
    public static void printRes(String title, String message){
        int err;

        if("Warning".equals(title))
            err = JOptionPane.ERROR_MESSAGE;
        else
            err = JOptionPane.CLOSED_OPTION;

        JOptionPane.showMessageDialog(new JFrame(), message, title, err);
    }

    /***
     * Print result on gui
     * @param title result window title
     * @param res   double[]    print solution of linear equations system.
     */
    public static void printRes(String title, double[] res) {
        if (res == null)
            printRes(title, "There is no suitable solution.");
        else {
            String message = "";

            for (int i = 0; i < res.length; i++) {
                message += ("x" + (i + 1) + ": " + String.format("%.4f", res[i]) + "\n");
            }

            message += "\n";

            printRes(title, message);
        }
    }
}