import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Controller {
    public void Controller() {
        
    }
    
    public class ThreadReader extends Thread {
        ArrayList<String> userList = new ArrayList<String>();
        ArrayList<Information> messageList = new ArrayList<Information>();
        
        private OutThread ot;
        private Socket Socket;
        private BufferedReader input;
        
        //boolean?
        
        public ThreadReader(Socket socket) throws IOException {
            this.Socket = socket;
            this.input = new BufferedReader(new InputStreamReader(
                                                                  this.Socket.getInputStream()));
            
        }
        
        public void user() throws IOException {
            if (this.ot.curUser != "") {
                this.ot.pw.println("Sorry your username can only be set once");
                this.ot.pw.println("Your current username is: "
                                   + this.ot.curUser);
            } else {
                this.ot.pw
                .println("Please enter the username you would like to use!");
                this.ot.curUser = this.input.readLine();
                this.ot.pw.println("Your current username is: "
                                   + this.ot.curUser);
            }
        }
        
        /*
         *
         * A little description of the method.
         */
        public String connect(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public String join(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public void commands() {
            /*
             * Put your code for myMethod here
             */
            StringBuilder sb = new StringBuilder();
            sb.append("Heres a list of Commands!");
            sb.append("COMMANDS\n");
            sb.append("\n connect [address] [port number]");
            sb.append("\n join ");
            sb.append("\n post [message subject] [message content]");
            sb.append("\n users");
            sb.append("\n leave");
            sb.append("\n message [message ID]");
            sb.append("\n exit");
            sb.append("\n groups");
            sb.append("\n groupJoin [group name/ groupID]");
            sb.append("\n groupPost [group name/ groupID] [message subject] [message content]");
            sb.append("\n groupUsers [group name/ groupID");
            sb.append("\n groupLeave [group name/ groupID");
            sb.append("\n groupMessage [group name/ groupID] [messageID]");
            sb.append("\n commands");
            
            this.ot.pw.print(sb.toString());
        }
        
        /*
         *
         * A little description of the method.
         */
        public String postMessage(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public String leaveGroup(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public String showUsers(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public String findMessageByID(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public String exitGroup(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public String displayGroups(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public String joinGroup(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public String groupPost(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public String groupUsers(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public String leaveMultiGroup(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        /*
         *
         * A little description of the method.
         */
        public String groupMessage(String[] arguments) {
            /*
             * Put your code for myMethod here
             */
            return "";
        }
        
        @Override
        public void run() {
            try {
                
                //this.ot = new OutThread();
                // Users user = new Users();
                this.ot = new OutThread(this.Socket); //fix
                StringBuilder sb = new StringBuilder();
                
                sb.append("Hello, you have entered a chat Message Board.\n");
                sb.append("Various commands will be used to chat.\n");
                sb.append("Here is a list of commands.\n");
                sb.append("You must enter username command first!\n");
                sb.append("You will now create a username.\n");
                //this.ot.setCurrOut(sb.toString());
                this.ot.pw.print(sb.toString());
                while (true) {
                    
                    this.ot.setCurrOut(this.getCommand(this.input.readLine())); //change to procesinput
                }
                //this.Socket.close();
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
            
        }
        
        public String getCommand(String command) throws IOException {
            String end = "";
            
            switch (command) {
                case "list":
                case "join":
                case "commands":
                    this.commands();
                    break;
                case "groupMessage":
                    break;
                    
                case "groupLeave":
                    break;
                    
                case "groupUsers":
                    break;
                    
                case "groupPost":
                    break;
                    
                case "groupJoin":
                    break;
                    
                case "groups":
                    break;
                    
                case "exit":
                    break;
                    
                case "message":
                    break;
                    
                case "users":
                    break;
                    
                case "leave":
                    break;
                    
                case "post":
                    break;
                    
                case "connect":
                    break;
                    
                case "user":
                    this.user();
                    break;
                    
                default:
                    System.out.println("Enter something competent");
                    end = "Enter a real command!";
                    break;
                    
            }
            return end;
        }
        
    }
    
    public class OutThread extends Thread {
        private PrintWriter pw;
        String curUser = "";
        String curGID = "";
        String curGName = "";
        private String currOut = "empty";
        
        public OutThread(Socket socket) {
            try {
                this.pw = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            this.start();
        }
        
        @Override
        public void run() {
            while (true) {
                /*
                 * this.pw.print("Enter a command!");
                 * this.pw.println("response: " + this.getCurrentMessage());
                 * this.setCurrOut("empty");
                 */
                this.pw.flush();
                
            }
        }
        
        public String getCurrentMessage() {
            return this.currOut;
        }
        
        public void setCurrOut(String message) {
            this.currOut = message;
        }
    }
    
    public class Information {
        private String MID;
        private String Subject;
        private String User;
        private String Date;
        private String GName;
        private String GID;
        
        public Information(String subject, String user, String date,
                           String mID, String gname, String gid) {
            this.MID = mID;
            this.Date = date;
            this.Subject = subject;
            this.User = user;
            this.GID = gid;
            this.GName = gname;
            
        }
        
        public String getGID() {
            return this.GID;
        }
        
        public String getGName() {
            return this.GName;
        }
        
        public String getSubject() {
            return this.Subject;
        }
        
        public String getUser() {
            return this.User;
        }
        
        public String getDate() {
            return this.Date;
        }
        
        public String getMID() {
            return this.MID;
        }
    }
    
    /*
     * public class group { private String GName; private String GID;
     *
     * public group(String gName, String gID) { this.GName = gName; this.GID =
     * gID; }
     *
     * public String nameGet() { return this.GName; }
     *
     * public String getID() { return this.GID; } } }
     */
}