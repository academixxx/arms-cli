package com.academixxx;

import com.academixxx.models.RescueEvent;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder manager for registering and listing rescue events.
 * TODO: connect to AnimalManager to auto-create rescued animals and link ids.
 */
public class RescueManager {
    private final List<RescueEvent> events = new ArrayList<>();
    private int nextId = 1;

    public void registerRescue() {
        String animalIdStr = JOptionPane.showInputDialog("Enter animal ID involved in rescue:");
        String location = JOptionPane.showInputDialog("Enter location:");
        String rescuer = JOptionPane.showInputDialog("Enter rescuer name:");
        if (animalIdStr == null || location == null || rescuer == null) return;
        try {
            int animalId = Integer.parseInt(animalIdStr);
            RescueEvent event = new RescueEvent(nextId++, animalId, location, rescuer, LocalDate.now());
            events.add(event);
            JOptionPane.showMessageDialog(null, "Rescue recorded:\n" + event);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid animal ID.");
        }
    }

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
