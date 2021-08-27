import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String address = "127.0.0.1";
        try ( Phone phone = new Phone(address, 8080)){
            System.out.println("we connected");
            String request = "Khabarovsk";


            System.out.println("Request: " + request);

            phone.writeLine(request);
            String respond = phone.readLine();
            System.out.println("Respond: " + respond);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
