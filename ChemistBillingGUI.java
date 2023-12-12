package pharmacysystem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChemistBillingGUI extends JFrame {

    private JTextField billNoField;
    private JTextField dateField;
    private JTextField nameField;
    private JTextField PidField;

    private JTable medicineTable;
    private DefaultTableModel tableModel;

    private JTextField totalField;

    public ChemistBillingGUI() {
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
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(addMedicineButton);
        buttonPanel.add(generateBillButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void addMedicine() {
        // Add a new row to the table for medicine details
        tableModel.addRow(new Object[]{"", "", "", ""});
    }

    private void generateBill() {
        String billNo = billNoField.getText();
        String date = dateField.getText();
        String customerName = nameField.getText();
        String PId = PidField.getText();;

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

    private void showBillFrame() {
        JFrame billFrame = new JFrame("Generated Bill");
        billFrame.setSize(400, 300);
        billFrame.setLocationRelativeTo(this);

        JTextArea billTextArea = new JTextArea();
        billTextArea.setEditable(false);
        billTextArea.append("Bill No: " + billNoField.getText() + "\n");
        billTextArea.append("Date: " + dateField.getText() + "\n");
        billTextArea.append("Customer Name: " + nameField.getText() + "\n");
        billTextArea.append("Prescription_id"+ PidField.getText()+ "\n");
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

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChemistBillingGUI().setVisible(true);
            }
        });
    }
}







