package pharmacysystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener {

    public JButton patient, billing, upadtePatient, patientDetails, closePage, deletePatient;

    HomePage() {

        setLocation(300, 50);
        setSize(900, 700);

        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        Image scaledImage = backgroundImage.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 900, 700);
        add(backgroundLabel);

        patient = new JButton("Patient Registration");
        patient.setBounds(40, 40, 300, 60);
        patient.setBackground(Color.BLACK);
        patient.setForeground(Color.WHITE);
        patient.addActionListener(this);
        patient.setHorizontalAlignment(SwingConstants.CENTER);
        patient.setFont(new Font("Tahoma", Font.BOLD, 15));
        backgroundLabel.add(patient);

        billing = new JButton("Billing");
        billing.setBounds(40, 120, 300, 60);
        billing.setBackground(Color.BLACK);
        billing.setForeground(Color.WHITE);
        billing.addActionListener(this);
        billing.setHorizontalAlignment(SwingConstants.CENTER);
        billing.setFont(new Font("Tahoma", Font.BOLD, 15));
        backgroundLabel.add(billing);

        upadtePatient = new JButton("Update Patient");
        upadtePatient.setBounds(40, 200, 300, 60);
        upadtePatient.setBackground(Color.BLACK);
        upadtePatient.setForeground(Color.WHITE);
        upadtePatient.addActionListener(this);
        upadtePatient.setHorizontalAlignment(SwingConstants.CENTER);
        upadtePatient.setFont(new Font("Tahoma", Font.BOLD, 15));
        backgroundLabel.add(upadtePatient);
        
        patientDetails = new JButton("Patient Info");
        patientDetails.setBounds(350, 40, 300, 60);
        patientDetails.setBackground(Color.BLACK);
        patientDetails.setForeground(Color.WHITE);
        patientDetails.addActionListener(this);
        patientDetails.setHorizontalAlignment(SwingConstants.CENTER);
        patientDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
        backgroundLabel.add(patientDetails); 
        
        deletePatient = new JButton("Delete Patient");
        deletePatient.setBounds(350, 120, 300, 60);
        deletePatient.setBackground(Color.BLACK);
        deletePatient.setForeground(Color.WHITE);
        deletePatient.addActionListener(this);
        deletePatient.setHorizontalAlignment(SwingConstants.CENTER);
        deletePatient.setFont(new Font("Tahoma", Font.BOLD, 15));
        backgroundLabel.add(deletePatient); 
        
        closePage = new JButton("LogOut");
        closePage.setBounds(550, 600, 300, 50);
        closePage.setBackground(Color.RED);
        closePage.setForeground(Color.black);
        closePage.addActionListener(this);
        closePage.setHorizontalAlignment(SwingConstants.CENTER);
        closePage.setFont(new Font("Tahoma", Font.BOLD, 15));
        backgroundLabel.add(closePage); 

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Patient Registration")) {
            new PatientRegistration();
        }else if (msg.equals("Patient Info")) {
            new PatientDetails();
        }
        else if (msg.equals("Update Patient")) {
            new PatientUpdate();
        }
        else if (msg.equals("Delete Patient")) {
            new PatientDelete();
        }
        else if (msg.equals("Billing")) {
            BillingPage BillingPage = new BillingPage();
            BillingPage.setVisible(true);
        }
        else if (msg.equals("LogOut")) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
