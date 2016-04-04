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
        
        @Override
        public void start() {
            try{
                BufferedReader input = new BufferedReader(new InputStreamReader(this.Socket.getInputStream()));
                this.ot = new OutThread();
                
            }
        }
    }
    
    public class OutThread extends Thread{
        private PrintWriter pw;
        
        public OutThread(Socket socket, )
        
    }
}