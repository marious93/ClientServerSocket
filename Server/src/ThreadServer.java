import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started");
            while (true) {
                Phone phone = new Phone(server);
                new Thread(() -> {
                    String request =  phone.readLine();
                    System.out.println("Request: " + request);
                  //  String respond = "Hello from server " + request.length();
                    String respond = (int) (Math.random() * 30) + "";
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    phone.writeLine(respond);
                    System.out.println("Respond: " + respond);

                    try {phone.close();}
                    catch(IOException e){
                        e.printStackTrace();
                    }
                }).start();

            }
        }

        catch(IOException e){
                throw new RuntimeException(e);
        }}
    }


