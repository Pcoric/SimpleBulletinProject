import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class Controller {
    public void Controller() {
        
    }
    
    public class ThreadReader extends Thread {
        private boolean runOnce = true; //variable to make sure intro is only printed once
        private OutThread ot;
        private Socket Socket;
        private BufferedReader input;
        
        //boolean?
        
        public ThreadReader(Socket socket) throws IOException {
            this.Socket = socket;
            this.input = new BufferedReader(new InputStreamReader(
                                                                  this.Socket.getInputStream()));
            
        }
        
        //function to create user
        public void user() throws IOException {
            //if it exist cant rest
            if (this.ot.curUser != "") {
                this.ot.pw.println("Sorry your username can only be set once");
                this.ot.pw.println("Your current username is: "
                                   + this.ot.curUser);
            } else {
                //prompt and add to arraylist
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
        
        //function to viewMessages done elsewhere now, kept for safety
        public void viewMessages() {
            if (!this.ot.curGName.equals("")) {
                for (int i = 0; i < BulletinMain.messageList.size(); i++) {
                    Information info = BulletinMain.messageList.get(i);
                    if (info.GID.equals(this.ot.curGID)) {
                        this.ot.pw.println(info.MID + ", " + info.User + ", "
                                           + info.Date + ", " + info.Subject);
                    }
                }
                
            } else {
                for (int i = 0; i < BulletinMain.messageList.size(); i++) {
                    Information info = BulletinMain.messageList.get(i);
                    
                    if (info.GID.equals("1") && this.ot.in1
                        && info.wrote == false) {
                        info.wrote = true;
                        this.ot.pw.println(info.MID + ", " + info.User + ", "
                                           + info.Date + ", " + info.Subject);
                    }
                    if (info.GID.equals("2") && this.ot.in2
                        && info.wrote == false) {
                        info.wrote = true;
                        this.ot.pw.println(info.MID + ", " + info.User + ", "
                                           + info.Date + ", " + info.Subject);
                    }
                    if (info.GID.equals("3") && this.ot.in3
                        && info.wrote == false) {
                        info.wrote = true;
                        this.ot.pw.println(info.MID + ", " + info.User + ", "
                                           + info.Date + ", " + info.Subject);
                    }
                    if (info.GID.equals("4") && this.ot.in4
                        && info.wrote == false) {
                        info.wrote = true;
                        this.ot.pw.println(info.MID + ", " + info.User + ", "
                                           + info.Date + ", " + info.Subject);
                    }
                    if (info.GID.equals("5") && this.ot.in5
                        && info.wrote == false) {
                        info.wrote = true;
                        this.ot.pw.println(info.MID + ", " + info.User + ", "
                                           + info.Date + ", " + info.Subject);
                    }
                }
            }
        }
        
        /*
         *
         * join default group
         */
        
        public void joinD() {
            /*
             * Put your code for myMethod here
             */
            //set variables to be in default
            this.ot.pw
            .println("You have joined the default group for messaging!");
            this.ot.pw
            .println("Try the view messages command to see what people are saying here!");
            this.ot.curGName = "Default";
            this.ot.curGID = "0";
            
        }
        
        /*
         *
         * function to print commands
         */
        public void commands() {
            /*
             * Put your code for myMethod here
             */
            //string builder for lengthy commands
            StringBuilder sb = new StringBuilder();
            sb.append("Heres a list of Commands!");
            sb.append("Type them and you will be given instructions!");
            sb.append("COMMANDS\n");
            sb.append("\n message (posts a message to default)");
            sb.append("\n exit (exits completely)");
            sb.append("\n findMessage (prints content of message by MID)");
            sb.append("\n groups (lists groups)");
            sb.append("\n groupJoin (joins a specific group)");
            sb.append("\n groupPost (posts to a specific group)");
            sb.append("\n groupUsers (lists users in a group)");
            sb.append("\n groupLeave (leave a specfic group)");
            sb.append("\n groupMessage (find content of message by groupid and mid)");
            sb.append("\n commands (lists all commands)");
            sb.append("\n join (joins default)");
            sb.append("\n post (posts to default)");
            sb.append("\n users (lists all users)");
            sb.append("\n user (creates a user)");
            sb.append("\n leave (leaves default)");
            
            this.ot.pw.print(sb.toString());
            this.ot.pw.println("");
        }
        
        /*
         *
         * function to post message to default
         */
        public void postMessage() throws IOException {
            /*
             * Put your code for myMethod here
             */
            //need username first and to be in group
            if (this.ot.curUser == "") {
                this.ot.pw.println("Please enter a username before messaging");
            } else if (this.ot.curGID.equals("")) {
                this.ot.pw.println("Please join a group before messaging!");
            } else {
                //get info, creat information object and add to list
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
                                                   content, false);
                BulletinMain.messageList.add(info);
                this.ot.pw.println("Succesfully added message!");
                BulletinMain.MID++;
            }
        }
        
        /*
         *
         * leave a specific group
         */
        public void leaveGroup() throws IOException {
            /*
             * Put your code for myMethod here
             */
            //prompt and reset variables depending on input
            this.ot.pw.println("Which specific group would you like to leave?");
            String potential = this.input.readLine();
            switch (potential) {
                case "1":
                    this.ot.in1 = false;
                    this.ot.pw.println("Succesfully left group 1!");
                    break;
                case "2":
                    this.ot.in2 = false;
                    this.ot.pw.println("Succesfully left group 2!");
                    break;
                case "3":
                    this.ot.in3 = false;
                    this.ot.pw.println("Succesfully left group 3!");
                    break;
                case "4":
                    this.ot.in4 = false;
                    this.ot.pw.println("Succesfully left group 4!");
                    break;
                case "5":
                    this.ot.in5 = false;
                    this.ot.pw.println("Succesfully left group 5!");
                    break;
                default:
                    this.ot.pw.println("Enter a valid group to leave!");
                    break;
            }
        }
        
        /*
         *
         * list all users
         */
        public void showUsers() {
            /*
             * Put your code for myMethod here
             */
            //iterate through arraylist and print
            this.ot.pw.println("Current Listed Users");
            for (int i = 0; i < BulletinMain.userList.size(); i++) {
                this.ot.pw.println(BulletinMain.userList.get(i));
            }
            
        }
        
        /*
         *
         * display all groups in easy to read format
         */
        public void displayGroups() {
            /*
             * Put your code for myMethod here
             */
            this.ot.pw.println("Here are a list of groups to join");
            this.ot.pw.println("GroupID: 1, GroupName: 1");
            this.ot.pw.println("GroupID: 2, GroupName: 2");
            this.ot.pw.println("GroupID: 3, GroupName: 3");
            this.ot.pw.println("GroupID: 4, GroupName: 4");
            this.ot.pw.println("GroupID: 5, GroupName: 5");
            
        }
        
        /*
         *
         * join a specific group
         */
        public void joinGroup() throws IOException {
            //prompt for group and set variables according to which group entered
            this.ot.pw.println("Which group would you like to join?");
            this.ot.pw
            .println("Joining a group will cause you to leave the default group!");
            String potential = this.input.readLine();
            switch (potential) {
                case "1":
                    this.ot.curGID = "";
                    this.ot.curGName = "";
                    this.ot.in1 = true;
                    this.ot.pw.println("Succesfully joined group 1!");
                    break;
                case "2":
                    this.ot.curGID = "";
                    this.ot.curGName = "";
                    this.ot.in2 = true;
                    this.ot.pw.println("Succesfully joined group 2!");
                    break;
                case "3":
                    this.ot.curGID = "";
                    this.ot.curGName = "";
                    this.ot.in3 = true;
                    this.ot.pw.println("Succesfully joined group 3!");
                    break;
                case "4":
                    this.ot.curGID = "";
                    this.ot.curGName = "";
                    this.ot.in4 = true;
                    this.ot.pw.println("Succesfully joined group 4!");
                    break;
                case "5":
                    this.ot.curGID = "";
                    this.ot.curGName = "";
                    this.ot.in5 = true;
                    this.ot.pw.println("Succesfully joined group 5!");
                    break;
                default:
                    this.ot.pw
                    .println("Please enter a valid group name or ID!");
            }
        }
        
        /*
         *
         * post to a specific group
         */
        public void groupPost() throws IOException {
            /*
             * Put your code for myMethod here
             */
            //build informatio and post to specfic group which user input
            this.ot.pw.println("Which group would you like to post to? ");
            String potential = this.input.readLine();
            int MID = BulletinMain.MID;
            LocalDateTime date1 = LocalDateTime.now();
            String subject = "";
            String user = "";
            String GID = "";
            String GName = "";
            String content = "";
            Information info;
            switch (potential) {
                    
                case "1":
                    
                    this.ot.pw
                    .println("Please enter the subject of the message!");
                    subject = this.input.readLine();
                    user = this.ot.curUser;
                    GID = "1";
                    GName = "1";
                    this.ot.pw
                    .println("Please enter the content of the message!");
                    content = this.input.readLine();
                    info = new Information(subject, user, date1.toString(),
                                           Integer.toString(MID), GName, GID, content, false);
                    BulletinMain.messageList.add(info);
                    
                    BulletinMain.MID++;
                    this.ot.pw.println("Succesfully messaged group 1!");
                    break;
                case "2":
                    this.ot.pw
                    .println("Please enter the subject of the message!");
                    subject = this.input.readLine();
                    user = this.ot.curUser;
                    GID = "2";
                    GName = "2";
                    this.ot.pw
                    .println("Please enter the content of the message!");
                    content = this.input.readLine();
                    info = new Information(subject, user, date1.toString(),
                                           Integer.toString(MID), GName, GID, content, false);
                    BulletinMain.messageList.add(info);
                    
                    BulletinMain.MID++;
                    this.ot.pw.println("Succesfully messaged group 2!");
                    break;
                case "3":
                    this.ot.pw
                    .println("Please enter the subject of the message!");
                    subject = this.input.readLine();
                    user = this.ot.curUser;
                    GID = "3";
                    GName = "3";
                    this.ot.pw
                    .println("Please enter the content of the message!");
                    content = this.input.readLine();
                    info = new Information(subject, user, date1.toString(),
                                           Integer.toString(MID), GName, GID, content, false);
                    BulletinMain.messageList.add(info);
                    
                    BulletinMain.MID++;
                    this.ot.pw.println("Succesfully messaged group 3!");
                    break;
                case "4":
                    this.ot.pw
                    .println("Please enter the subject of the message!");
                    subject = this.input.readLine();
                    user = this.ot.curUser;
                    GID = "4";
                    GName = "4";
                    this.ot.pw
                    .println("Please enter the content of the message!");
                    content = this.input.readLine();
                    info = new Information(subject, user, date1.toString(),
                                           Integer.toString(MID), GName, GID, content, false);
                    BulletinMain.messageList.add(info);
                    
                    BulletinMain.MID++;
                    this.ot.pw.println("Succesfully messaged group 4!");
                    break;
                case "5":
                    this.ot.pw
                    .println("Please enter the subject of the message!");
                    subject = this.input.readLine();
                    user = this.ot.curUser;
                    GID = "5";
                    GName = "5";
                    this.ot.pw
                    .println("Please enter the content of the message!");
                    content = this.input.readLine();
                    info = new Information(subject, user, date1.toString(),
                                           Integer.toString(MID), GName, GID, content, false);
                    BulletinMain.messageList.add(info);
                    
                    BulletinMain.MID++;
                    this.ot.pw.println("Succesfully messaged group 5!");
                    break;
                default:
                    this.ot.pw
                    .println("Please enter a valid group name or ID!");
            }
            
        }
        
        //leave default group
        public void leave() {
            /*
             * Put your code for myMethod here
             */
            //reset vars
            this.ot.curGID = "";
            this.ot.curGName = "";
            this.ot.pw.println("You have succesfully left the default group!");
        }
        
        //function to print content of message id
        public void findMessageByID() throws IOException {
            /*
             * Put your code for myMethod here
             */
            //iterate through if mid is found print it
            String mID = "";
            String message = "";
            this.ot.pw
            .println("Please enter the message ID you'd like to find");
            mID = this.input.readLine();
            for (Information x : BulletinMain.messageList) {
                if (x.MID.equals(mID)) {
                    // Change to get content.
                    message = x.content;
                }
            }
            if (message == "") {
                this.ot.pw.println("No message ID like that exists");
            } else {
                this.ot.pw.println("The content of the message is: " + message);
            }
            
        }
        
        /*
         *
         * get content of specfic message in group
         */
        public void groupMessage() throws IOException {
            /*
             * Put your code for myMethod here
             */
            //search for group id and message id, if found print it
            String gID = "";
            String mID = "";
            String message = "";
            this.ot.pw
            .println("Please enter the group ID you'd like to iterate through");
            gID = this.input.readLine();
            this.ot.pw
            .println("Please enter the message ID you'd like to find");
            mID = this.input.readLine();
            for (Information x : BulletinMain.messageList) {
                if (x.GID.equals(gID) && x.MID.equals(mID)) {
                    // Change to get content when applicable.
                    message = x.content;
                }
            }
            if (message.equals("")) {
                this.ot.pw.println("No such message exists.");
            } else {
                this.ot.pw.println("The content of the message is, " + message);
            }
        }
        
        @Override
        public void run() {
            try {
                //intitial info printed
                
                this.ot = new OutThread(this.Socket);
                StringBuilder sb = new StringBuilder();
                
                sb.append("Hello, you have entered a chat Message Board.\n");
                sb.append("Various commands will be used to chat.\n");
                sb.append("Here is a list of commands.\n");
                sb.append("You must enter username command first!\n");
                
                this.ot.pw.print(sb.toString());
                this.commands();
                this.ot.pw.println("Start with user to begin!");
                while (true) {
                    //get input and run specific command
                    this.getCommand(this.input.readLine()); //change to
                }
                
            } catch (Exception e) {
                System.out.println("Error running reader thread!");
            }
            
        }
        
        //get users in a group
        public void groupUsers() {
            // iterate through if user is found with the right id print it
            this.ot.pw.print("Current Users in Group:\n");
            for (String usr : BulletinMain.userList) {
                for (Information info : BulletinMain.messageList) {
                    if (usr.equals(info.User)
                        && this.ot.curGID.equals(info.GID)) {
                        this.ot.pw.println(usr);
                    }
                }
            }
        }
        
        /*
         *
         * exits the program
         */
        public void exitGroup() {
            System.exit(0);
        }
        
        //take input and call a function depending on input
        public void getCommand(String command) throws IOException {
            String end = "";
            
            switch (command) {
                    //joins default
                case "join":
                    this.joinD();
                    break;
                    //lists available commands
                case "commands":
                    this.commands();
                    break;
                    //finds message content by group and MID
                case "groupMessage":
                    this.groupMessage();
                    break;
                    //leaves a specific group
                case "groupLeave":
                    this.leaveGroup();
                    break;
                    //lists users in a group
                case "groupUsers":
                    this.groupUsers();
                    break;
                    //posts to a specific group
                case "groupPost":
                    this.groupPost();
                    break;
                    //joins a specific group
                case "groupJoin":
                    this.joinGroup();
                    break;
                    //lists groups
                case "groups":
                    this.displayGroups();
                    break;
                    //exits completely
                case "exit":
                    //add
                    this.exitGroup();
                    break;
                    //finds message by MID
                case "findMessage":
                    this.findMessageByID();
                    break;
                    //posts message to default
                case "message":
                    this.postMessage();
                    break;
                    //lists all users
                case "users":
                    this.showUsers();
                    break;
                    //leaves default
                case "leave":
                    this.leave();
                    break;
                    //creates a user
                case "user":
                    this.user();
                    break;
                    //viewsMessages
                case "viewMessages":
                    this.viewMessages();
                    break;
                    
                default:
                    this.ot.pw.println("Enter a real command!");
                    
                    break;
                    
            }
            
        }
        
    }
    
    public class OutThread extends Thread {
        private PrintWriter pw;
        //default group variables
        String curUser = "";
        String curGID = "";
        String curGName = "";
        //variables to check with gorup a user is in
        boolean in1 = false;
        boolean in2 = false;
        boolean in3 = false;
        boolean in4 = false;
        boolean in5 = false;
        //checks to see if something is already printed
        boolean[] stuff = new boolean[10000];
        
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
                
                try {
                    //make sure it is not overloaded
                    sleep(15);
                    //print messages
                    this.viewMessages();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                this.pw.flush();
                
            }
        }
        
        //function to viewMessages in real time
        public void viewMessages() throws InterruptedException {
            //function to print default
            if (!this.curGName.equals("")) {
                for (int i = 0; i < BulletinMain.messageList.size(); i++) {
                    
                    Information info = BulletinMain.messageList.get(i);
                    //if stuff[i] is true its already been printed
                    if (info.GID.equals(this.curGID) && this.stuff[i] == false) {
                        this.stuff[i] = true; //set to true so its not double printed
                        //BulletinMain.messageList.set(i, info);
                        this.pw.println(info.MID + ", " + info.User + ", "
                                        + info.Date + ", " + info.Subject);
                    }
                }
                /*
                 * this.pw
                 * .println("Please join a group first to view messages!");
                 */
                //prints messages from groups
            } else if (this.in1 || this.in2 || this.in3 || this.in4 || this.in5) {
                for (int i = 0; i < BulletinMain.messageList.size(); i++) {
                    Information info = BulletinMain.messageList.get(i);
                    
                    if (info.GID.equals("1") && this.in1
                        && this.stuff[i] == false) {
                        
                        this.stuff[i] = true;
                        this.pw.println(info.MID + ", " + info.User + ", "
                                        + info.Date + ", " + info.Subject);
                    }
                    if (info.GID.equals("2") && this.in2
                        && this.stuff[i] == false) {
                        this.stuff[i] = true;
                        this.pw.println(info.MID + ", " + info.User + ", "
                                        + info.Date + ", " + info.Subject);
                    }
                    if (info.GID.equals("3") && this.in3
                        && this.stuff[i] == false) {
                        this.stuff[i] = true;
                        this.pw.println(info.MID + ", " + info.User + ", "
                                        + info.Date + ", " + info.Subject);
                    }
                    if (info.GID.equals("4") && this.in4
                        && this.stuff[i] == false) {
                        this.stuff[i] = true;
                        this.pw.println(info.MID + ", " + info.User + ", "
                                        + info.Date + ", " + info.Subject);
                    }
                    if (info.GID.equals("5") && this.in5
                        && this.stuff[i] == false) {
                        this.stuff[i] = true;
                        this.pw.println(info.MID + ", " + info.User + ", "
                                        + info.Date + ", " + info.Subject);
                    }
                }
            }
        }
        
    }
    
    //class to store information about a message
    public class Information {
        private String MID;
        private String Subject;
        private String User;
        private String Date;
        private String GName;
        private String GID;
        private String content;
        private boolean wrote;
        
        public Information(String subject, String user, String date,
                           String mID, String gname, String gid, String content,
                           boolean wrote) {
            this.MID = mID;
            this.Date = date;
            this.Subject = subject;
            this.User = user;
            this.GID = gid;
            this.GName = gname;
            this.content = content;
            this.wrote = wrote;
            
        }
        
    }
}