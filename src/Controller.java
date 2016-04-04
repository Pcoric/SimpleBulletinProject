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
        
        public void begin() {
            try {
                BufferedReader input = new BufferedReader(
                                                          new InputStreamReader(this.Socket.getInputStream()));
                //this.ot = new OutThread();
                Users user = new Users();
                this.ot = new OutThread(this.Socket, user); //fix
                StringBuilder sb = new StringBuilder();
                
                sb.append("Hello, you have entered a chat Message Board.\n");
                sb.append("Various commands will be used to chat.\n");
                sb.append("For now enter user as the first command\n");
                sb.append("You will now create a username!\n");
                this.ot.setCurrOut(sb.toString());
                this.ot.pw.print(this.ot.getCurrentMessage());
                while (true) {
                    this.ot.setCurrOut(this.getCommand(input.readLine()));
                }
                //this.Socket.close();
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
            
        }
        
        public String getCommand(String command) {
            String end = "";
            //action requests
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
        
        public void begin() {
            while (true) {
                this.pw.print("Enter a command!");
                this.pw.println("response: " + this.getCurrentMessage());
                this.setCurrOut("empty");
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