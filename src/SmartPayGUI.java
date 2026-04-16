import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartPayGUI extends JFrame {

    // UI Components
    private JTextField customerNameField;
    private JTextField prevReadingField;
    private JTextField currentReadingField;
    private JTextArea billTextArea;
    private JButton calculateButton;
    private JButton clearButton;

    public SmartPayGUI() {
        setTitle("SmartPay Bill Calculator");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Input Interface
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Customer Name:"));
        customerNameField = new JTextField();
        inputPanel.add(customerNameField);

        inputPanel.add(new JLabel("Previous Meter Reading:"));
        prevReadingField = new JTextField();
        inputPanel.add(prevReadingField);

        inputPanel.add(new JLabel("Current Meter Reading:"));
        currentReadingField = new JTextField();
        inputPanel.add(currentReadingField);

        calculateButton = new JButton("Calculate Bill");
        clearButton = new JButton("Clear");
        inputPanel.add(calculateButton);
        inputPanel.add(clearButton);

        // Bill Interface
        billTextArea = new JTextArea();
        billTextArea.setEditable(false);
        billTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(billTextArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Bill Receipt"));

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Button implementation
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBill();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

   
    private void calculateBill() {
        String custName = customerNameField.getText().trim();
        if (custName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid name.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double prevMeter, currMeter;
        try {
            prevMeter = Double.parseDouble(prevReadingField.getText().trim());
            currMeter = Double.parseDouble(currentReadingField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for meter readings.", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (prevMeter < 0 || currMeter < 0) {
            JOptionPane.showMessageDialog(this, "Meter reading should not be less than zero.", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (prevMeter > currMeter) {
            JOptionPane.showMessageDialog(this, "Previous reading cannot be greater than the current reading.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Customer person = new Customer(custName, prevMeter, currMeter);
        BillCalculator myBill = new BillCalculator(person);

        // Bill receipt ui.
        StringBuilder billText = new StringBuilder();
        billText.append("--- SmartPay Bill Receipt ---\n\n");
        billText.append(String.format("%-20s: %s\n", "Customer Name", person.getPersonName()));
        billText.append(String.format("%-20s: %.2f units\n", "Previous Reading", person.getMeterBefore()));
        billText.append(String.format("%-20s: %.2f units\n", "Current Reading", person.getMeterNow()));
        billText.append(String.format("%-20s: %.2f units\n", "Total Units Used", person.getTotalUnits()));
        billText.append("----------------------------------------\n");
        billText.append(String.format("%-20s: $%.2f\n", "Base Amount", myBill.calcCharge()));
        billText.append(String.format("%-20s: $%.2f\n", "Tax (10%)", myBill.calcTax()));
        billText.append("----------------------------------------\n");
        billText.append(String.format("%-20s: $%.2f\n", "Total Bill Amount", myBill.calculateTotal()));
        billText.append("----------------------------------------\n\n");
        billText.append("Thank you for using SmartPay!\n");

        billTextArea.setText(billText.toString());
    }


    private void clearFields() {
        customerNameField.setText("");
        prevReadingField.setText("");
        currentReadingField.setText("");
        billTextArea.setText("");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SmartPayGUI().setVisible(true);
            }
        });
    }
}
