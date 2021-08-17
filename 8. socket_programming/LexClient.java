import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class LexClient {
    public static void main(String args[]) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        String mssg = "";
        String mssg_received = "";

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        ObjectOutputStream clientOut = null;
        ObjectInputStream fromServer = null;
        Socket clientSoc = null;

        InetAddress addr = InetAddress.getLocalHost();

        clientSoc = new Socket(addr, 5000);
        clientOut = new ObjectOutputStream(clientSoc.getOutputStream());
        fromServer = new ObjectInputStream(clientSoc.getInputStream());

        System.out.println("[ Establishing Connection... ]");
        System.out.println("[ Connection Escablished ]");

        while(!mssg.equalsIgnoreCase("!disconnect")){
            System.out.println("Enter your String...");
            mssg = "";
            mssg = stdin.readLine();
            clientOut.writeObject(mssg);
            clientOut.flush();
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("\t\t\t\tSorted String:");
            mssg_received = (String) fromServer.readObject();
            System.out.println("\t\t\t\t"+mssg_received);
        }

        System.out.println("[ Disconnected from Sever ]");
        clientSoc.close();
        fromServer.close();
        clientOut.close();
    }
}
