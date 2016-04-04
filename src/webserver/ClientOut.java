package webserver;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientOut extends Thread {
    public BufferedReader in1;

    public ClientOut(BufferedReader in2) {
        this.in1 = in2;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(this.in1.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}