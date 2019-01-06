package Gym;
import static Gym.Gym.data;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.GroupLayout.Group;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
public class Add extends JFrame implements ActionListener {
    
    JTextField name=new JTextField(15);
    JTextField surname=new JTextField(15);
    JTextField userId=new JTextField(15);
    JButton add=new JButton("Add");
    JButton clear=new JButton("Clear");
    JButton goBack=new JButton("Go Back");
    JRadioButton male=new JRadioButton("male");
    JRadioButton female=new JRadioButton("female");
    JRadioButton dailyRadio=new JRadioButton("Daily");
    JRadioButton montlyRadio=new JRadioButton("Montly");
    JRadioButton yearlyRadio=new JRadioButton("Yearly");
    ButtonGroup sexgroup=new ButtonGroup();
    ButtonGroup trip=new ButtonGroup();
  
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4=new JPanel();
    JPanel panel5=new JPanel();
    JPanel panel6=new JPanel();
    JPanel panel7=new JPanel();
    JPanel panel8=new JPanel();
    JPanel panel9=new JPanel();
    JPanel panel10=new JPanel();
    JPanel panel11=new JPanel();
   
   
   
    String username ="hr";
    String password ="HR";
   
   String[] GYMvalues = { "GYM","swimming","gold(GYM+swimming)"};
    JComboBox GYM=new JComboBox(GYMvalues); 
  
     String[] agevalues = {
      "14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
    JComboBox age=new JComboBox(agevalues); 
    
     String[] dayvalues = {
     "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
     "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
    JComboBox day=new JComboBox(dayvalues);  
    
    String[] montlyvalues={"January","February","March","April","May",
     "June","July","August","September","October","November","December"};
    JComboBox montly=new JComboBox(montlyvalues); 
    
    String[] yearvalues={"2017","2018","2019"};
    JComboBox year=new JComboBox(yearvalues); 
    
    String[] dayendvalues = {
     "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
     "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    JComboBox dayend=new JComboBox(dayendvalues); 
    
    String[] montlyendvalues={"January","February","March","April","May",
     "June","July","August","September","October","November","December"};
    JComboBox montlyend=new JComboBox(montlyendvalues); 
    
    String[] yearendvalues={"2017","2018","2019"};
    JComboBox yearend=new JComboBox(yearendvalues); 
    
     String[] customervalues={"child","adult","student"};
    JComboBox customer=new JComboBox(customervalues);
    
    JLabel pay =new JLabel(); 
    
    private String gymC;
    private String SwimmingC;
    private String GoldC;
   
   

 
    Add(){
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setTitle("GYM ADD A NEW ITEMS");
        setSize(300,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        sexgroup.add(male);
        sexgroup.add(female);
        trip.add(dailyRadio);
        trip.add(montlyRadio);
        trip.add(yearlyRadio);
        
        
        
        panel1.add(new JLabel("Name        : "));
        panel1.add(name);
        panel1.setPreferredSize(new Dimension (254,30));
        add(panel1,BorderLayout.NORTH);
        add(panel1);
        
        panel2.add(new JLabel("Surname   :")); 
        panel2.add(surname);
        panel2.setPreferredSize(new Dimension (254,30));
        add(panel2,BorderLayout.NORTH);
        add(panel2);
       
        
        panel4.add(new JLabel("Sex      :           "));
        panel4.add(male);
        panel4.add(female);
        panel4.setPreferredSize(new Dimension (254,40));
        add(panel4,BorderLayout.CENTER);
        add(panel4);    
        panel5.add(new JLabel("Trip : "));
        panel5.add(dailyRadio);
        panel5.add(montlyRadio);
        panel5.add(yearlyRadio);
        panel5.setPreferredSize(new Dimension (254,30));
        add(panel5,BorderLayout.CENTER);
        add(panel5);
        panel6.add(new JLabel("GYM  : "));
        panel6.add(GYM);
        panel6.setPreferredSize(new Dimension (254,30));
        add(panel6,BorderLayout.CENTER);
        add(panel6);
        
        panel7.add(new JLabel("Start :"));
        panel7.add(day);
        panel7.add(montly);
        panel7.add(year);
        panel7.setPreferredSize(new Dimension (254,40));
        add(panel7,BorderLayout.CENTER);
        add(panel7);
        
        panel8.add(new JLabel("End :"));
        panel8.add(dayend);
        panel8.add(montlyend);
        panel8.add(yearend);
        panel8.setPreferredSize(new Dimension (254,40));
        add(panel8,BorderLayout.CENTER);
        add(panel8);
        
        panel9.add(new JLabel("Customer :"));
        panel9.add(customer);
        panel9.setPreferredSize(new Dimension (254,50));
        add(panel9,BorderLayout.CENTER);
        add(panel9);
        
      
        
        panel11.add(add);
        panel11.add (clear);
        panel11.add (goBack);
        panel11.setPreferredSize(new Dimension (254,50));
        add(panel11,BorderLayout.SOUTH);
       DefaultComboBoxModel model = new DefaultComboBoxModel(customervalues);
        customer.setModel(model);
       
        add.addActionListener(this);
        clear.addActionListener(this);
        goBack.addActionListener(this);
       
        setVisible(true);
        
    }
    
   public void actionPerformed(ActionEvent e) {
        String fname ="";
        String surname ="";
        String value="";
        String value1="";
        String gym="";
        String Customer="";
        //String Pay="";
        String day1="";
        String month1="";
        String year1="";
        String day2="";
        String month2="";
        String year2="";
        if (male.isSelected())
        value = "male";
        else if (female.isSelected())
        value = "female !";
        
         if (dailyRadio.isSelected())
        value1 = "daily";
        else if (montlyRadio.isSelected())
        value1 = "monthly !";
        else if (yearlyRadio.isSelected())
        value1 = "yearly !";
         
        if (GYM.getSelectedItem() == "GYM")
        {gym = "GYM";}
        else if (GYM.getSelectedItem() == "swimming")
        {gym = "swimming";}
        else if (GYM.getSelectedItem() == "gold(GYM+swimming)")
        {gym = "gold(GYM+swimming)";}   
        
        if (customer.getSelectedItem() == "child")
        {Customer = "child";}
        else if (customer.getSelectedItem() == "adult")
        {Customer = "adult";}
        else if (customer.getSelectedItem() == "student")
        {Customer = "student";}   
              
        if (day.getSelectedItem() == "1")
        {day1 = "1";}
        else if (day.getSelectedItem() == "2")
        {day1 = "2";}
        else if (day.getSelectedItem() == "3")
        {day1 = "3";} 
        else if (day.getSelectedItem() == "4")
        {day1 = "4";}
        else if (day.getSelectedItem() == "5")
        {day1 = "5";} 
        else if (day.getSelectedItem() == "6")
        {day1 = "6";}
        else if (day.getSelectedItem() == "7")
        {day1 = "7";} 
        else if (day.getSelectedItem() == "8")
        {day1 = "8";}
        else if (day.getSelectedItem() == "9")
        {day1 = "9";} 
         else if (day.getSelectedItem() == "7")
        {day1 = "7";} 
        else if (day.getSelectedItem() == "8")
        {day1 = "8";}
        else if (day.getSelectedItem() == "9")
        {day1 = "9";} 
         else if (day.getSelectedItem() == "10")
        {day1 = "10";} 
        else if (day.getSelectedItem() == "11")
        {day1 = "11";}
        else if (day.getSelectedItem() == "12")
        {day1 = "12";} 
         else if (day.getSelectedItem() == "13")
        {day1 = "13";} 
        else if (day.getSelectedItem() == "14")
        {day1 = "14";}
        else if (day.getSelectedItem() == "15")
        {day1 = "15";} 
         else if (day.getSelectedItem() == "16")
        {day1 = "16";} 
        else if (day.getSelectedItem() == "17")
        {day1 = "17";}
        else if (day.getSelectedItem() == "18")
        {day1 = "18";} 
        else if (day.getSelectedItem() == "19")
        {day1 = "19";} 
         else if (day.getSelectedItem() == "20")
        {day1 = "20";} 
        else if (day.getSelectedItem() == "21")
        {day1 = "21";}
        else if (day.getSelectedItem() == "22")
        {day1 = "22";} 
        else if (day.getSelectedItem() == "23")
        {day1 = "23";} 
         else if (day.getSelectedItem() == "24")
        {day1 = "24";} 
        else if (day.getSelectedItem() == "25")
        {day1 = "25";}
        else if (day.getSelectedItem() == "26")
        {day1 = "26";} 
        else if (day.getSelectedItem() == "27")
        {day1 = "27";} 
         else if (day.getSelectedItem() == "28")
        {day1 = "28";} 
        else if (day.getSelectedItem() == "29")
        {day1 = "29";}
        else if (day.getSelectedItem() == "30")
        {day1 = "30";} 
        else if (day.getSelectedItem() == "31")
        {day1 = "31";} 
         
        
        if (montly.getSelectedItem() == "January")
        {month1 = "January";}
        else if (montly.getSelectedItem() == "February")
        {month1 = "February";}
        else if (montly.getSelectedItem() == "March")
        {month1 = "March";} 
        else if (montly.getSelectedItem() == "April")
        {month1 = "April";}
        else if (montly.getSelectedItem() == "May")
        {month1 = "May";}
        else if (montly.getSelectedItem() == "June")
        {month1 = "June";} 
        else if (montly.getSelectedItem() == "July")
        {month1 = "July";}
        else if (montly.getSelectedItem() == "August")
        {month1 = "August";}
        else if (montly.getSelectedItem() == "September")
        {month1 = "September";} 
        else if (montly.getSelectedItem() == "October")
        {month1 = "October";}
        else if (montly.getSelectedItem() == "November")
        {month1 = "November";}
        else if (montly.getSelectedItem() == "December")
        {month1 = "December";}
     
        
         if (year.getSelectedItem() == "2017")
        {year1 = "2017";}
        else if (year.getSelectedItem() == "2018")
        {year1 = "2018";}
        else if (year.getSelectedItem() == "2019")
        {year1 = "2019";} 
      
        if (dayend.getSelectedItem() == "1")
        {day2 = "1";}
        else if (dayend.getSelectedItem() == "2")
        {day2 = "2";}
        else if (dayend.getSelectedItem() == "3")
        {day2 = "3";} 
        else if (dayend.getSelectedItem() == "4")
        {day2 = "4";}
        else if (dayend.getSelectedItem() == "5")
        {day2 = "5";} 
        else if (dayend.getSelectedItem() == "6")
        {day2 = "6";}
        else if (dayend.getSelectedItem() == "7")
        {day2 = "7";} 
        else if (dayend.getSelectedItem() == "8")
        {day2 = "8";}
        else if (dayend.getSelectedItem() == "9")
        {day2 = "9";} 
         else if (dayend.getSelectedItem() == "7")
        {day2 = "7";} 
        else if (dayend.getSelectedItem() == "8")
        {day2 = "8";}
        else if (dayend.getSelectedItem() == "9")
        {day2 = "9";} 
         else if (dayend.getSelectedItem() == "10")
        {day2 = "10";} 
        else if (dayend.getSelectedItem() == "11")
        {day2 = "11";}
        else if (dayend.getSelectedItem() == "12")
        {day2 = "12";} 
         else if (dayend.getSelectedItem() == "13")
        {day2 = "13";} 
        else if (dayend.getSelectedItem() == "14")
        {day2 = "14";}
        else if (dayend.getSelectedItem() == "15")
        {day2 = "15";} 
         else if (dayend.getSelectedItem() == "16")
        {day2 = "16";} 
        else if (dayend.getSelectedItem() == "17")
        {day2 = "17";}
        else if (dayend.getSelectedItem() == "18")
        {day2 = "18";} 
        else if (dayend.getSelectedItem() == "19")
        {day2 = "19";} 
         else if (dayend.getSelectedItem() == "20")
        {day2 = "20";} 
        else if (dayend.getSelectedItem() == "21")
        {day2 = "21";}
        else if (dayend.getSelectedItem() == "22")
        {day2 = "22";} 
        else if (dayend.getSelectedItem() == "23")
        {day2 = "23";} 
         else if (dayend.getSelectedItem() == "24")
        {day2 = "24";} 
        else if (dayend.getSelectedItem() == "25")
        {day2 = "25";}
        else if (dayend.getSelectedItem() == "26")
        {day2 = "26";} 
        else if (dayend.getSelectedItem() == "27")
        {day2 = "27";} 
         else if (dayend.getSelectedItem() == "28")
        {day2 = "28";} 
        else if (dayend.getSelectedItem() == "29")
        {day2 = "29";}
        else if (dayend.getSelectedItem() == "30")
        {day2 = "30";} 
        else if (dayend.getSelectedItem() == "31")
        {day2 = "31";} 
         
        
        
        if (montlyend.getSelectedItem() == "January")
        {month2 = "January";}
        else if (montlyend.getSelectedItem() == "February")
        {month2 = "February";}
        else if (montlyend.getSelectedItem() == "March")
        {month2 = "March";} 
        else if (montlyend.getSelectedItem() == "April")
        {month2 = "April";}
        else if (montlyend.getSelectedItem() == "May")
        {month2 = "May";}
        else if (montlyend.getSelectedItem() == "June")
        {month2 = "June";} 
        else if (montlyend.getSelectedItem() == "July")
        {month2 = "July";}
        else if (montlyend.getSelectedItem() == "August")
        {month2 = "August";}
        else if (montlyend.getSelectedItem() == "September")
        {month2 = "September";} 
        else if (montlyend.getSelectedItem() == "October")
        {month2 = "October";}
        else if (montlyend.getSelectedItem() == "November")
        {month2 = "November";}
        else if (montlyend.getSelectedItem() == "December")
        {month2 = "December";}
     
        
         if (yearend.getSelectedItem() == "2017")
        {year2 = "2017";}
        else if (yearend.getSelectedItem() == "2018")
        {year2 = "2018";}
        else if (yearend.getSelectedItem() == "2019")
        {year2 = "2019";} 
          
        
        
         Calculate c = new Calculate(gymC,SwimmingC,GoldC);
        if (GYM.getSelectedItem() == "GYM" && customer.getSelectedItem() == "child"){
            gymC=(String) this.GYM.getSelectedItem();
           gymC=(String) this.customer.getSelectedItem();
        this.pay.setText(""+c.GymResult());}
        
       if  (GYM.getSelectedItem() == "GYM" && customer.getSelectedItem() == "adult"){
            gymC=(String) this.GYM.getSelectedItem();
            gymC=(String) this.customer.getSelectedItem();
        this.pay.setText(""+c.GymResultA());}
        
       if (GYM.getSelectedItem() == "GYM" && customer.getSelectedItem() == "student"){
            gymC=(String) this.GYM.getSelectedItem();
            gymC=(String) this.customer.getSelectedItem();
        this.pay.setText(""+c.GymResultS());}
        
        if (GYM.getSelectedItem() == "swimming" && customer.getSelectedItem() == "child"){
            SwimmingC=(String) this.GYM.getSelectedItem();
        SwimmingC=(String) this.customer.getSelectedItem();
        this.pay.setText(""+c.SwimmingResult());}
        
        if (GYM.getSelectedItem() == "swimming" && customer.getSelectedItem() == "adult") {
            SwimmingC=(String) this.GYM.getSelectedItem();
        SwimmingC=(String) this.customer.getSelectedItem(); 
       this.pay.setText(""+c.SwimmingResultA());}
        
        if (GYM.getSelectedItem() == "swimming" && customer.getSelectedItem() == "student"){
            SwimmingC=(String) this.GYM.getSelectedItem();
         SwimmingC=(String) this.customer.getSelectedItem();
        this.pay.setText(""+c.SwimmingResultS());}
        
        if (GYM.getSelectedItem() == "gold(GYM+swimming)" && customer.getSelectedItem() == "child") {
            GoldC=(String) this.GYM.getSelectedItem();
         GoldC=(String) this.customer.getSelectedItem();
       this.pay.setText(""+c.GoldResult());}
        
         if (GYM.getSelectedItem() == "gold(GYM+swimming)" && customer.getSelectedItem() == "adult") {
            GoldC=(String) this.GYM.getSelectedItem();
         GoldC=(String) this.customer.getSelectedItem();
       this.pay.setText(""+c.GoldResultA());}
        
        if (GYM.getSelectedItem() == "gold(GYM+swimming)" && customer.getSelectedItem() == "student"){
            GoldC=(String) this.GYM.getSelectedItem();
         GoldC=(String) this.customer.getSelectedItem();
        this.pay.setText(""+c.GoldResultS());}
 
    if(e.getSource()==add){
        
       
         
            try {
                String drivername = ("oracle.jdbc.OracleDriver");
                Class.forName(drivername);
                Connection con = DriverManager.getConnection( "jdbc:oracle:thin:@selim-karauzum:1521:XE" , username ,password );
                       
			System.out.println("Connection is succesfull");
                        
                        String dday= day1+month1+year1;
                        String dyear= day1+month2+year2;
                        int newId = Gym.data.size()+1;
                        String procedure1 = "{call CUSTOMER_CREATE(?,?,?)}";
                        CallableStatement callableStatement1 = con.prepareCall(procedure1);
                        callableStatement1.setInt(1,newId );
			callableStatement1.setString(2, this.name.getText());
			callableStatement1.setString(3, this.surname.getText());
			callableStatement1.execute();
                        
                        
                        String procedure = "{call INSERT_MEMBERSHIP(?,?,?,?,?)}";
                        CallableStatement callableStatement = con.prepareCall(procedure);
                        callableStatement.setInt(1,newId);
			callableStatement.setString(2,dday);
			callableStatement.setString(3,dyear );
                        callableStatement.setString(4,this.pay.getText() );
                        callableStatement.setInt(5, newId);
			callableStatement.execute();
                      
                      
                        /*String procedure2 = "{call INSERT_trip(?,?)}";
                        CallableStatement callableStatement2 = con.prepareCall(procedure2);
                        callableStatement2.setInt(1,Gym.counter);
			callableStatement2.setString(2,value1);
			callableStatement2.execute();
                        
                       String procedure3 = "{call INSERT_type(?,?)}";
                       CallableStatement callableStatement3 = con.prepareCall(procedure3);
                       callableStatement3.setInt(1,Gym.counter);
                       callableStatement3.setString(2, gym);
                       callableStatement3.execute();
                        */
                        
            } catch (Exception exception) {
                //Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, exception);
                System.out.println("There was an error" + exception.getMessage());
            }
                 
             	
        //JOptionPane.showMessageDialog(null,this.montlyend.getSelectedItem().toString());
        
      /**  
    Gym.data.add(new Customer(
            
            Gym.counter,
            this.name.getText(),
            this.surname.getText(),
            value,
            value1,
            gym,
            day1+"/"+month1+"/"+year1,
            day2+"/"+month2+"/"+year2,
            Customer,
            this.pay.getText()+"$"   
            
    ));    
   
      Gym.counter++;*/
      İnformation i = new İnformation();     
      dispose();
      
    }else if(e.getSource()==clear){      
        this.name.setText("");
        this.surname.setText("");
        this.userId.setText("");
        this.sexgroup.clearSelection();
        this.trip.clearSelection();
        this.GYM.setSelectedIndex(0);
        this.day.setSelectedIndex(0);
        this.montly.setSelectedIndex(0);
        this.year.setSelectedIndex(0);
        this.dayend.setSelectedIndex(0);
        this.montlyend.setSelectedIndex(0);
        this.yearend.setSelectedIndex(0);
        this.customer.setSelectedIndex(0);
        //this.pay.setSelectedIndex(0);
    }else if(e.getSource()==goBack){
        
        İnformation i = new İnformation();
        dispose();
    }}
   public static void main(String[] args) {

       Add myobject=new Add();
       
    }    
}
