import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started");
            while (true) {
                try (Phone phone = new Phone(server)) {
                    String request = phone.readLine();
                    System.out.println("Request: " + request);
                    String respond = "Hello from server " + request.length();
                    phone.writeLine(respond);
                    System.out.println("Respond: " + respond);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }

        catch(IOException e){
                throw new RuntimeException(e);
        }}
    }


