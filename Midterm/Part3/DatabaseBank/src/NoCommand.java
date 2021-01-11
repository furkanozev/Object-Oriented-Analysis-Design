/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the no command.
 */
public class NoCommand implements Command {
    /**
     * Execute command
     * @param item  object to execute
     */
    public void execute(Object item) { }

    /**
     * Undo last command
     */
    public void undo() { }
}