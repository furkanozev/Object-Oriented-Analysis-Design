import java.util.Stack;

/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the database.
 */
public class Database {
    /**
     * Keep commands in array
     */
    private Command[] commands;
    /**
     * commands amount
     */
    private int number;
    /**
     * Keep commands in stack
     */
    private Stack<Command> undoCommand = new Stack<Command>();

    /**
     * Database constructor
     * @param number    int command amount
     */
    public Database(int number){
        commands = new Command[number];
        this.number = number;

        Command noCommand = new NoCommand();
        for(int i = 0; i < number; i++){
            commands[i] = noCommand;
        }
    }

    /**
     * Set commands
     * @param slot  int slot of command
     * @param command   Command command
     */
    public void setCommand(int slot, Command command)
    {
        commands[slot] = command;
    }

    /**
     * Execute command
     * @param slot  int slot of command
     * @param item  Object  object to execute
     */
    public void executeCommand(int slot, Object item){
        commands[slot].execute(item);
        undoCommand.push(commands[slot]);
    }

    /**
     * Undo last command
     */
    public void undoCommand(){
        if(!undoCommand.empty()){
            Command lastCommand = undoCommand.pop();
            lastCommand.undo();
        }
        else{
            System.out.println("There is no operation to undo.\n");
        }

    }

    /**
     * Convert to string
     * @return  String  string
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n---------- DATABASE ----------\n");

        for(int i = 0; i < number; i++){
            buffer.append("[slot " + i + "] " + commands[i].getClass().getName() + "\n");
        }

        return buffer.toString();
    }

    /**
     * Print process history
     */
    public void printProcessHistory()
    {
        System.out.println("\n---------- Process History ----------\n");
        for(int i = undoCommand.size() - 1; i >= 0; i--){
            System.out.println("Process #" + (i+1) + " " + undoCommand.elementAt(i) + "\n");
        }
        System.out.println("--------------------\n");
    }

}
