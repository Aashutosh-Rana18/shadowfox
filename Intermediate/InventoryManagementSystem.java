import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
class Item 
{
    String name;
    int quantity;
    Item(String name,int quantity) 
    {
        this.name=name;
        this.quantity=quantity;
    }
}
public class InventoryManagementSystem extends JFrame 
{
    ArrayList<Item> items=new ArrayList<>();
    JTextField nameField,quantityField;
    JTextArea displayArea;
    public InventoryManagementSystem() 
    {
        setTitle("Inventory Management System");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        nameField=new JTextField(10);
        quantityField=new JTextField(10);
        displayArea=new JTextArea(10,30);
        displayArea.setEditable(false);
        JButton addBtn=new JButton("Add");
        JButton updateBtn=new JButton("Update");
        JButton deleteBtn=new JButton("Delete");
        JButton viewBtn=new JButton("View");
        JPanel panel=new JPanel();
        panel.add(new JLabel("Item Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);
        panel.add(addBtn);
        panel.add(updateBtn);
        panel.add(deleteBtn);
        panel.add(viewBtn);
        add(panel,BorderLayout.NORTH);
        add(new JScrollPane(displayArea),BorderLayout.CENTER);
        addBtn.addActionListener(e->addItem());
        updateBtn.addActionListener(e->updateItem());
        deleteBtn.addActionListener(e->deleteItem());
        viewBtn.addActionListener(e->viewItems());
    }
    void addItem() 
    {
        items.add(new Item(nameField.getText(),
        Integer.parseInt(quantityField.getText())));
        clearFields();
    }
    void updateItem() 
    {
        for (Item i:items) 
        {
            if (i.name.equalsIgnoreCase(nameField.getText())) 
            {
                i.quantity=Integer.parseInt(quantityField.getText());
                break;
            }
        }
        clearFields();
    }
    void deleteItem() 
    {
        items.removeIf(i->i.name.equalsIgnoreCase(nameField.getText()));
        clearFields();
    }
    void viewItems() 
    {
        displayArea.setText("");
        for (Item i:items) 
        {
            displayArea.append(i.name + " : "+i.quantity+"\n");
        }
    }
    void clearFields() 
    {
        nameField.setText("");
        quantityField.setText("");
    }
    public static void main(String[] args) 
    {
        new InventoryManagementSystem().setVisible(true);
    }
}
