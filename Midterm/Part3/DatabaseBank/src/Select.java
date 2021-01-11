import java.util.Stack;

/***
 * @author Furkan Ozev
 * @since 04-12-2020
 * Midterm Project - 161044036
 *
 * This class is used to indicate the select command.
 */
public class Select implements Command{
    /**
     * Keep objects in stack
     */
    private Stack stack = new Stack();
    /**
     * Keep copy objects in stack to return
     */
    private Stack stack2 = new Stack();

    /**
     * Select command execution function
     * @param item  object to execute
     */
    public void selectOperation(Object item){
        stack.push(item);
        System.out.println("--- Select operation process completed. ---");
    }

    /**
     * Execute command
     * @param item  object to execute
     */
    public void execute(Object item){
        System.out.println("--- Select execute command is started. Object: " + item + " ---");
        selectOperation(item);
        System.out.println("--- Select execute command is finished. ---\n");
    }

    /**
     * Undo last command
     */
    public void undo(){
        System.out.println("--- Undo select command is started. ---");
        if(!stack.empty()){
            Object item = stack.pop();
            System.out.println("--- Undo select command is finished. Object: " + item + " ---\n");
        }
        else{
            System.out.println("--- Undo select command is finished. ---\n");
        }
    }

    /**
     * Convert to string
     * @return  String  command
     */
    public String toString() {
        if(stack2.empty()){
            stack2 = (Stack) stack.clone();
        }
        return (String) stack2.pop();
    }
}
