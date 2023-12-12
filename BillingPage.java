package pharmacysystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BillingPage extends JFrame {

    private JTextField billNoField;
    private JTextField dateField;
    private JTextField nameField;
    private JTextField PidField;

    private JTable medicineTable;
    private DefaultTableModel tableModel;

    private JTextField totalField;
    private JButton cancelButton;
    private JButton exitButton;
    private JButton printButton; // New variable for the Print button

    public BillingPage() {
        setTitle("Chemist Shop Billing");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(4, 2));

        JLabel billNoLabel = new JLabel("Bill No:");
        billNoField = new JTextField();

        JLabel dateLabel = new JLabel("Date:");
        dateField = new JTextField();
        dateField.setEditable(false);
        dateField.setText(getCurrentDate());

        JLabel nameLabel = new JLabel("Customer Name:");
        nameField = new JTextField();

        JLabel prescription = new JLabel("Prescription Id:");
        PidField = new JTextField();

        topPanel.add(billNoLabel);
        topPanel.add(billNoField);
        topPanel.add(dateLabel);
        topPanel.add(dateField);
        topPanel.add(nameLabel);
        topPanel.add(nameField);
        topPanel.add(prescription);
        topPanel.add(PidField);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Create a table for medicine details
        String[] columnNames = {"Medicine Name", "Quantity", "Price", "Total"};
        tableModel = new DefaultTableModel(columnNames, 0);
        medicineTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(medicineTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton addMedicineButton = new JButton("Add Medicine");
        addMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMedicine();
            }
        });

        JButton generateBillButton = new JButton("Generate Bill");
        generateBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateBill();
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelBill();
            }
        });

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitApplication();
            }
        });

        printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printBill();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addMedicineButton);
        buttonPanel.add(generateBillButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(printButton); // Add Print button to the panel

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        totalField = new JTextField();
        totalField.setEditable(false);

        // Add a window listener to handle closing the application
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApplication();
            }
        });
    }

    private void addMedicine() {
        // Add a new row to the table for medicine details
        tableModel.addRow(new Object[]{"", "", "", ""});
    }

    private void generateBill() {
        String billNo = billNoField.getText();
        String date = dateField.getText();
        String customerName = nameField.getText();
        String PId = PidField.getText();

        // Perform billing logic here
        // You can iterate over the rows of the table and calculate the total

        // For demonstration, let's display a message with the bill details
        String message = "Bill No: " + billNo + "\n"
                + "Date: " + date + "\n"
                + "Customer Name: " + customerName + "\n" + "Prescription_Id: " + PId + "\n";

        for (int row = 0; row < tableModel.getRowCount(); row++) {
            String medicineName = (String) tableModel.getValueAt(row, 0);
            int quantity = Integer.parseInt((String) tableModel.getValueAt(row, 1));
            double price = Double.parseDouble((String) tableModel.getValueAt(row, 2));
            double total = quantity * price;

            message += "Medicine: " + medicineName + ", Quantity: " + quantity +
                    ", Price: " + price + ", Total: " + total + "\n";
        }

        JOptionPane.showMessageDialog(this, message);
        showBillFrame();
    }

    private void cancelBill() {
        // Set default values or disable fields as needed
        billNoField.setText("");
        dateField.setText(getCurrentDate());
        nameField.setText("");
        PidField.setText("");
        totalField.setText("");

        // Remove all rows from the table
        tableModel.setRowCount(0);
    }

    private void showBillFrame() {
        JFrame billFrame = new JFrame("Generated Bill");
        billFrame.setSize(400, 300);
        billFrame.setLocationRelativeTo(this);

        JTextArea billTextArea = new JTextArea();
        billTextArea.setEditable(false);
        billTextArea.append("Bill No: " + billNoField.getText() + "\n");
        billTextArea.append("Date: " + dateField.getText() + "\n");
        billTextArea.append("Customer Name: " + nameField.getText() + "\n");
        billTextArea.append("Prescription_id" + PidField.getText() + "\n");
        billTextArea.append("Medicine Details:\n");

        for (int row = 0; row < tableModel.getRowCount(); row++) {
            String medicineName = (String) tableModel.getValueAt(row, 0);
            int quantity = Integer.parseInt((String) tableModel.getValueAt(row, 1));
            double price = Double.parseDouble((String) tableModel.getValueAt(row, 2));
            double total = quantity * price;

            billTextArea.append("Medicine: " + medicineName + ", Quantity: " + quantity +
                    ", Price: " + price + ", Total: " + total + "\n");
        }

        billTextArea.append("Total Price: " + totalField.getText());

        JScrollPane scrollPane = new JScrollPane(billTextArea);
        billFrame.add(scrollPane);

        billFrame.setVisible(true);
    }

    private void exitApplication() {
        // Display a confirmation dialog before exiting
        int response = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to exit?", "Exit",
                JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            // Close the application
            System.exit(0);
        }
    }

    private void printBill() {
        // Invoke system's print dialog
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        PrintJob printJob = toolkit.getPrintJob(this, "Print Bill", null);
        if (printJob != null) {
            Graphics graphics = printJob.getGraphics();
            if (graphics != null) {
                // Print the content you want
                print(graphics);
                graphics.dispose();
            }
            printJob.end();
        }
    }

    public void print(Graphics graphics) {
        // Customize the content you want to print
        // For example, you can print the bill details
        // You may need to adjust the coordinates and formatting based on your content
        graphics.drawString("Bill No: " + billNoField.getText(), 100, 100);
        graphics.drawString("Date: " + dateField.getText(), 100, 120);
        graphics.drawString("Customer Name: " + nameField.getText(), 100, 140);
        graphics.drawString("Prescription_id" + PidField.getText(), 100, 160);
        
        int yOffset = 180;
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            String medicineName = (String) tableModel.getValueAt(row, 0);
            int quantity = Integer.parseInt((String) tableModel.getValueAt(row, 1));
            double price = Double.parseDouble((String) tableModel.getValueAt(row, 2));
            double total = quantity * price;

            graphics.drawString("Medicine: " + medicineName + ", Quantity: " + quantity +
                    ", Price: " + price + ", Total: " + total, 100, yOffset);
            yOffset += 20;
        }

        graphics.drawString("Total Price: " + totalField.getText(), 100, yOffset);
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BillingPage().setVisible(true);
            }
        });
    }
}
