package Gym;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener {
 
    JButton submitButton = new JButton ("Submit");
    JButton clearButton = new JButton ("Cancel");
    JTextField nameTextField = new JTextField (15);
    JTextField passwordTextField = new JTextField (15);
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JLabel pictureLabel = new JLabel();
    ImageIcon imageLocation = new ImageIcon("C:\\Users\\selim\\Desktop\\database project\\project\\images.jpg");
    private char[] password ={'1','2','3','4'};
    JPasswordField pass = new JPasswordField(15);
    
    public Login (){
        
    setLayout(new FlowLayout());
    setSize(300,300);
    setTitle("Login");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  
    pictureLabel.setIcon(imageLocation);
    pictureLabel.setPreferredSize(new Dimension(75,75));
    add(pictureLabel);
    
    
    panel.setPreferredSize(new Dimension (290,30));
    panel.add(new JLabel("Gym Rezervation Login "));
    add(panel,BorderLayout.CENTER);
    add (panel);
    
    
    
    
    add(new Label("Name        : "));
    add(nameTextField);
    add(new Label("Password : "));
    add(pass);
    add(new Label("                                                                                                 "));
   
    add(submitButton);
    add(clearButton);
    
  
    submitButton.addActionListener(this);
    clearButton.addActionListener(this);
    setVisible(true);
    
    }
    
    
    public void actionPerformed (ActionEvent action){
        String name ="";
    if(action.getSource()==submitButton){
        name = this.nameTextField.getText();
     String password = this.passwordTextField.getText();
        
     if (nameTextField.getText().equals("admin") && Arrays.equals(this.pass.getPassword(),this.password) )
            {
     
         
         İnformation form1 = new İnformation();
         
        }else  JOptionPane.showMessageDialog(null, "The username or Password  you entered is  incorrect", "Error", JOptionPane.ERROR_MESSAGE);
     
     dispose();
        
    }else if (action.getSource()==clearButton){
        
         dispose();
    }}
  
   
public static void main(String[] args) {

Login f1 = new Login();

}
    
}
