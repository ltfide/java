import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Response {
    int status;
    String statusMsg;
    String content;
    int length;

    void setStatus(int status) {
        this.status = status;
        if (status == 200) {
            statusMsg = "OK";
        } else if (status == 404) {
            statusMsg = "Not Found";
            setContent("Not found");
        } else if (status == 405) {
            statusMsg = "Method Not Allowed";
            setContent("Method Not Allowed");
        }
    }

    void setContent(String content) {
        this.content = content;
        this.length = content.length();
    }
}

public class Server {

    private final static int PORT = 8080;

    private static void handleConnection(Socket clienSocket) throws Exception {
        InputStream inputStream = clienSocket.getInputStream();
        OutputStream outputStream = clienSocket.getOutputStream();

        // read data from client
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        String requestData = new String(buffer, 0, bytesRead);
        System.out.println("Received from client: " + requestData);

        String body = extractBody(requestData);
        String httpMethod = requestData.substring(0, 4).trim();
        String path = parsePath(requestData);

        Response responseData = handleRoute(path, httpMethod, body);    

        String response = """
                HTTP/1.1 $status $stsMsg
                Content-Type: text/plain
                Content-length: $length

                $content
                """.replace("$status", String.valueOf(responseData.status))
                .replace("$stsMsg", responseData.statusMsg)
                .replace("$length", String.valueOf(responseData.length))
                .replace("$content", responseData.content);

        outputStream.write(response.getBytes());
        System.out.println("Sent to client: " + response);

        inputStream.close();
        outputStream.close();
    }

    private static Response handleRoute(String path, String httpMethod, String body) {
        Response resp = new Response();
        resp.setStatus(200);
        switch (path) {
            case "/hello":
                if (httpMethod.equals("GET")) {
                    resp.setStatus(200);
                    resp.setContent("Hello, client!");
                } else if (httpMethod.equals("POST")) {
                    resp.setStatus(200);
                    resp.setContent(body);
                } else {
                    resp.setStatus(405);
                }
                break;
            case "/greet":
                if (httpMethod.equals("GET")) {
                    resp.setStatus(200);
                    resp.setContent("Greetings!");
                } else {
                    resp.setStatus(405);
                }
                    break;
            default:
                resp.setStatus(404);
                break;
        }

        return resp;
    }

    private static String extractBody(String requestData) {
        int doubleNewlineIndex = requestData.indexOf("\r\n\r\n");
        if (doubleNewlineIndex != -1) {
            return requestData.substring(doubleNewlineIndex + 4);
        }
        return "";
    }

    private static String parsePath(String requestData) {
        // Implementasi sederhana untuk mendapatkan path dari permintaan
        String[] lines = requestData.split("\\r?\\n");
        String[] requestLine = lines[0].split(" ");
        return requestLine.length > 1 ? requestLine[1] : "/";
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                handleConnection(clientSocket);

                clientSocket.close();
                System.out.println("Client disconnected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                try {
                    serverSocket.close();
                    System.out.println("Server socket closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}