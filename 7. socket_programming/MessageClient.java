import java.net.*;
import java.io.*;

class MessageClient {
    public static void main(String args[]) throws UnknownHostException, IOException{

        String mssg = "";
        String mssg_received = "";

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        ObjectOutputStream client_out = null;
        ObjectInputStream from_server = null;
        Socket clientSoc = null;

        InetAddress addr = InetAddress.getLocalHost();

        clientSoc = new Socket(addr, 5000);
        client_out = new ObjectOutputStream(clientSoc.getOutputStream());
        from_server = new ObjectInputStream(clientSoc.getInputStream());

        System.out.println("[ Establishing connection ]");

        System.out.println("[ Connection Established ]");
        System.out.println("Enter Username");
        String username = stdin.readLine();
        client_out.writeObject(username);
        System.out.println("[ Username Synched with Server ]");
        System.out.println("Enter Your Message...");

        while(!mssg.equalsIgnoreCase("!disconnect")){
            mssg = "";
            mssg = stdin.readLine();
            client_out.writeObject(mssg);
            try {
                mssg_received = (String) from_server.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("\t\t[ "+mssg_received+" ]");
        }

        System.out.println("[ Disconnected from the server ]");
        clientSoc.close();
        client_out.close();
    }
}
