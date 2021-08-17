import java.io.*;
import java.net.*;

public class PostfixClient {
    public static void main(String args[]) throws IOException, ClassNotFoundException
    {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        ObjectOutputStream client_out = null;
        ObjectInputStream from_server = null;
        Socket clientSoc = null;

        clientSoc = new Socket("127.0.0.1", 5000);
        client_out = new ObjectOutputStream(clientSoc.getOutputStream());
        from_server = new ObjectInputStream(clientSoc.getInputStream());

        System.out.println("Connection Established");

        String exp = "";
        String res = "";

        while(!exp.equalsIgnoreCase("disconnect")){
            System.out.println("Enter your expression");
            exp = stdin.readLine();
            client_out.writeObject(exp);

            System.out.println("Postfix Expression: ");
            res = (String) from_server.readObject();
            System.out.println(res);
        }

        clientSoc.close();
        from_server.close();
    }
}
