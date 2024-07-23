import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        JFrame frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, frame);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 20, 165, 25);
        panel.add(nameText);

        JLabel userLabel = new JLabel("Gmail:");
        userLabel.setBounds(10, 50, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 50, 165, 25);
        panel.add(userText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        panel.add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(10, 110, 360, 25);
        panel.add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText().trim();
                String gmail = userText.getText().trim();
                if (!name.isEmpty() && !gmail.isEmpty()) {
                    messageLabel.setText("Welcome, " + name + "!");
                    frame.dispose();
                    redirectConsoleProgram(name, gmail);
                } else {
                    messageLabel.setText("Error: Please enter both name and a valid Gmail address.");
                }
            }
        });
    }

    private static void redirectConsoleProgram(String name, String gmail) {
        System.out.println("\nWelcome, " + name + "!");
        System.out.println("You are logged in with Gmail: " + gmail);

        Scanner scanner = new Scanner(System.in);

        // Ask for boarding station
        System.out.print("Enter your boarding station: ");
        String boardingStation = scanner.nextLine();

        // Ask for destination
        System.out.print("Enter your destination: ");
        String destination = scanner.nextLine();

        System.out.println("Boarding station: " + boardingStation);
        System.out.println("Destination: " + destination);

        // Rest of your logic
        Train[] trains = TrainBookingSystem.createTrains();
        TrainBookingSystem.runTrainBookingSystem(trains, scanner);
        scanner.close();
    }
}
