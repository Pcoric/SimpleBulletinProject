import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Controller {
    public void Controller() {
        
    }
    
    public class ThreadReader extends Thread {
        
        private OutThread ot;
        private Socket Socket;
        
        
        //boolean?
        
        public ThreadReader(Socket socket) {
            this.Socket = socket;
        }
        
        public String user(String[] arguments) {
            return "";
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
                BufferedReader input = new BufferedReader(
                                                          new InputStreamReader(this.Socket.getInputStream()));
                //this.ot = new OutThread();
                Users user = new Users();
                this.ot = new OutThread(this.Socket, user); //fix
                StringBuilder sb = new StringBuilder();
                
                sb.append("Hello, you have entered a chat Message Board.\n");
                sb.append("Various commands will be used to chat.\n");
                sb.append("Here is a list of commands.\n");
                sb.append("You must enter username command first!\n");
                sb.append("You will now create a username.\n");
                //this.ot.setCurrOut(sb.toString());
                this.ot.pw.print(sb.toString());
                while (true) {
                    
                    this.ot.setCurrOut(this.getCommand(input.readLine())); //change to procesinput
                }
                //this.Socket.close();
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
            
        }
        
        public String getCommand(String command) {
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
        private Users Users;
        private String currOut = "empty";
        
        public OutThread(Socket socket, Users user) {
            this.Users = user;
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
    
    public class Users {
        String ID;
        
        public void setUser(String id) {
            this.ID = id;
        }
        
        public void User() {
            
        }
        
        public String getUserID() {
            return this.ID;
        }
    }
}