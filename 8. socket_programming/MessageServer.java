import java.net.*;
import java.io.*;

class Thread{

    ServerSocket serverSocket = null;
    Socket connectionSocket = null;

    ObjectInputStream server_in = null;
    ObjectOutputStream server_out = null;

    void start(){
        connect();
    }

    void connect(){

        System.out.println("Listening for Clients...");

        try{
            serverSocket = new ServerSocket(5000);
            connectionSocket = serverSocket.accept();
            server_in = new ObjectInputStream(connectionSocket.getInputStream());
            server_out = new ObjectOutputStream(connectionSocket.getOutputStream());
        } catch(IOException io){
            System.out.println("Could not establish connection using port number");
        }

        System.out.println("[ Connection Established with Client ]");
    }

    void initChat() throws ClassNotFoundException, IOException, InterruptedException{
        String client_mssg = "";
        String client_username = "";

        client_mssg = (String) server_in.readObject();
        client_username = client_mssg;
        client_mssg = "";

        while(!client_mssg.equalsIgnoreCase("!disconnect")){
            client_mssg = (String) server_in.readObject();
           
            System.out.println(client_username+" : "+ client_mssg);
        }

        disconnect(client_username);
    }

    void disconnect(String username) throws IOException{
        System.out.println("[ "+username+" disconnected ]");
        serverSocket.close();
        connectionSocket.close();
        server_in.close();
        server_out.close();
    }
}

class MessageServer {
    public static void main(String args[]){

        Thread user = new Thread();
        user.start();
        try{
            user.initChat();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch(IOException i){
            i.printStackTrace();
        } catch(InterruptedException ie){
            ie.printStackTrace();
        }
        
    }
    
}
