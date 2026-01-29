import java.io.*;
import java.net.*;
public class ChatClient 
{
    public static void main(String[] args) 
    {
        try 
        {
            Socket socket = new Socket("localhost",1234);
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(socket.getOutputStream(), true);
            new Thread(()-> 
            {
                try 
                {
                    String msg;
                    while ((msg=in.readLine())!=null) 
                    {
                        System.out.println(msg);
                    }
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }).start();
            String input;
            while ((input=userInput.readLine())!=null) 
            {
                out.println(input);
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
