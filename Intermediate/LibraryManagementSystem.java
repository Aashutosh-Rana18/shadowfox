import java.sql.*;
import java.util.Scanner;
public class LibraryManagementSystem 
{
    static final String DB_URL="jdbc:sqlite:library.db";
    public static void main(String[] args) throws Exception 
    {
        createTable();
        Scanner sc=new Scanner(System.in);
        while (true) 
        {
            System.out.println("\n1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int ch=sc.nextInt();
            sc.nextLine();
            if (ch==1) 
            {
                System.out.print("Book Name: ");
                String name=sc.nextLine();
                addBook(name);
            } 
            else if (ch==2) 
            {
                viewBooks();
            } 
            else 
            {
                break;
            }
        }
    }

    static void createTable() throws Exception 
    {
        Connection con=DriverManager.getConnection(DB_URL);
        Statement st=con.createStatement();
        st.execute("CREATE TABLE IF NOT EXISTS books (id INTEGER PRIMARY KEY, name TEXT)");
        con.close();
    }
    static void addBook(String name) throws Exception 
    {
        Connection con=DriverManager.getConnection(DB_URL);
        PreparedStatement ps=con.prepareStatement("INSERT INTO books(name) VALUES(?)");
        ps.setString(1,name);
        ps.executeUpdate();
        con.close();
    }
    static void viewBooks() throws Exception 
    {
        Connection con=DriverManager.getConnection(DB_URL);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM books");
        while (rs.next()) 
        {
            System.out.println(rs.getInt("id")+" - "+rs.getString("name"));
        }
        con.close();
    }
}
