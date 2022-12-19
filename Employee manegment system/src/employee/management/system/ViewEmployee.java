
package employee.manegment.system;
import javax.swing.*; 
import java.awt.*; 
import java.sql.*; 
import net.proteanit.sql.DbUtils; 
import java.awt.event.*;
/**
 *
 * @author Muthal18
 */
public class ViewEmployee  extends JFrame implements ActionListener{  
    JTable table; 
    Choice cemployeeid; 
    JButton  search,print,update,back;
    ViewEmployee(){  
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); 
         
        JLabel searchlbl=new JLabel("Search by Employee id"); 
        searchlbl.setBounds(20,20,150,20); 
        add(searchlbl); 
        
        cemployeeid=new Choice(); 
        cemployeeid.setBounds(180,20,150,20); 
        add(cemployeeid); 
        try {  
            Conn c=new Conn(); 
            ResultSet rs=c.s.executeQuery("select * from Employee"); 
           while(rs.next()){ 
               cemployeeid.add(rs.getString("empid"));
           }
        } catch(Exception e) { 
            e.printStackTrace();
        }
        
        table =new JTable(); 
        try {  
            Conn c=new Conn(); 
            ResultSet rs=c.s.executeQuery("select * from Employee"); 
            table.setModel(DbUtils.resultSetToTableModel(rs));  
        } catch(Exception e) { 
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);  
        jsp.setBounds(0,100,900,600); 
        add(jsp);
         
        search =new JButton("Search"); 
        search.setBounds(20,70,80,20); 
        search.addActionListener(this); 
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        add(search); 
        
        print =new JButton("print"); 
        print.setBounds(120,70,80,20); 
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this); 
        add(print);  
        
        update =new JButton("update"); 
        update.setBounds(220,70,80,20); 
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);   
        
        back =new JButton("back"); 
        back.setBounds(320,70,80,20);  
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
       
    }
     @Override
    public void actionPerformed(ActionEvent ae) 
    { 
        if(ae.getSource() == search) { 
           
           String query = "select * from employee where empId = '"+cemployeeid.getSelectedItem()+"'";  
           try { 
               Conn c= new Conn(); 
               ResultSet rs=c.s.executeQuery(query); 
               table.setModel(DbUtils.resultSetToTableModel(rs)); 
               
           }catch(Exception e){ 
               e.printStackTrace();
           }
            
        } else if(ae.getSource()==print){ 
         
           try{ 
               table.print();
           } catch(Exception e){ 
               e.printStackTrace();
           }
       } else if(ae.getSource()==update){ 
            setVisible(false); 
           new UpdateEmployee(cemployeeid.getSelectedItem());
       }else { 
           setVisible(false); 
          new Home();
       }
    } 
        
    public static void main(String args[]) { 
        new ViewEmployee();
    }

   
} /*
 public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    } */