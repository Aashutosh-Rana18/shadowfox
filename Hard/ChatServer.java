import java.io.*;
import java.net.*;
import java.util.*;
public class ChatServer 
{
    private static Set<ClientHandler> clients = new HashSet<>();
    public static void main(String[] args) {
        System.out.println("Chat Server started...");
        try (ServerSocket serverSocket = new ServerSocket(1234)) 
        {
            while (true) 
            {
                Socket socket=serverSocket.accept();
                ClientHandler client=new ClientHandler(socket);
                clients.add(client);
                client.start();
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    static void broadcast(String message,ClientHandler excludeClient) 
    {
        for (ClientHandler client:clients) 
        {
            if (client!=excludeClient) 
            {
                client.sendMessage(message);
            }
        }
    }
    static void removeClient(ClientHandler client) 
    {
        clients.remove(client);
    }
}
class ClientHandler extends Thread 
{
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String userName;
    ClientHandler(Socket socket) 
    {
        this.socket=socket;
    }
    public void run() 
    {
        try 
        {
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            out.println("Enter your name:");
            userName=in.readLine();
            System.out.println(userName+" joined the chat");
            ChatServer.broadcast(userName+" joined the chat",this);
            String message;
            while ((message=in.readLine())!=null) 
            {
                ChatServer.broadcast(userName+": "+message,this);
            }
        } 
        catch (IOException e) 
        {
            System.out.println(userName+" disconnected");
        } 
        finally 
        {
            ChatServer.removeClient(this);
            ChatServer.broadcast(userName+" left the chat", this);
            try 
            {
                socket.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
    void sendMessage(String message) 
    {
        out.println(message);
    }
}
