/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the main class.
 */
public class Main {
    /**
     * main function
     * @param args  String  argumant
     */
    public static void main(String[] args){
        Database database = new Database(3);

        Select selectCommand = new Select();
        database.setCommand(0, selectCommand);

        Update updateCommand = new Update();
        database.setCommand(1, updateCommand);

        Alter alterCommand = new Alter();
        database.setCommand(2, alterCommand);

        System.out.println(database);

        database.executeCommand(0, "Select-1 Command");
        database.executeCommand(1, "Update-1 Command");
        database.executeCommand(2, "Alter-1 Command");

        database.executeCommand(0, "Select-2 Command");
        database.executeCommand(2, "Alter-2 Command");
        database.undoCommand();

        database.executeCommand(1, "Update-3 Command");
        database.executeCommand(2, "Alter-3 Command");
        database.executeCommand(0, "Select-3 Command");
        database.undoCommand();
        database.undoCommand();

        database.printProcessHistory();

        database.executeCommand(1, "Update-4 Command");
        database.executeCommand(2, "Alter-4 Command");
        database.executeCommand(1, "Update-5 Command");
        database.executeCommand(0, "Select-4 Command");
        database.executeCommand(0, "Select-5 Command");
        database.executeCommand(1, "Update-6 Command");
        database.executeCommand(2, "Alter-5 Command");
        database.executeCommand(0, "Select-6 Command");
        database.executeCommand(2, "Alter-6 Command");
        database.undoCommand();
        database.executeCommand(2, "Alter-7 Command");
        database.executeCommand(1, "Update-7 Command");
        database.undoCommand();
        database.undoCommand();
        database.executeCommand(0, "Select-7 Command");
        database.executeCommand(0, "Select-8 Command");
        database.undoCommand();
        database.executeCommand(1, "Update-8 Command");

        database.printProcessHistory();

    }
}
