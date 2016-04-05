import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {
    public void Controller() {
        
    }
    
    public class ThreadReader extends Thread {
        
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
                this.ot.pw.println("size" + BulletinMain.userList.size());
                this.ot.pw
                .println("Please enter the username you would like to use!");
                String potential = this.input.readLine();
                if (BulletinMain.userList.contains(potential)) {
                    this.ot.pw.println("The username " + potential
                                       + " Already Exists!");
                    this.ot.pw.println("Please try again!");
                } else {
                    this.ot.curUser = potential;
                    this.ot.pw.println("Your current username is: "
                                       + this.ot.curUser);
                    BulletinMain.userList.add(this.ot.curUser);
                }
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
        
        public void viewMessages() {
            if (this.ot.curGName.equals("")) {
                this.ot.pw
                .println("Please join a group first to view messages!");
                
            } else {
                for (int i = 0; i < BulletinMain.messageList.size(); i++) {
                    Information info = BulletinMain.messageList.get(i);
                    if (info.GID.equals(this.ot.curGID)) {
                        this.ot.pw.println(info.MID + ", " + info.User + ", "
                                           + info.Date + ", " + info.Subject);
                    }
                }
            }
        }
        
        /*
         *
         * A little description of the method.
         */
        
        public void joinD() {
            /*
             * Put your code for myMethod here
             */
            this.ot.pw
            .println("You have joined the default group for messaging!");
            this.ot.pw
            .println("Try the view messages command to see what people are saying here!");
            this.ot.curGName = "Default";
            this.ot.curGID = "0";
            // BulletinMain.tr1.start();
            
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
            sb.append("\n viewMessages");
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
            this.ot.pw.println("");
        }
        
        /*
         *
         * A little description of the method.
         */
        public void postMessage() throws IOException {
            /*
             * Put your code for myMethod here
             */
            
            if (this.ot.curUser == "") {
                this.ot.pw.println("Please enter a username before messaging");
            } else if (this.ot.curGID.equals("")) {
                this.ot.pw.println("Please join a group before messaging!");
            } else {
                int MID = BulletinMain.MID;
                LocalDateTime date1 = LocalDateTime.now();
                this.ot.pw.println("Please enter the subject of the message!");
                String subject = this.input.readLine();
                String user = this.ot.curUser;
                String GID = this.ot.curGID;
                String GName = this.ot.curGName;
                this.ot.pw.println("Please enter the content of the message!");
                String content = this.input.readLine();
                Information info = new Information(subject, user,
                                                   date1.toString(), Integer.toString(MID), GName, GID,
                                                   content);
                BulletinMain.messageList.add(info);
                this.ot.pw.println("Succesfully added message!");
                BulletinMain.MID++;
            }
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
        public void showUsers() {
            /*
             * Put your code for myMethod here
             */
            this.ot.pw.print("Current Listed Users");
            for (int i = 0; i < BulletinMain.userList.size(); i++) {
                this.ot.pw.print(BulletinMain.userList.get(i));
            }
        }
        
        /*
         *
         * A little description of the method.
         */
        public String findMessageByID() throws IOException {
            /*
             * Put your code for myMethod here
             */
            ArrayList<Information> messageList = BulletinMain.messageList;
            String mID = "";
            String message = "";
            this.ot.pw.println("Please enter the message ID you'd like to find");
            mID = this.input.readLine();
            for (Information x : messageList){
                if (x.MID == mID){
                    // Change to get content.
                    message = x.getSubject();
                }
            }
            if (message == ""){
                this.ot.pw.println("No message ID like that exists");
            }
            return message;
            
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
         * Retrieves a message given a group id and message id
         */
        public String groupMessage() throws IOException {
            /*
             * Put your code for myMethod here
             */
            ArrayList<Information> messageList = BulletinMain.messageList;
            String gID = "";
            String mID = "";
            String message = "";
            this.ot.pw.println("Please enter the group ID you'd like to iterate through");
            gID = this.input.readLine();
            this.ot.pw.println("Please enter the message ID you'd like to find");
            mID = this.input.readLine();
            for (Information x : messageList){
                if (x.GID == gID && x.MID == mID){
                    // Change to get content when applicable.
                    message = x.getSubject();
                }
            }
            if (message == ""){
                this.ot.pw.println("No such message exists.");
            }
            return message;
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
                sb.append("Type user to Begin!\n");
                //this.ot.setCurrOut(sb.toString());
                this.ot.pw.print(sb.toString());
                while (true) {
                    
                    this.ot.setCurrOut(this.getCommand(this.input.readLine())); //change to procesinput
                }
                //this.Socket.close();
            } catch (Exception e) {
                System.out.println("Error running reader thread!");
            }
            
        }
        
        public String getCommand(String command) throws IOException {
            String end = "";
            
            switch (command) {
                case "list":
                    break;
                case "join":
                    this.joinD();
                    break;
                    
                case "commands":
                    this.commands();
                    break;
                    
                case "groupMessage":
                    this.groupMessage();
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
                    
                case "findMessage":
                    this.findMessageByID();
                    break;
                    
                case "message":
                    this.postMessage();
                    break;
                    
                case "users":
                    this.showUsers();
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
                    
                case "viewMessages":
                    this.viewMessages();
                    break;
                    
                default:
                    System.out.println("Enter one of the following commands:");
                    this.commands();
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
        private String content;
        
        public Information(String subject, String user, String date,
                           String mID, String gname, String gid, String content) {
            this.MID = mID;
            this.Date = date;
            this.Subject = subject;
            this.User = user;
            this.GID = gid;
            this.GName = gname;
            this.content = content;
            
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

