
package pharmacysystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import java.util.*;
  

public class PatientUpdate extends JFrame implements ActionListener{
    
    JLabel l1,l3,l4,l5,l6,l7,l8,l9,l13,l14,l15,heading, t1, t2, ldateShow, dateChooser;
    JTextField t3,t4,t5;
    JLabel r1,r2;
    JButton submit, cancel;
    Choice patientid;
       
    PatientUpdate(){
        
        getContentPane().setBackground(new Color(252, 228, 236));
        setSize(850,800);
        setLocation(400,20);
        
        setTitle("NEW PATIENT RECORD");       
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/registration.png"));
        Image i2 = i1.getImage().getScaledInstance(50, 55, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(80, 30, 100, 100);
        add(l11);
       

        l1 = new JLabel("Patient ID ");
        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        l1.setForeground(new Color(139, 69, 19));
        
        heading = new JLabel ("Search by Patient_Id ");
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        heading.setForeground(new Color(139, 69, 19));
        heading.setBounds(200,50,250,40);
        add(heading);
        
        patientid = new Choice();
        patientid.setBounds(450,60,150,40);
        add(patientid);
                
        try {
            ConnectionDataBase c = new ConnectionDataBase();
            ResultSet rs = c.s.executeQuery("select * from patient");
            while(rs.next()) {
                patientid.add(rs.getString("p_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                
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
        
        t1 = new JLabel();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JLabel();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        
        JLabel dateChooser = new JLabel();
	dateChooser.setForeground(new Color(105, 105, 105));
        
        r1 = new JLabel();
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        
        r2 = new JLabel();
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        
         try {
            ConnectionDataBase c = new ConnectionDataBase();
            String query = "select * from patient where p_id='"+patientid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                t1.setText(rs.getString("p_name"));
                t2.setText(rs.getString("age"));
                dateChooser.setText(rs.getString("dob"));
                r1.setText(rs.getString("gender"));
                
                t3.setText(rs.getString("email"));
                t4.setText(rs.getString("contact_no"));
                t5.setText(rs.getString("address"));
               
            }
         }catch (Exception e) {
                    e.printStackTrace();
         }
         
         patientid.addItemListener(new ItemListener() {
             public void itemStateChanged(ItemEvent ie) {
                try {
                    ConnectionDataBase c = new ConnectionDataBase();
                    String query = "select * from patient where p_id='"+patientid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                t1.setText(rs.getString("p_name"));
                t2.setText(rs.getString("age"));
                dateChooser.setText(rs.getString("dob"));
                r1.setText(rs.getString("gender"));
                
                t3.setText(rs.getString("email"));
                t4.setText(rs.getString("contact_no"));
                t5.setText(rs.getString("address"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));      
        
	
        setLayout(null);
               
        l3.setBounds(100,140,100,35);
        add(l3);
        
        t1.setBounds(300,140,400,35);
        t1.setFont(new Font("Raleway", Font.BOLD, 20));
        add(t1);
        
        l4.setBounds(100,190,200,35);
        add(l4);
        
        t2.setBounds(300,190,400,35);
        t2.setFont(new Font("Raleway", Font.BOLD, 20));
        add(t2);
        
        l5.setBounds(100,240,200,35);
        add(l5);
        
        dateChooser.setBounds(300, 240, 400, 35);
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dateChooser);
        
        l6.setBounds(100,290,200,35);
        add(l6);
        
        r1.setBounds(300,290,90,35);
        r1.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally
        r1.setFont(new Font("Raleway", Font.BOLD, 20));
        add(r1);
                
        l7.setBounds(100,340,200,35);
        add(l7);
        
        t3.setBounds(300,340,400,35);
        t3.setFont(new Font("Raleway", Font.ITALIC, 18));
        add(t3);
             
        l8.setBounds(100,400,200,35);
        add(l8);
        
        t4.setBounds(300,400,400,35);
        t4.setFont(new Font("Raleway", Font.ITALIC, 18));
        add(t4);
        
        l9.setBounds(100,440,200,35);
        add(l9);
        
        t5.setBounds(300,440,400,65);
        t5.setFont(new Font("Raleway", Font.ITALIC, 18));
        add(t5);
        
      //submit button
        submit.setBounds(250,550,120,30);
        submit.addActionListener(this); 
        add(submit);
        
        //cancel button
        cancel.setBounds(450, 550, 120, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
   
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == submit) {
        String p_id = patientid.getSelectedItem();

        String email = t3.getText();
        String contact_no = t4.getText();
        String address = t5.getText();
            
            try {
                String query = "update patient set  email='"+email+"', contact_no='"+contact_no+"', address='"+address+"' where p_id='"+p_id+"'";
                ConnectionDataBase c = new ConnectionDataBase();
                 c.s.executeUpdate(query); 
                JOptionPane.showMessageDialog(null, "Updated Successfully");
                setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
         else{
            setVisible(false);
        }
    }
   
    public static void main(String[] args){
        new PatientUpdate().setVisible(true);
    }
    
}

