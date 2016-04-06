import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class BulletinMain {
    //a memory variable for storing the users
    static ArrayList<String> userList = new ArrayList<String>();
    //the messageID
    static int MID = 0;
    //a memory data structure to hold messages
    static ArrayList<Controller.Information> messageList = new ArrayList<Controller.Information>();
    
    public static void main(String args[]) throws Exception {
        //current Socket
        ServerSocket currSocket = new ServerSocket();
        try {
            
            //try to setup address
            InetSocketAddress currAddress = new InetSocketAddress(
                                                                  Integer.parseInt(args[0]));
            
            //bind the address to socket
            currSocket.bind(currAddress);
            
            System.out.println("Server is Listening now!");
            
            while (true) {
                Socket socket = currSocket.accept();
                
                //setup ThreadReader and begin
                System.out.println("Client is connected!");
                Controller controller = new Controller();
                Controller.ThreadReader tr = controller.new ThreadReader(socket);
                
                tr.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}