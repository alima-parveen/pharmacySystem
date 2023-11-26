
package pharmacysystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import javax.swing.border.LineBorder;
  

public class PatientRegistration extends JFrame implements ActionListener{
    
    JLabel l1,l3,l4,l5,l6,l7,l8,l9,l11,l13,l14,l15;
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2;
    JButton b;
    JDateChooser dateChooser;
    
    
    Random ran = new Random();
    long first4 = (ran.nextLong() % 90000L) + 10000L;
    String first = "" + Math.abs(first4);
    
    PatientRegistration(){
        
        setTitle("NEW PATIENT RECORD");       
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/registration.png"));
        Image i2 = i1.getImage().getScaledInstance(50, 55, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(80, 30, 100, 100);
        add(l11);
        
        l1 = new JLabel("FORM NO. "+first);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        l1.setForeground(new Color(139, 69, 19));
        
        
        l3 = new JLabel("Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l4 = new JLabel("Age:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l5 = new JLabel("Date of Birth:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l6 = new JLabel("Gender:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l7 = new JLabel("Email Address:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l8 = new JLabel("Contact No :");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l9 = new JLabel("Address:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
               
        l13 = new JLabel("Date");
        l13.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l14 = new JLabel("Month");
        l14.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l15 = new JLabel("Year");
        l15.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b = new JButton("SUBMIT");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        
        dateChooser = new JDateChooser();
	dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	dateChooser.setForeground(new Color(105, 105, 105));
	dateChooser.setBounds(137, 337, 200, 29);
	add(dateChooser);
        
        setLayout(null);
        l1.setBounds(200,50,600,45);
        add(l1);
        
        l3.setBounds(100,140,100,35);
        add(l3);
        
        t1.setBounds(300,140,400,35);
        add(t1);
        
        l4.setBounds(100,190,200,35);
        add(l4);
        
        t2.setBounds(300,190,400,35);
        add(t2);
        
        l5.setBounds(100,240,200,35);
        add(l5);
        
        dateChooser.setBounds(300, 240, 400, 35);
        
        l6.setBounds(100,290,200,35);
        add(l6);
        
        r1.setBounds(300,290,90,35);
        r1.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
        add(r1);
        
        r2.setBounds(450,290,120,35);
        r2.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
        add(r2);
        
        l7.setBounds(100,340,200,35);
        add(l7);
        
        t3.setBounds(300,340,400,35);
        add(t3);
             
        l8.setBounds(100,400,200,35);
        add(l8);
        
        t4.setBounds(300,400,400,35);
        add(t4);
        
        l9.setBounds(100,440,200,35);
        add(l9);
        
        t5.setBounds(300,440,400,60);
        add(t5);
        
      //submit button
        b.setBounds(620,660,100,30);
        add(b);
        
        b.addActionListener(this); 
        
        getContentPane().setBackground(new Color(252, 228, 236));
        setSize(850,800);
        setLocation(400,20);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String patient_id = first;
        String name = t1.getText();
        String age = t2.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if(r1.isSelected()){ 
            gender = "Male";
        }else if(r2.isSelected()){ 
            gender = "Female";
        }
            
        String email = t3.getText();
        String contact = t4.getText();          
        String address = t5.getText();
               
    }
    
    public static void main(String[] args){
        new PatientRegistration().setVisible(true);
    }
    
}
