



/**
 * A function for all of the actions that will be used in the program.
 *
 */

public abstract class Commands {
    protected String display = "";

    /* Constructor */
    public Commands() {

    }

    /*
     *
     * A little description of the method.
     */
    public static String connect(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String join(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String commands(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        StringBuffer sb = new StringBuffer();
        sb.append("\n===================\n");
        sb.append("COMMANDS\n");
        sb.append("===================\n");
        sb.append("\n.connect [address] [port number]");
        sb.append("\n.join ");
        sb.append("\n.post [message subject] [message content]");
        sb.append("\n.users");
        sb.append("\n.leave");
        sb.append("\n.message [message ID]");
        sb.append("\n.exit");
        sb.append("\n.groups");
        sb.append("\n.groupJoin [group name/ groupID]");
        sb.append("\n.groupPost [group name/ groupID] [message subject] [message content]");
        sb.append("\n.groupUsers [group name/ groupID");
        sb.append("\n.groupLeave [group name/ groupID");
        sb.append("\n.groupMessage [group name/ groupID] [messageID]");
        sb.append("\n.commands");

        return sb.toString();
    }

    /*
     *
     * A little description of the method.
     */
    public static String postMessage(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String leaveGroup(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String showUsers(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String findMessageByID(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String exitGroup(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String displayGroups(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String joinGroup(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String groupPost(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String groupUsers(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String leaveMultiGroup(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /*
     *
     * A little description of the method.
     */
    public static String groupMessage(String[] arguments) {
        /*
         * Put your code for myMethod here
         */
        return "";
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        String[] argumentArray = args;
        Controller ctrl = new Controller();
        Model Message = new Model();
        String responseString = "";
        if (args[0] == ".commands") {
            responseString = commands(argumentArray);
        } else if (args[0] == ".join") {
            responseString = join(argumentArray);
        } else if (args[0] == ".connect") {
            responseString = connect(argumentArray);
        } else if (args[0] == ".post") {
            responseString = postMessage(argumentArray);
        } else if (args[0] == ".leave") {
            responseString = leaveGroup(argumentArray);
        } else if (args[0] == ".users") {
            responseString = showUsers(argumentArray);
        } else if (args[0] == ".message") {
            responseString = findMessageByID(argumentArray);
        } else if (args[0] == ".exit") {
            responseString = exitGroup(argumentArray);
        } else if (args[0] == ".groups") {
            responseString = displayGroups(argumentArray);
        } else if (args[0] == ".groupJoin") {
            responseString = joinGroup(argumentArray);
        } else if (args[0] == ".groupPost") {
            responseString = groupPost(argumentArray);
        } else if (args[0] == ".groupUsers") {
            responseString = groupUsers(argumentArray);
        } else if (args[0] == ".groupLeave") {
            responseString = leaveMultiGroup(argumentArray);
        } else if (args[0] == ".groupMessage") {
            responseString = groupMessage(argumentArray);
        }
    }
}