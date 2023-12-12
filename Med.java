package pharmacysystem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Med extends JFrame {

    private JTextField searchBar;
    private JTable resultTable;
    private DefaultTableModel tableModel;

    public Med() {
        // Set up the JFrame
        setTitle("Medicine Search App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Create components
        searchBar = new JTextField();
        JButton searchButton = new JButton("Search");

        // Create table and table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Medicine Name");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Manufacturing Date");
        tableModel.addColumn("Expiry Date");
        tableModel.addColumn("Price");

        resultTable = new JTable(tableModel);

        JScrollPane tableScrollPane = new JScrollPane(resultTable);

        // Set up the layout
        setLayout(new BorderLayout());
        add(searchBar, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(searchButton);
        add(buttonPanel, BorderLayout.SOUTH);

        add(tableScrollPane, BorderLayout.CENTER);

        // Add action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });

        // Display the JFrame
        setVisible(true);
    }

    private void performSearch() {
        // Get the search query from the search bar
        String query = searchBar.getText().toLowerCase();

        // Simulate a database or data source with medicine information
        List<Medicine> medicineList = getMockMedicineData();

        // Clear the existing table data
        tableModel.setRowCount(0);

        // Populate the table with search results
        for (Medicine medicine : medicineList) {
            if (medicine.getName().toLowerCase().contains(query)) {
                Object[] rowData = {medicine.getName(), medicine.getQuantity(),
                        medicine.getManufacturingDate(), medicine.getExpiryDate(), medicine.getPrice()};
                tableModel.addRow(rowData);
            }
        }
    }

    private List<Medicine> getMockMedicineData() {
        // Simulated data for medicine
        List<Medicine> medicineList = new ArrayList<>();

        medicineList.add(new Medicine("MedicineA", 50, "2022-01-01", "2023-01-01", 10.50));
        medicineList.add(new Medicine("MedicineB", 30, "2022-02-01", "2023-02-01", 15.75));
        medicineList.add(new Medicine("MedicineC", 20, "2022-03-01", "2023-03-01", 8.99));

        return medicineList;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Med();
            }
        });
    }
}

class Medicine {
    private String name;
    private int quantity;
    private String manufacturingDate;
    private String expiryDate;
    private double price;

    public Medicine(String name, int quantity, String manufacturingDate, String expiryDate, double price) {
        this.name = name;
        this.quantity = quantity;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public double getPrice() {
        return price;
    }
}

