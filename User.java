import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class User implements Runnable{
    Mediator mediator;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    boolean running = false;


    public User(String host, int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = new Socket("127.0.0.1", port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        running = true;

    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }




    @Override
    public void run() {
        if (running) {
            System.out.println(1);
            String greeting = null;
            try {
                greeting = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            out.println(greeting);
            System.out.println(greeting);
        }
        System.out.println(2);
    }
}
