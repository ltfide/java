import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connected to server");

            // send to server
            String requestData = "GET /hello HTTP/1.1\r\n" +
                    "Host: localhost:8080\r\n" +
                    "Connection: close\r\n\r\n";
                    
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(requestData.getBytes());
            System.out.println("Sent to server: " + requestData);

            // received response from server
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int byteReads = inputStream.read(buffer);
            String responseData = new String(buffer, 0, byteReads);
            System.out.println("Received from server: " + responseData);

            // close connection
            outputStream.close();
            inputStream.close();
            socket.close();
            System.out.println("Disconnected from server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
