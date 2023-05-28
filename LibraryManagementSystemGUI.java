import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryManagementSystemGUI{
    // GUI Components
    private JFrame frame;
    private JButton searchButton;
    private JTextField searchField;
    private JTextArea resultArea;

    // Sample book data
    private String[][] books = {
        {"001", "The Catcher in the Rye", "J.D. Salinger"},
        {"002", "To Kill a Mockingbird", "Harper Lee"},
        {"003", "1984", "George Orwell"},
        {"004", "The Great Gatsby", "F. Scott Fitzgerald"},
        // Add more books here...
    };

    public LibraryManagementSystemGUI() {
        // Create and set up the frame
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // Create components
        searchButton = new JButton("Search");
        searchField = new JTextField();
        resultArea = new JTextArea();

        // Add components to the frame
        frame.add(searchField, BorderLayout.NORTH);
        frame.add(searchButton, BorderLayout.CENTER);
        frame.add(resultArea, BorderLayout.SOUTH);

        // Add action listener to the search button
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform search operation
                String searchTerm = searchField.getText();
                String result = performSearch(searchTerm);
                resultArea.setText(result);
            }
        });
    }

    // Method to perform the search operation
    private String performSearch(String searchTerm) {
        StringBuilder result = new StringBuilder("Search results for: " + searchTerm + "\n");
        for (String[] book : books) {
            if (book[0].equals(searchTerm) || book[1].toLowerCase().contains(searchTerm.toLowerCase()) ||
                    book[2].toLowerCase().contains(searchTerm.toLowerCase())) {
                result.append(book[0]).append(" - ").append(book[1]).append(" by ").append(book[2]).append("\n");
            }
        }
        return result.toString();
    }

    public void show() {
        // Display the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create and show the GUI
        LibraryManagementSystemGUI gui = new LibraryManagementSystemGUI();
        gui.show();
    }
}
