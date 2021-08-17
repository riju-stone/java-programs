import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class LexServer {
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        ServerSocket serverSocket = null;
        Socket connectionSocket = null;

        ObjectInputStream fromClient = null;
        ObjectOutputStream serverOut = null;

        String clientMssg = "", sortedMssg = "";

        System.out.println("[ Listening for Clients... ]");

        serverSocket = new ServerSocket(5000);
        connectionSocket = serverSocket.accept();
        fromClient = new ObjectInputStream(connectionSocket.getInputStream());
        serverOut = new ObjectOutputStream(connectionSocket.getOutputStream());

        while(!clientMssg.equalsIgnoreCase("!disconnect")){
            clientMssg = (String) fromClient.readObject();
            sortedMssg = lexSort(clientMssg);
            serverOut.writeObject(sortedMssg);
        }

        serverSocket.close();
        connectionSocket.close();
    }

    static String lexSort(String str){
        String res = "";
        String temp = "";
        String[] strArray = str.split(" ");

        for(int i = 0; i < strArray.length; i++){
            for(int j = i + 1; j < strArray.length; j++){
                if(strArray[i].compareToIgnoreCase(strArray[j]) > 0){
                    temp = strArray[i];
                    strArray[i] = strArray[j];
                    strArray[j] = temp;
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < strArray.length; i++){
            sb.append(strArray[i]+", ");
        }

        res = sb.toString();
        System.out.println(res);

        return res;
    }
}
