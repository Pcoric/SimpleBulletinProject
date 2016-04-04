package webserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Controller{
    public class ThreadReader extends Thread{
        
        private OutThread ot;
        private Socket Socket;
        
        //boolean?
        
        public ThreadReader(Socket socket){
            this.Socket = socket;
        }
        
        
        public void begin() {
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(this.Socket.getInputStream()));
                //this.ot = new OutThread();
                
                ot = new OutThread(Socket, Users.instance()); //fix
                ot.setCurrOut("various information");
                while(true) {
                    ot.setCurrOut(getCommand(input.readLine()));
                }
                Socket.close();
            }
            catch (Exception e){
                System.out.println("ERROR!");
            }
        }
        public String getCommand(String command){
            String end = "";
            //action requests
            return end;
        }
        
    }
    
    public class OutThread extends Thread{
        private PrintWriter pw;
        private Users Users;
        private String currOut = "empty";
        
        public OutThread(Socket socket, Users user){
            this.Users = user;
            this.pw = new PrintWriter(socket.getOutputStream(), true);
            this.start();
        }
        
        public void begin(){
            while(true){
                pw.print("Enter a command!");
                pw.println("response: "+ getCurrentMessage());
                setCurrOut("empty");
                pw.flush();
                
            }
        }
        
        public String getCurrentMessage(){
            return currOut;
        }
        
        public void setCurrOut(String message){
            this.currOut = message;
        }
    }
    
    public class Users{
        String ID;
        
        public void setUser(String id){
            this.ID = id;
        }
        
        public String getUserID(){
            return this.ID;
        }
    }
}