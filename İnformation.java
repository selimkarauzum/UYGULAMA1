package Gym;
import static Gym.Gym.data;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.lang.ClassNotFoundException;
import java.sql.*;
public class İnformation extends JFrame implements ActionListener{

    JPanel panel = new JPanel();
    JButton delete = new JButton("Delete & Search ");
    JButton exit = new JButton("Exit ");
    JButton book  = new JButton("Add A Gym");

    DefaultTableModel model = new DefaultTableModel();
   
    JTable table =new JTable(model);
    JScrollPane scroolPane = new JScrollPane(table);
    
    String username ="hr";
    String password ="HR";
    
    public İnformation()
    {
                add(new JLabel("Gym Rezervation System  User İnformation  :                                                     "));
                
                model.addColumn("customer_id");
		model.addColumn("last_name");
		model.addColumn("first_name");
                model.addColumn("trip_id");
		model.addColumn("gym_id");
                model.addColumn("");
                model.addColumn("start_date");
                model.addColumn("end_date");
		model.addColumn("Payment");
                model.addColumn("");
		table = new JTable(model);
		
		JScrollPane pane = new JScrollPane(table);
		add(pane);
                add(new JLabel("                          "));
                
	panel.add(delete);
        panel.add(book);
        panel.add(exit);
        
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(500,550);
        setTitle("Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        /*
        table.setPreferredScrollableViewportSize(new Dimension(800,100));
        panel.add(table.getTableHeader());
        panel.add(scroolPane);
        getContentPane().add(scroolPane,BorderLayout.CENTER);
        table.setCellSelectionEnabled(true);
        */
        
        add(panel);
        
        delete.addActionListener(this);
        book.addActionListener(this);
        exit.addActionListener(this);
        
        
        this.filltable();
        this.table();
    
        
        this.setVisible(true);
        
    }
    private void table(){
         

        for(int i=0;i<Gym.data.size();i++){
        Object data [] ={
            
            Gym.data.get(i).getUserId(),    
            Gym.data.get(i).getName(),
            Gym.data.get(i).getSurname(),
            Gym.data.get(i).getSex(),
            Gym.data.get(i).gettrip(),
            Gym.data.get(i).getGym(),
            Gym.data.get(i).getStart(),
            Gym.data.get(i).getEnd(),
            Gym.data.get(i).getCustomer(),
            Gym.data.get(i).getPay()   
        };
       
        this.model.addRow(data);
        }
        this.model.fireTableDataChanged();
    }
    
    public void actionPerformed (ActionEvent action){

     if(action.getSource()==delete){
         Delete d = new Delete();
         dispose();  }
     else if(action.getSource()==book){
       Add a = new Add();
       dispose(); }
     else if(action.getSource()==exit){
     dispose();
     }
     }

public static void main(String[] args) {

İnformation f1 = new İnformation();
f1.filltable();
 
} 

public void filltable()
	{
		try 
		{
                        String drivername = ("oracle.jdbc.OracleDriver");
			Class.forName(drivername);
                 
			Connection con = DriverManager.getConnection
			( "jdbc:oracle:thin:@selim-karauzum:1521:XE" , username ,password );
                        
			System.out.println("Connection is succesfull");
                        
			String sql = "Select * from hr.membership join hr.customer using (customer_id) ";
                        
			java.sql.Statement statement = con.createStatement();
			ResultSet resultset = statement.executeQuery(sql);
			Gym.data.clear();
			while(resultset.next())
			{       String first_name=resultset.getString("first_name");
				String last_name=resultset.getString("last_name");
				String membership=resultset.getString("membership_id");
				String trip_id=resultset.getString("trip_id");
                                String start_date=resultset.getString("start_date");
				String end_date=resultset.getString("end_date");
				int customer_id= Integer.parseInt(resultset.getString("customer_id"));
				String gym_id=resultset.getString("gym_id");
                                String payment=resultset.getString("payment");
                        Gym.data.add(new Customer(customer_id,first_name,last_name,membership, trip_id, gym_id, start_date, end_date, payment, ""));	
                        }
			
			/*String procedure = "{call inc_salary(?,?)}";
			CallableStatement callableStatement = con.prepareCall(procedure);
			callableStatement.setInt(1, 100);
			callableStatement.setInt(2, 1);
			callableStatement.execute();*/
		} 
		catch (Exception exception){
			System.out.println("There was an error" + exception.getMessage());
			
		}
	}
}