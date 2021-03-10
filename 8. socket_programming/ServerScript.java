import java.net.*;
import java.io.*;

public class ServerScript {
    public static void main(String args[]) throws IOException, SocketTimeoutException{

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        //Server socket for establishing a server connection
        ServerSocket server_socket = null;

        //Client type socket for establishing connection with the server
        Socket connection_socket = null;

        //For receiving messages from the client
        BufferedReader server_in = null;

        //For sending output to the client
        BufferedWriter server_out = null;

        String client_username = "";
        int port;

        System.out.println("Enter you connection port");
        port = Integer.parseInt(stdin.readLine());

        System.out.println("[ Server Booted ]");
        System.out.println("[ Listening for Clients ]");
        server_socket = new ServerSocket(port);
        try{
            connection_socket = server_socket.accept();
            server_in = new BufferedReader(new InputStreamReader(connection_socket.getInputStream()));
            server_out = new BufferedWriter(new OutputStreamWriter(connection_socket.getOutputStream()));
        } 
        catch(IOException e){
            System.out.println("Could not establish connection using mentioned port number");
        }

        System.out.println("[ Connection Established with Client ]");

        String client_mssg = "";

        client_mssg = server_in.readLine();
        client_username = client_mssg;
        client_mssg = "";

        while(!client_mssg.equalsIgnoreCase("!disconnect")){
            client_mssg = server_in.readLine();
            System.out.println(client_username+" : "+ client_mssg);
            // server_out.write("[ Server : Message Received ]");
            // server_out.flush();
        }

        System.out.println("[ "+client_username+" disconnected ]");
        server_socket.close();
        server_in.close();
        server_out.close();
    }
}
