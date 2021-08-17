import java.io.*;
import java.net.*;
import java.util.Stack;

public class PostfixServer {
    public static void main(String args[]) throws IOException, ClassNotFoundException{

        ServerSocket serverSocket = null;
        Socket connectionSocket = null;

        ObjectInputStream server_in = null;
        ObjectOutputStream server_out = null;

        System.out.println("Listening for Clients...");

        try{
            serverSocket = new ServerSocket(5000);
            connectionSocket = serverSocket.accept();
            server_in = new ObjectInputStream(connectionSocket.getInputStream());
            server_out = new ObjectOutputStream(connectionSocket.getOutputStream());
        } catch(IOException io){
            System.out.println("Could not establish connection using port number");
        }

        System.out.println("Connection Established");

        String exp = "";
        while(!exp.equalsIgnoreCase("disconnect")){
            exp = (String) server_in.readObject();
            String res = toPostfix(exp);
            server_out.writeObject(res);
        }
        serverSocket.close();
        connectionSocket.close();
    }

    static String toPostfix(String exp){

        String result = "";
        exp = exp.replaceAll("\\s", "");

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c))
                result += c;
               
            else if (c == '(')
                stack.push(c);
              
            else if (c == ')')
            {
                while (!stack.isEmpty() && 
                        stack.peek() != '(')
                    result += stack.pop();
                  
                    stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && Prec(c) 
                         <= Prec(stack.peek())){
                    
                    result += stack.pop();
             }
                stack.push(c);
            }
       
        }

        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
         }

        return result;
    }

    static int Prec(char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
       
        case '*':
        case '/':
            return 2;
       
        case '^':
            return 3;
        }
        return -1;
    }
}
