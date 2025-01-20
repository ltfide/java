import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebSocketServer {

    private static int PORT = 8081;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("WebSocket Server started on port: " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            try {
                WebSocketConnection 
            }
        }
    }

}