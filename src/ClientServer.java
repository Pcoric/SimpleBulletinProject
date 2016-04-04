

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientServer {

    public static void main(String[] args) {
        try {
            //create socket
            Socket socket = new Socket("localhost", Integer.parseInt(args[0]));

            //I/O
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            DataOutputStream out = new DataOutputStream(
                    socket.getOutputStream());
            ClientOut CO = new ClientOut(new BufferedReader(
                    new InputStreamReader(socket.getInputStream())));
            CO.run();

            String entry;
            while (true) {
                entry = in.readLine();
                out.writeBytes(entry);
                out.writeBytes("");
            }

        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

}