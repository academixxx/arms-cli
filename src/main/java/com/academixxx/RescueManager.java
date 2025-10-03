package com.academixxx;

import com.academixxx.models.Animal;
import com.academixxx.models.RescueEvent;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Rescue manager for registering and listing rescue events.
 */
public class RescueManager {
    // Container of events
    private final List<RescueEvent> events = new ArrayList<>();
    // Instance of AnimalManager
    private final AnimalManager animalManager;
    private int nextId = 1;

    // Set parameter to get the AnimalManager
    public RescueManager(AnimalManager animalManager) {
        this.animalManager = animalManager;
    }

    public void registerRescue() {
        // Asks if the animal exist or new
        String mode = JOptionPane.showInputDialog("Is this a new animal? (y/n)");
        if (mode == null) return;

        int animalId;

        if (mode.equalsIgnoreCase("y")) {
            // Animal is new
            String type = JOptionPane.showInputDialog("Enter animal type:");
            String condition = JOptionPane.showInputDialog("Enter condition:");
            if (type == null || condition == null) return;
            // rescued status for new rescues
            Animal animal = animalManager.createAnimal(type, condition, "Rescued");
            animalId = animal.id();
        } else if (mode.equalsIgnoreCase("n")) {
            // Animal exists
            String animalIdStr = JOptionPane.showInputDialog("Enter existing animal ID:");
            if (animalIdStr == null) return;
            try {
                int id = Integer.parseInt(animalIdStr);
                if (animalManager.findById(id) == null) {
                    JOptionPane.showMessageDialog(null, "Animal ID not found.");
                    return;
                }
                animalId = id;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid animal ID.");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please answer 'y' or 'n'.");
            return;
        }

        String location = JOptionPane.showInputDialog("Enter location:");
        String rescuer = JOptionPane.showInputDialog("Enter rescuer name:");
        if (location == null || rescuer == null) return;

        // Add the event to the list
        RescueEvent event = new RescueEvent(nextId++, animalId, location, rescuer, java.time.LocalDate.now());
        events.add(event);
        // Display the newly added event
        JOptionPane.showMessageDialog(null,
                "Location: " + location + "\nRescuer: " + rescuer + "\nDate: " + event.date(),
                "Rescue Recorded", JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Displays the list of rescues recorded.
     */
    public void listRescues() {
        if (events.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No rescue events recorded yet.");
            return;
        }
        StringBuilder sb = new StringBuilder("Rescue Events:\n");
        for (RescueEvent e : events) {
            sb.append(e).append('\n');
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
