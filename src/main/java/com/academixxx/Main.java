package com.academixxx;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        showMenu();
    }

    static void showMenu() {
        while (true) {

            String input = JOptionPane.showInputDialog(null, """
                            Choose action:
                            
                            1. Register new rescue
                            2. Manage animals
                            3. Manage medical records
                            4. Manage adoptions
                            5. Manage volunteers
                            6. Reports & schedules
                            7. Exit""",
                    "Animal Rescue Management System!",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                break;
            }

            try {

                int choice = Integer.parseInt(input);

                if (choice == 7) {
                    break;
                } else if (choice == 1) {
                    //
                } else if (choice == 2) {

                } else if (choice == 3) {
                    //
                } else if (choice == 4) {
                    //
                } else if (choice == 5) {
                    //
                } else if (choice == 6) {
                    //
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid choice.");
                }
            } catch (NumberFormatException e) {
                // Not an integer
                JOptionPane.showMessageDialog(null, "Please enter a number.");
            }

        }
    }
}