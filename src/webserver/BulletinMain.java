package webserver;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BulletinMain {
    public static void main(String args[]) throws Exception {
        ServerSocket currSocket = new ServerSocket();

        try {
            InetSocketAddress currAddress = new InetSocketAddress(
                    Integer.parseInt(args[0]));

            //load boards

            currSocket.bind(currAddress); //bind
            System.out.println("Server is Listening now!");

            while (true) {
                Socket socket = currSocket.accept();
                System.out.println("Client is connected!");
                //begin thread

            }
        } catch (Exception e) {
            System.out.println("Error Occured!");
        }

    }

}