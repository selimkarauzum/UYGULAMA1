
package Gym;
import java.awt.*;
import java.awt.event.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Delete extends JFrame implements ActionListener {
  JButton Delete = new JButton("Delete");
  JButton search = new JButton("Search");
  JButton Cancel1 = new JButton("Cancel");
  JTextField IdSearch = new JTextField(10);
  JPanel panel1 = new JPanel ();
  JPanel panel2 = new JPanel ();
  JPanel panel3 = new JPanel ();
  JPanel panel4 = new JPanel ();
  JPanel panel5 = new JPanel ();
  JPanel panel6 = new JPanel ();
  JPanel panel7 = new JPanel ();
  JPanel panel8 = new JPanel ();
  JPanel panel9 = new JPanel ();
  JPanel panel10 = new JPanel ();
  JPanel panel11= new JPanel ();
  JPanel panel12 = new JPanel ();
  JPanel panel13= new JPanel ();
  JPanel panel14 = new JPanel ();
  JPanel panel15= new JPanel ();
  JPanel panel16= new JPanel ();
  JPanel panel17 = new JPanel ();
  JPanel panel18 = new JPanel ();
  
  JLabel name=new JLabel("-");
  JLabel surname=new JLabel("-");
  JLabel userıd=new JLabel("-");
  JLabel sex=new JLabel("-");
  JLabel trip=new JLabel("-");
  JLabel year=new JLabel("-");
  JLabel gym=new JLabel("-");
  JLabel start=new JLabel("-");
  JLabel end=new JLabel("-");
  JLabel customer=new JLabel("-");
  JLabel pay=new JLabel("-");
   DefaultTableModel model = new DefaultTableModel();
   
   
   
   
    String username ="hr";
    String password ="HR";
  Delete(){
      
      setLayout(new FlowLayout(FlowLayout.LEFT));
      setSize (470,420);
      setTitle("Delete Resevations");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
     
      panel1.add (new JLabel("Enter a Booking ID to Delete : "));
      panel1.add(IdSearch);
      panel1.add(search);
      panel1.setPreferredSize(new Dimension(500,50));
 
      
      panel3.add(new JLabel("    Name                                   :   "));
      panel3.add(name);
      panel3.setPreferredSize(new Dimension(300,25));
      
      panel4.add(new JLabel("    Surname                            :   "));
      panel4.add(surname);
      panel4.setPreferredSize(new Dimension(300,25));
      
      panel5.add(new JLabel("     Sex                                      :   "));
      panel5.add(sex);
      panel5.setPreferredSize(new Dimension(300,25));
      
      
      panel6.add(new JLabel("      Trip                                      :   "));
      panel6.add(trip);
      panel6.setPreferredSize(new Dimension(300,25));
  
      
      panel7.add(new JLabel("      GyM                                      :   "));
      panel7.add(gym);
      panel7.setPreferredSize(new Dimension(300,25));
      
      panel8.add(new JLabel("     Start Date                           :   "));
      panel8.add(start);
      panel8.setPreferredSize(new Dimension(300,25));
      
      
      panel9.add(new JLabel("     End Date                             :   "));
      panel9.add(end);
      panel9.setPreferredSize(new Dimension(300,25));
      
      
      panel10.add(new JLabel("  Type of the Custemer        :   "));
      panel10.add(customer);
      panel10.setPreferredSize(new Dimension(300,25));
      
      panel11.add(new JLabel("  Payment options                :   "));
      panel11.add(pay);
      panel11.setPreferredSize(new Dimension(300,25)); 
      
 
      panel12.add(Delete);
      panel12.add(Cancel1);
      panel12.setPreferredSize(new Dimension(350,100));
      add(panel1);
      add(panel2);
      add(panel5);
      add(panel3);
      add(panel4);
      add(panel5);
      add(panel6);
      add(panel7);
      add(panel8);
      add(panel9);
      add(panel10);
      add(panel11);
      add(panel12);
      
      
      search.addActionListener(this);
      Delete.addActionListener(this);
      Cancel1.addActionListener(this);
      setVisible(true);
  
  }
  
  
  public void actionPerformed(ActionEvent a){
      boolean found =false;
      
  
     
      

       
      if(a.getSource()==search){
              String id= this.IdSearch.getText();
         int  n =Integer.parseInt(id);
        for(int i=0;i<Gym.data.size();i++){
        if(Gym.data.get(i).getUserId()==n){
            this.name.setText(Gym.data.get(i).getName());
            this.surname.setText(Gym.data.get(i).getSurname());
            this.sex.setText(Gym.data.get(i).getSex());
            this.trip.setText(Gym.data.get(i).gettrip());
            this.gym.setText(Gym.data.get(i).getGym());
            this.start.setText(Gym.data.get(i).getStart());
            this.end.setText(Gym.data.get(i).getEnd());
            this.customer.setText(Gym.data.get(i).getCustomer());
            this.pay.setText(Gym.data.get(i).getPay());    
            found=true;
            break;
        }
        }
        if(found==false){
        JOptionPane.showMessageDialog(IdSearch, "Booking ID Does Not exist,Please Enter another Booking ID.", "Error", JOptionPane.ERROR_MESSAGE);
        this.IdSearch.requestFocus();
        }
        }else if (a.getSource()==Delete){
            
        String id= this.IdSearch.getText();
         int  n =Integer.parseInt(id);
        for(int i=0;i<Gym.data.size();i++){
        if(Gym.data.get(i).getUserId()==n){
            
         try {
                String drivername = ("oracle.jdbc.OracleDriver");
                Class.forName(drivername);
                Connection con = DriverManager.getConnection( "jdbc:oracle:thin:@selim-karauzum:1521:XE" , username ,password );
                       
			System.out.println("Connection is succesfull");
                        
                        int newId = Gym.data.size()+1;
                        String procedure = "{call delete_membership(?)";
                        CallableStatement callableStatement = con.prepareCall(procedure);
                        callableStatement.setInt(1,Integer.parseInt(IdSearch.getText()));
			callableStatement.execute();
                        
                         String procedure1 = "{call delete_customer(?)";
                        CallableStatement callableStatement1 = con.prepareCall(procedure1);
                        callableStatement1.setInt(1,Integer.parseInt(IdSearch.getText()));
			callableStatement1.execute();
                        
            JOptionPane.showMessageDialog(IdSearch,"Are you sure delete İnformation");
                        
                        
                          } catch (Exception exception) {
                System.out.println("There was an error" + exception.getMessage());
                
            }
            
             İnformation d = new İnformation();
             dispose();
            found=true;
            break;
             
        }
        }
        if(found==false){
        JOptionPane.showMessageDialog(IdSearch, "Booking ID Does Not exist,Please Enter another Booking ID.", "Error", JOptionPane.ERROR_MESSAGE);
        this.IdSearch.requestFocus();
        }
        }else if (a.getSource()==Cancel1){
         İnformation d = new İnformation();
             dispose();
        }
      
      
  }
    public static void main(String[] args) {
        
        Delete mypbject = new Delete();
        
    }
    
}