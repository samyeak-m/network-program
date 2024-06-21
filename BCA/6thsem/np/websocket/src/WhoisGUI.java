import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WhoisGUI extends JFrame {

    private JTextField domainField;
    private JTextArea resultArea;

    public WhoisGUI() {
        setTitle("Whois Lookup");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel domainLabel = new JLabel("Enter Domain:");
        domainField = new JTextField(20);
        domainField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String domain = domainField.getText().trim();
                if (!domain.isEmpty()) {
                    lookupWhois(domain);
                }
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String domain = domainField.getText().trim();
                if (!domain.isEmpty()) {
                    lookupWhois(domain);
                }
            }
        });

        inputPanel.add(domainLabel);
        inputPanel.add(domainField);
        inputPanel.add(submitButton);

        // Panel for result text area
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());

        JLabel resultLabel = new JLabel("Whois Result:");
        resultArea = new JTextArea(20, 50);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        // Adding panels to the main frame
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        // Scroll to top after updating result
        resultArea.setCaretPosition(0);
    }

    private void lookupWhois(String domain) {
        String whoisServer = "whois.verisign-grs.com";
        int port = 43;

        try (Socket socket = new Socket(whoisServer, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send domain query
            out.println(domain);

            // Receive and display response
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }

            // Update GUI with result and scroll to top
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    resultArea.setText(response.toString());
                    resultArea.setCaretPosition(0); // Scroll to top
                }
            });

        } catch (IOException e) {
            // Handle specific exceptions or provide user feedback
            JOptionPane.showMessageDialog(this, "Error performing Whois lookup:\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // For debugging, log the exception
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WhoisGUI gui = new WhoisGUI();
                gui.setVisible(true);
            }
        });
    }
}