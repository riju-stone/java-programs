import java.net.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class ClientScript {
    public static void main(String args[]) throws UnknownHostException, IOException{

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        //Client Socket
        Socket socket = null;

        //For taking client inputs
        BufferedReader client_in = null;

        //For sending the client messeges to server
        BufferedWriter client_out = null;

        int port;

        //Both server and client port numbers should be the same for a successful connection
        System.out.println("Enter your communication port");
        port = Integer.parseInt(stdin.readLine());

        String mssg = "";
        String mssg_received = "";

        System.out.println("[ Establishing connection ]");

        try{
            TimeUnit.SECONDS.sleep(1);
            socket = new Socket("127.0.0.1", port);
            client_in = new BufferedReader(new InputStreamReader(System.in));
            client_out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }
        catch(InterruptedException interrupt){
            System.out.println("Connection process interrupted...");
        }
        catch(UnknownHostException nohost){
            System.out.println("Couldn\'t locate mentioned host...");
        }

        System.out.println("[ Connection Established ]");
        System.out.println("Enter Username");
        String username = client_in.readLine();
        client_out.write(username);
        client_out.newLine();
        client_out.flush();
        System.out.println("[ Username Synched with Server ]");
        System.out.println("Enter Your Message...");

        while(!mssg.equalsIgnoreCase("!disconnect")){
            mssg = "";
            mssg = stdin.readLine();
            client_out.write(mssg);
            client_out.newLine();
            client_out.flush();
            // mssg_received = client_in.readLine();
            // System.out.println("[ "+mssg_received+" ]");
        }

        System.out.println("[ Disconnected from the server ]");
        socket.close();
        client_in.close();
        client_out.close();
    }
}
