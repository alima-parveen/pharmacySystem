
package pharmacysystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

public class PatientDetails extends JFrame implements ActionListener{
    
    Choice patientid;
    JTable table;
    JButton search, print, update, add, cancel,delete;
    JLabel heading;
    JTableHeader header;
    
    PatientDetails(){
        
//        getContentPane().setBackground(new Color(252, 228, 236));
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1000,1100);
        setLocation(300,20);
        
        setTitle("PATIENT RECORD");
        
        heading = new JLabel ("Search by Patient_Id ");
        heading.setBounds (20, 20, 150, 20);
        add(heading);
        
        patientid = new Choice();
        patientid.setBounds(180, 20, 150, 20);
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
        
        table = new JTable();
        table.setBackground(new Color(225, 245, 254 )); // Use color
        table.setForeground(Color.BLACK); // Use text color

        // Set header background color
        header = table.getTableHeader();
        header.setBackground(new Color(31, 97, 141)); // Header background color

        // Set header text color
        header.setForeground(Color.BLACK); // Header text color
        
        try {
            ConnectionDataBase c = new ConnectionDataBase();
            ResultSet rs = c.s.executeQuery("select * from patient");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(2, 100, 998, 1100);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(360, 20, 80, 20);
        search.setBackground(new Color(31, 97, 141)); // Button background color
        search.setForeground(Color.WHITE); // Button text color
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.setBackground(new Color(31, 97, 141)); // Button background color
        print.setForeground(Color.WHITE); // Button text color
        print.addActionListener(this);
        add(print);
        
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.setBackground(new Color(31, 97, 141)); // Button background color
        add.setForeground(Color.WHITE); // Button text color
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.setBackground(new Color(31, 97, 141)); // Button background color
        update.setForeground(Color.WHITE); // Button text color
        update.addActionListener(this); // Commented out as per your code
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(520, 70, 80, 20);
        cancel.setBackground(new Color(31, 97, 141)); // Button background color
        cancel.setForeground(Color.WHITE); // Button text color
        cancel.addActionListener(this);
        add(cancel);
        
        delete = new JButton("Delete");
        delete.setBounds(420, 70, 80, 20);
        delete.setBackground(new Color(31, 97, 141)); // Button background color
        delete.setForeground(Color.WHITE); // Button text color
        delete.addActionListener(this);
        add(delete);

        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from patient where p_id = '"+patientid.getSelectedItem()+"'";
            try {
                ConnectionDataBase c = new ConnectionDataBase();
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
        } else if (ae.getSource() == add) {
            setVisible(true);
            new PatientRegistration();
        } else if (ae.getSource() == update) {
            setVisible(true);
            new PatientUpdate();
        } else if (ae.getSource() == delete) {
            setVisible(true);
            new PatientDelete();
        }
        else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new PatientDetails().setVisible(true);
    }
    
}
