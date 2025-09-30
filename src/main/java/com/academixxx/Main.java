package com.academixxx;

import javax.swing.*;

public class Main {
    private static final AnimalManager animalManager = new AnimalManager();
    private static final RescueManager rescueManager = new RescueManager(animalManager);
    private static final MedicalRecordManager medicalRecordManager = new MedicalRecordManager();
    private static final AdoptionManager adoptionManager = new AdoptionManager();
    private static final VolunteerManager volunteerManager = new VolunteerManager();
    private static final ReportService reportService = new ReportService();

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
                    showRescueMenu();
                } else if (choice == 2) {
                    showAnimalMenu();
                } else if (choice == 3) {
                    showMedicalMenu();
                } else if (choice == 4) {
                    showAdoptionMenu();
                } else if (choice == 5) {
                    showVolunteerMenu();
                } else if (choice == 6) {
                    showReportsMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid choice.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number.");
            }
        }
    }

    private static void showRescueMenu() {
        while (true) {
            String input = JOptionPane.showInputDialog(null, """
                            Rescue Menu:
                            1. Register new rescue
                            2. List rescues
                            3. Back""",
                    "Rescues",
                    JOptionPane.QUESTION_MESSAGE);
            if (input == null) return;
            try {
                int c = Integer.parseInt(input);
                if (c == 3) return;
                if (c == 1) rescueManager.registerRescue();
                else if (c == 2) rescueManager.listRescues();
                else JOptionPane.showMessageDialog(null, "Invalid choice.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number.");
            }
        }
    }

    private static void showAnimalMenu() {
        while (true) {
            String input = JOptionPane.showInputDialog(null, """
                            Animal Menu:
                            1. Register animal
                            2. List animals
                            3. Back""",
                    "Animals",
                    JOptionPane.QUESTION_MESSAGE);
            if (input == null) return;
            try {
                int c = Integer.parseInt(input);
                if (c == 3) return;
                if (c == 1) animalManager.addAnimal();
                else if (c == 2) animalManager.listAnimals();
                else JOptionPane.showMessageDialog(null, "Invalid choice.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number.");
            }
        }
    }

    private static void showMedicalMenu() {
        while (true) {
            String input = JOptionPane.showInputDialog(null, """
                            Medical Records Menu:
                            1. Add medical record
                            2. List medical records
                            3. Back""",
                    "Medical Records",
                    JOptionPane.QUESTION_MESSAGE);
            if (input == null) return;
            try {
                int c = Integer.parseInt(input);
                if (c == 3) return;
                if (c == 1) medicalRecordManager.addRecord();
                else if (c == 2) medicalRecordManager.listRecords();
                else JOptionPane.showMessageDialog(null, "Invalid choice.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number.");
            }
        }
    }

    private static void showAdoptionMenu() {
        while (true) {
            String input = JOptionPane.showInputDialog(null, """
                            Adoptions Menu:
                            1. Create adoption request
                            2. List adoption requests
                            3. Back""",
                    "Adoptions",
                    JOptionPane.QUESTION_MESSAGE);
            if (input == null) return;
            try {
                int c = Integer.parseInt(input);
                if (c == 3) return;
                if (c == 1) adoptionManager.createRequest();
                else if (c == 2) adoptionManager.listRequests();
                else JOptionPane.showMessageDialog(null, "Invalid choice.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number.");
            }
        }
    }

    private static void showVolunteerMenu() {
        while (true) {
            String input = JOptionPane.showInputDialog(null, """
                            Volunteers Menu:
                            1. Add volunteer
                            2. List volunteers
                            3. Back""",
                    "Volunteers",
                    JOptionPane.QUESTION_MESSAGE);
            if (input == null) return;
            try {
                int c = Integer.parseInt(input);
                if (c == 3) return;
                if (c == 1) volunteerManager.addVolunteer();
                else if (c == 2) volunteerManager.listVolunteers();
                else JOptionPane.showMessageDialog(null, "Invalid choice.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number.");
            }
        }
    }

    private static void showReportsMenu() {
        while (true) {
            String input = JOptionPane.showInputDialog(null, """
                            Reports & Schedules:
                            1. Animal population report
                            2. Generate and show feeding schedules
                            3. Back""",
                    "Reports & Schedules",
                    JOptionPane.QUESTION_MESSAGE);
            if (input == null) return;
            try {
                int c = Integer.parseInt(input);
                if (c == 3) return;
                if (c == 1) {
                    reportService.reportAnimalPopulation(animalManager.getAnimals());
                } else if (c == 2) {
                    var schedules = reportService.generateFeedingSchedules(animalManager.getAnimals());
                    reportService.showSchedules(schedules);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid choice.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number.");
            }
        }
    }
}